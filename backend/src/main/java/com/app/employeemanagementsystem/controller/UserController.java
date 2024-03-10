package com.app.employeemanagementsystem.controller;

import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.app.employeemanagementsystem.dto.LoginRequest;
import com.app.employeemanagementsystem.dto.PasswordResetRequest;
import com.app.employeemanagementsystem.dto.UserDto;
import com.app.employeemanagementsystem.dto.VerifyOtpDto;
import com.app.employeemanagementsystem.service.UserService;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getALl(){
        return status(200).body(userService.findAll());
    }

    @GetMapping("/logged-in-user")
    public ResponseEntity<?> getLoggedInUser(){
        return status(200).body(userService.getLoggedInUser());
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserDto userDto) throws MessagingException {
        return status(201).body(userService.signup(userDto));
    }

    @GetMapping("/verify-otp/{otp}/{email}")
    public ResponseEntity<?> verifyOtp(@PathVariable("otp") String otp, @PathVariable("email") String email) {
        return status(201).body(userService.verifyOtp(email, Long.parseLong(otp)));
    }

    @GetMapping("/verify-otp-password/{otp}/{email}")
    public ResponseEntity<?> verifyOtpPassword(@PathVariable("otp") Long otp, @PathVariable("email") String email) {
        return status(201).body(userService.verifyOtpPassword(email, otp));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest){
        return status(200).body(userService.login(loginRequest));
    }

    @PutMapping("/verify-user/{email}")
    public ResponseEntity<?> verifyUser(@PathVariable("email") String email){
        return status(200).body(userService.verifyUser(email));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable("id") Long id){
        return status(200).body(userService.updateUser(userDto, id));
    }

    @PutMapping("/reset-password")
    public ResponseEntity<?> changePassword(@RequestBody PasswordResetRequest request) throws MessagingException {
        return status(200).body(userService.changePassword(request));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> delete(){
        return status(200).body(userService.deleteUser());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id){
        return status(200).body(userService.deleteById(id));
    }
}
