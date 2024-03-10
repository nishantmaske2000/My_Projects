package com.app.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.employeemanagementsystem.model.LeaveRequest;
import com.app.employeemanagementsystem.model.User;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByUser(User user);
}
