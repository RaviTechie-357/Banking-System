package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingSystem.Baking_Backend.Entityy.Messege;
import com.bankingSystem.Baking_Backend.userRepositoryy.MessegeRepository;

@Service
public class MessageService {
	
	    @Autowired
	    private MessegeRepository repository;

	    
	    public Messege createMessage(Messege messege) {
	        return repository.save(messege);
	    }

	    public List<Messege> getAllMessages() {
	        return repository.findAll();
	    }
	    public Messege updateMessage(Long id, Messege updatedMessage) {
	        Optional<Messege> existingMessage = repository.findById(id);
	        if (existingMessage.isPresent()) {
	            Messege message = existingMessage.get();
	            message.setResponse(updatedMessage.getResponse());
	            return repository.save(message);
	        }
	        return null;
	    }
	    public void deleteMessage(Long id) {
	        if (repository.existsById(id)) {
	        	repository.deleteById(id);
	        }
	    }
}
