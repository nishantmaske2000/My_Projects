package com.app.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.employeemanagementsystem.model.Attendance;
import com.app.employeemanagementsystem.service.AttendanceService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendances")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttendanceController {
    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances() {
        List<Attendance> attendances = attendanceService.getAllAttendances();
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        Attendance attendance = attendanceService.getAttendanceById(id);
        return new ResponseEntity<>(attendance, HttpStatus.OK);
    }


    @GetMapping("/by-user/{id}")
    public ResponseEntity<?> getAttendanceByUser(@PathVariable Long id) {
        List<Attendance> attendances = attendanceService.findByUser(id);
        return new ResponseEntity<>(attendances, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        Attendance updatedAttendance = attendanceService.updateAttendance(id, attendance);
        return new ResponseEntity<>(updatedAttendance, HttpStatus.OK);
    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<Attendance> approveAttendance(@PathVariable Long id) {
        Attendance approvedAttendance = attendanceService.approveAttendance(id);
        return new ResponseEntity<>(approvedAttendance, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Attendance> saveAttendance(@RequestBody Attendance attendance) {
        Attendance savedAttendance = attendanceService.saveAttendance(attendance);
        return new ResponseEntity<>(savedAttendance, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

