package com.app.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.employeemanagementsystem.model.Salary;
import com.app.employeemanagementsystem.service.SalaryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salaries")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalaryController {
    private final SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @GetMapping
    public ResponseEntity<List<Salary>> getAllSalaries() {
        List<Salary> salaries = salaryService.getAllSalaries();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Salary> getSalaryById(@PathVariable("id") Long id) {
//        Salary salary = salaryService.getSalaryById(id);
//        return new ResponseEntity<>(salary, HttpStatus.OK);
//    }

    @PostMapping("/{id}")
    public ResponseEntity<Salary> saveSalary(@RequestBody Salary salary, @PathVariable("id") Long id) {
        Salary savedSalary = salaryService.saveSalary(salary, id);
        return new ResponseEntity<>(savedSalary, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salary> updateSalary(@PathVariable("id") Long id, @RequestBody Salary salaryDetails) {
        Salary updatedSalary = salaryService.updateSalary(id, salaryDetails);
        return new ResponseEntity<>(updatedSalary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalary(@PathVariable("id") Long id) {
        salaryService.deleteSalary(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/user")
    public ResponseEntity<List<Salary>> getSalariesByUser() {
        List<Salary> salaries = salaryService.findByUser();
        return new ResponseEntity<>(salaries, HttpStatus.OK);
    }
}

