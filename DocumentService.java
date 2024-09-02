package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingSystem.Baking_Backend.Entityy.Document;
import com.bankingSystem.Baking_Backend.userRepositoryy.DocumentRepository;

@Service
public class DocumentService {


    @Autowired
    private DocumentRepository documentRepository;

    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        List<Document> documents = documentRepository.findAll();
        System.out.println("Documents from repository: " + documents);
        return documents;
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id).orElse(null);
    }
    
    public List<Document> findByUserId(String userId) {
        return documentRepository.findByUserId(userId);
    }

    public void updateDocumentStatus(Long id, String status) {
        System.out.println("Updating document status. ID: " + id + ", Status: " + status);
        Document document = getDocumentById(id);
        if (document != null) {
            document.setStatus(status);
            documentRepository.save(document);
            // Here you can add code to notify the user about the status update
        } else {
            System.out.println("Document not found with ID: " + id);
        }
    }

    public void deleteDocument(Long id) {
        Document document = getDocumentById(id);
        if (document != null) {
            documentRepository.deleteById(id);
        } else {
            System.out.println("Document not found with ID: " + id);
        }
    }
}


   
