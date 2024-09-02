package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingSystem.Baking_Backend.Entityy.Account;
import com.bankingSystem.Baking_Backend.userRepositoryy.AccountRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account updateAccount(Long id, Account updatedAccount) {
        if (accountRepository.existsById(id)) {
            updatedAccount.setId(id);
            return accountRepository.save(updatedAccount);
        }
        return null;
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
    
    public Optional<Account> getUserProfile(Long id, String accountNumber) {
        return accountRepository.findByIdAndAccountNumber(id, accountNumber);
    }

    
}
