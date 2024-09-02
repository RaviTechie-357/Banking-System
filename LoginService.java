package com.bankingSystem.Baking_Backend.UserService;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingSystem.Baking_Backend.Entityy.Login;
import com.bankingSystem.Baking_Backend.userRepositoryy.LoginRepository;

@Service
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private LoginRepository userRepository;

    public Optional<Login> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean validateUser(String email, String password) {
        logger.info("Attempting to validate user with email: {}", email);

        Optional<Login> user = userRepository.findByEmail(email);
        if (user.isPresent()) {
            logger.info("User found. Checking password...");
            String storedPassword = user.get().getPassword();
            boolean isValid = storedPassword.equals(password);
            logger.info("Password match: {}", isValid);
            return isValid;
        } else {
            logger.warn("User not found with email: {}", email);
            return false;
        }
    }
}
