package com.app.employeemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.employeemanagementsystem.exception.ResourceNotFoundException;
import com.app.employeemanagementsystem.model.Attendance;
import com.app.employeemanagementsystem.model.User;
import com.app.employeemanagementsystem.repository.AttendanceRepository;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private final AttendanceRepository attendanceRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public List<Attendance> findByUser(Long id) {
        User user = userService.getUser(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        return attendanceRepository.findByUser(user);
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Attendance not found"));
    }

    public Attendance approveAttendance(Long id) {
        Attendance attendance = attendanceRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Attendance not found"));
        attendance.setApproved(true);
        return attendanceRepository.save(attendance);
    }

    public Attendance saveAttendance(Attendance attendance) {
        User user = userService.getLoggedInUser();
        attendance.setUser(user);
        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {
        User user = userService.getLoggedInUser();
        attendance.setUser(user);
        attendance.setId(id);
        return attendanceRepository.save(attendance);
    }
}

