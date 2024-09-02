package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingSystem.Baking_Backend.Entityy.Transaction;
import com.bankingSystem.Baking_Backend.userRepositoryy.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
	
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll(); // Fetch all transactions
    }
    
    public void deleteTransaction(Long transactionId) {
        transactionRepository.deleteById(transactionId);
    }
	
	
	
	
}
