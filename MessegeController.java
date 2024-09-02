package com.bankingSystem.Baking_Backend.UserControllerr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingSystem.Baking_Backend.Entityy.Messege;
import com.bankingSystem.Baking_Backend.UserService.MessageService;

@RestController
@RequestMapping("/api/messages")
@CrossOrigin("http://localhost:4200")
public class MessegeController {
	 @Autowired
	    private MessageService messageService;

	    @PostMapping
	    public Messege createMessage(@RequestBody Messege message) {
	        return messageService.createMessage(message);
	    }

	    @GetMapping
	    public List<Messege> getAllMessages() {
	        return messageService.getAllMessages();
	    }
	    
	    @PutMapping("/{id}")
	    public Messege updateMessage(@PathVariable Long id, @RequestBody Messege updatedMessage) {
	        return messageService.updateMessage(id, updatedMessage);
	    }
	    @DeleteMapping("/delete/{id}")
	    public void deleteMessage(@PathVariable Long id) {
	        messageService.deleteMessage(id);
	    }

}
