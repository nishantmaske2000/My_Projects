package com.app.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.employeemanagementsystem.model.Attendance;
import com.app.employeemanagementsystem.model.User;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByUser(User user);
}
