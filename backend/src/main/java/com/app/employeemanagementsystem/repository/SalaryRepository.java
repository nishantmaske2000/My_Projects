package com.app.employeemanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.employeemanagementsystem.model.Salary;
import com.app.employeemanagementsystem.model.User;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findByUser(User user);
}
