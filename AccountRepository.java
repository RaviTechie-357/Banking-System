package com.bankingSystem.Baking_Backend.userRepositoryy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingSystem.Baking_Backend.Entityy.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByIdAndAccountNumber(Long id, String accountNumber);

}