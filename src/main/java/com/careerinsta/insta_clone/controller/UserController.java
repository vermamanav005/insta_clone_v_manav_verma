package com.careerinsta.insta_clone.controller;

import com.careerinsta.insta_clone.entity.User;
import com.careerinsta.insta_clone.service.NewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final NewUserService userService;

    @Autowired
    public UserController(NewUserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users.
    
     */
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    /**
     * Find user by username.
     
     */
    @GetMapping("/{username}")
    public ResponseEntity<User> findUserByUserName(@PathVariable String username) {
        User user = userService.findByUserName(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    /**
     * Update an existing user.
  
     */
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User updatedUser) {
        try {
            User user = userService.updateUser(updatedUser);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    /**
     * Delete a user by ID.
   
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}

