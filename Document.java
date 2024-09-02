package com.bankingSystem.Baking_Backend.Entityy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "document")
public class Document {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String userId;
	    private String documentType; // Aadhaar, PAN, Light Bill
	    private String filePath; // Path to the saved file
	    private String status; // Pending, Approved, Rejected
	    
	    
	    Document(){};
	    
	    
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getDocumentType() {
			return documentType;
		}
		public void setDocumentType(String documentType) {
			this.documentType = documentType;
		}
		public String getFilePath() {
			return filePath;
		}
		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Document(Long id, String userId, String documentType, String filePath, String status) {
			super();
			this.id = id;
			this.userId = userId;
			this.documentType = documentType;
			this.filePath = filePath;
			this.status = status;
		}


}
