package com.bankingSystem.Baking_Backend.userRepositoryy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankingSystem.Baking_Backend.Entityy.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByUserId(String userId);
    List<Document> findAll();
}