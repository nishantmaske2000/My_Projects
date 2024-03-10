package com.app.employeemanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.employeemanagementsystem.exception.ResourceNotFoundException;
import com.app.employeemanagementsystem.model.Salary;
import com.app.employeemanagementsystem.model.User;
import com.app.employeemanagementsystem.repository.SalaryRepository;

import java.util.List;

@Service
public class SalaryService {
    private final SalaryRepository salaryRepository;
    private final UserService userService;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository, UserService userService) {
        this.salaryRepository = salaryRepository;
        this.userService = userService;
    }

    public List<Salary> getAllSalaries() {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(Long id) {
        return salaryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Salary not found with id: " + id));
    }

    public Salary saveSalary(Salary salary, Long id) {
        User user = userService.getUser(id).orElseThrow(()-> new ResourceNotFoundException("Employee not found"));
        salary.setUser(user);
        return salaryRepository.save(salary);
    }

    public Salary updateSalary(Long id, Salary salaryDetails) {
        Salary salary = getSalaryById(id);
        salary.setHouseRentAllowance(salaryDetails.getHouseRentAllowance());
        salary.setFixedAmount(salaryDetails.getFixedAmount());
        salary.setProvidentFund(salaryDetails.getProvidentFund());
        salary.setProfessionalTax(salaryDetails.getProfessionalTax());
        salary.setIncomeTax(salaryDetails.getIncomeTax());
        salary.setSpecialAllowance(salaryDetails.getSpecialAllowance());
        salary.setDateOfPayment(salaryDetails.getDateOfPayment());
        salary.setMonth(salaryDetails.getMonth());
        salary.setYear(salaryDetails.getYear());
        salary.setPaid(salaryDetails.getPaid());
        return salaryRepository.save(salary);
    }

    public void deleteSalary(Long id) {
        Salary salary = getSalaryById(id);
        salaryRepository.delete(salary);
    }

    public List<Salary> findByUser() {
        User user = userService.getLoggedInUser();
        return salaryRepository.findByUser(user);
    }
}

