package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingSystem.Baking_Backend.Entityy.User;
import com.bankingSystem.Baking_Backend.userRepositoryy.UserOnlineBankRepo;


@Service
public class UserOnlineBankService {

    @Autowired
    private UserOnlineBankRepo userRepository;

    public User registerUser(User user) throws Exception {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new Exception("User already registered");
        }
        try {
            return userRepository.save(user);
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            throw new RuntimeException("Error registering user");
        }
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll(); // Fetch all users
    }
    
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    
    
}
