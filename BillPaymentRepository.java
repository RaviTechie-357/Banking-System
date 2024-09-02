package com.bankingSystem.Baking_Backend.userRepositoryy;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingSystem.Baking_Backend.Entityy.BillPayment;

import jakarta.persistence.Entity;

@Repository
public interface BillPaymentRepository extends JpaRepository<BillPayment, Long> {
    List<BillPayment> findByUserId(Long userId);
}