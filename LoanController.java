package com.bankingSystem.Baking_Backend.UserControllerr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingSystem.Baking_Backend.Entityy.Loan;
import com.bankingSystem.Baking_Backend.UserService.LoanService;

@RestController
@RequestMapping("/api/loans")
@CrossOrigin(origins = "http://localhost:4200")
public class LoanController {
	
	 @Autowired
	    private LoanService loanService;

	    @PostMapping("/apply")
	    public ResponseEntity<Loan> applyForLoan(@RequestBody Loan loan) {
	        Loan newLoan = loanService.applyForLoan(loan);
	        return ResponseEntity.ok(newLoan);
	    }

	    @GetMapping("/{userId}")
	    public List<Loan> getLoansByUserId(@PathVariable Long userId) {
	        return loanService.getLoansByUserId(userId);
	    }

	    @PostMapping("/approve/{loanId}")
	    public ResponseEntity<Loan> approveLoan(@PathVariable Long loanId) {
	        Loan approvedLoan = loanService.approveLoan(loanId);
	        return ResponseEntity.ok(approvedLoan);
	    }
	    
	    @PutMapping("/reject/{loanId}")
	    public ResponseEntity<?> rejectLoan(@PathVariable Long loanId) {
	        try {
	            Loan rejectedLoan = loanService.rejectLoan(loanId);
	            return ResponseEntity.ok(rejectedLoan);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                                 .body("Error rejecting loan application.");
	        }
	    }


}
