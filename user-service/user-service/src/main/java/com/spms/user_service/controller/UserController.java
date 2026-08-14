package com.spms.user_service.controller;

import com.spms.user_service.dto.UserDTO;
import com.spms.user_service.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.registerUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserDTO> authenticateUser(@RequestParam String email) {
        UserDTO authenticatedUser = userService.authenticateUser(email);
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserProfile(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserProfile(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUserProfile(@PathVariable Long id, @RequestBody UserDTO userDetails) {
        UserDTO updatedUser = userService.updateUserProfile(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
