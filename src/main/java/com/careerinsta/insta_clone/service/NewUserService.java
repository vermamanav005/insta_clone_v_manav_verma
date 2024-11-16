package com.careerinsta.insta_clone.service;

import com.careerinsta.insta_clone.entity.User;
import com.careerinsta.insta_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public NewUserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new user by saving their details to the database.
    
     
     */
    public User registerUser(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepository.save(user);
    }

    /**
     * Finds a user by their username.
     
     */
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    /**
     * Validates if the provided password matches the stored password hash.
    
     */
    public boolean passwordMatches(String inputPassword, String savedPassword) {
        return passwordEncoder.matches(inputPassword, savedPassword);
    }

    /**
     * Retrieves all users from the database.
  
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Updates the details of an existing user.
   
     */
    public User updateUser(User updatedUser) {
        User existingUser = userRepository.findById(updatedUser.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setUserName(updatedUser.getUserName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setBio(updatedUser.getBio());
        existingUser.setGender(updatedUser.getGender());
        existingUser.setProfileImagePath(updatedUser.getProfileImagePath());

        // Update password only if provided
        if (updatedUser.getPasswordHash() != null && !updatedUser.getPasswordHash().isEmpty()) {
            existingUser.setPasswordHash(passwordEncoder.encode(updatedUser.getPasswordHash()));
        }

        return userRepository.save(existingUser);
    }

    /**
     * Deletes a user by their ID.
  
     */
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}


