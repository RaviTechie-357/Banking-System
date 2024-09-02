package com.bankingSystem.Baking_Backend.UserControllerr;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankingSystem.Baking_Backend.Entityy.Document;
import com.bankingSystem.Baking_Backend.UserService.DocumentService;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin("http://localhost:4200")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    public ResponseEntity<Document> uploadDocument(@RequestBody Document document) {
        System.out.println("Received document: " + document);
        try {
            Document savedDocument = documentService.saveDocument(document);
            return ResponseEntity.ok(savedDocument);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Document>> getDocumentsByUserId(@PathVariable String userId) {
        List<Document> documents = documentService.findByUserId(userId);
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAllDocuments() {
        List<Document> documents = documentService.getAllDocuments();
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/user/{userId}/status")
    public ResponseEntity<List<Document>> getDocumentStatusesByUserId(@PathVariable String userId) {
        List<Document> documents = documentService.findByUserId(userId);
        return ResponseEntity.ok(documents);
    }


    @PostMapping("/updateStatus")
    public ResponseEntity<String> updateDocumentStatus(
            @RequestParam Long id,
            @RequestParam String status) {
        try {
            documentService.updateDocumentStatus(id, status);
            return ResponseEntity.ok("Status updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error updating status: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDocument(@PathVariable Long id) {
        try {
            documentService.deleteDocument(id);
            return ResponseEntity.ok("Document deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting document: " + e.getMessage());
        }
    }



}

