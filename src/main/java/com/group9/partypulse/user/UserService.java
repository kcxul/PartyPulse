package com.group9.partypulse.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo UserRepository;

    public List<User> getAllUsers() {
        return UserRepository.findAll();
    }

    public User findUserByID(int user_id) {
        Optional<User> user = UserRepository.findById(user_id);
        return user.orElse(null);
    }

    public void addNewUser(User user) {
        UserRepository.save(user);
    }

    public void editUser(int user_id, User user) {
        User existing = findUserByID(user_id);
        if (existing != null) {
            existing.setUserName(user.getUserName());
            existing.setProfile_info(user.getProfile_info());
            UserRepository.save(existing);
        }
    }

    public void deleteUserByID(int user_id) {
        UserRepository.deleteById(user_id);
    }
}