package com.group9.partypulse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;  // Correct the variable name to follow Java conventions

    // Fetch all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Find user by ID
    public User findUserByID(int userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);  // Return null if not found
    }

    // Add a new user
    public void addNewUser(User user) {
        userRepository.save(user);
    }

    // Edit an existing user
    public void editUser(int userId, User user) {
        User existing = findUserByID(userId);
        if (existing != null) {
            // Update the user information with the values from the updated user
            existing.setUserName(user.getUserName());
            existing.setUser_email(user.getUser_email());
            existing.setProfile_des(user.getProfile_des());
            existing.setAccountStatus(user.getAccountStatus());  // Update the account status as well
            userRepository.save(existing);  // Save the updated user to the repository
        }
    }

    // Delete a user by ID
    public void deleteUserByID(int userId) {
        userRepository.deleteById(userId);
    }

    // Search for users by userName (updated method name)
    public List<User> searchUsersByUsername(String userName) {
        return userRepository.findByUserNameContaining(userName);  // Updated method name
    }
}
