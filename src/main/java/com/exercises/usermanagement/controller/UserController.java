package com.exercises.usermanagement.controller;

import com.exercises.usermanagement.dto.request.UserRegistrationDTO;
import com.exercises.usermanagement.service.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserService iUserService;

    public UserController(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return ResponseEntity.ok(this.iUserService.registerUser(userRegistrationDTO));
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getUser(@PathVariable String email) {
        return ResponseEntity.ok(this.iUserService.getUser(email));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return ResponseEntity.ok(this.iUserService.updateUser(userRegistrationDTO));
    }


}
