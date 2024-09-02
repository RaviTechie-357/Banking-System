package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingSystem.Baking_Backend.Entityy.Loan;
import com.bankingSystem.Baking_Backend.userRepositoryy.LoanRepository;


@Service
public class LoanService {
	
	  @Autowired
	    private LoanRepository loanRepository;

	    public Loan applyForLoan(Loan loan) {
	        loan.setLoanStatus("PENDING");
	        loan.setInterestRate(calculateInterestRate(loan.getLoanType()));
	        return loanRepository.save(loan);
	    }

	    public List<Loan> getLoansByUserId(Long userId) {
	        return loanRepository.findByUserId(userId);
	    }

	    public Loan approveLoan(Long loanId) {
	        Loan loan = loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
	        loan.setLoanStatus("APPROVED");
	        return loanRepository.save(loan);
	    }
	    
	    public Loan rejectLoan(Long loanId) {
	        Loan loan = loanRepository.findById(loanId)
	            .orElseThrow(() -> new RuntimeException("Loan not found"));
	        loan.setLoanStatus("REJECTED");
	        return loanRepository.save(loan);
	    }
	    

	    private Double calculateInterestRate(String loanType) {
	        switch (loanType.toLowerCase()) {
	            case "home":
	                return 5.5;
	            case "personal":
	                return 7.0;
	            case "education":
	                return 4.0;
	            default:
	                return 6.0;
	        }
	    }
	    
	    

}
