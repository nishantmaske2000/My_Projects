package com.app.employeemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.employeemanagementsystem.exception.ResourceNotFoundException;
import com.app.employeemanagementsystem.model.LeaveRequest;
import com.app.employeemanagementsystem.model.User;
import com.app.employeemanagementsystem.repository.LeaveRequestRepository;

import java.util.List;

@Service
public class LeaveRequestService {
    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    @Autowired
    private UserService userService;

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public List<LeaveRequest> findByUser(User user) {
        return leaveRequestRepository.findByUser(user);
    }

    public LeaveRequest getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found with id: " + id));
    }

    public LeaveRequest saveLeaveRequest(LeaveRequest leaveRequest) {
        User user = userService.getLoggedInUser();
        leaveRequest.setUser(user);
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequestDetails) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Leave request not found with id: " + id));

        leaveRequest.setReason(leaveRequestDetails.getReason());
        leaveRequest.setFromDate(leaveRequestDetails.getFromDate());
        leaveRequest.setToDate(leaveRequestDetails.getToDate());
        leaveRequest.setStatus(leaveRequestDetails.getStatus());

        return leaveRequestRepository.save(leaveRequest);
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }

    public List<LeaveRequest> getMyLeaveRequests() {
        User user = userService.getLoggedInUser();
        return leaveRequestRepository.findByUser(user);
    }
}

