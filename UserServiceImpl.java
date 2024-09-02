package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingSystem.Baking_Backend.Entityy.UserEntity;
import com.bankingSystem.Baking_Backend.userRepositoryy.UserRepository;

@Service
public class UserServiceImpl {
	
	 @Autowired
	    private UserRepository userRepository;

	    public UserEntity saveUser(UserEntity user) {
	        return userRepository.save(user);
	    }

	    public List<UserEntity> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public UserEntity getUserById(Long id) {
	        Optional<UserEntity> optionalUser = userRepository.findById(id);
	        return optionalUser.orElse(null);
	    }

	    public UserEntity updateUser(Long id, UserEntity user) {
	        UserEntity existingUser = userRepository.findById(id).orElse(null);
	        if (existingUser != null) {
	            existingUser.setName(user.getName());
	            existingUser.setAddress(user.getAddress());
	            existingUser.setAddharNumber(user.getAddharNumber());
	            existingUser.setPhoneNumber(user.getPhoneNumber());
	            return userRepository.save(existingUser);
	        }
	        return null;
	    }

	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
	

}
