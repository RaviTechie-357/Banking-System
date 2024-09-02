package com.bankingSystem.Baking_Backend.Entityy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Loan {
	
	Loan(){};
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long loanId;
	    private Long userId;
	    private String loanType;
	    private Double loanAmount;
	    private Double interestRate;
	    private String loanStatus;
	    private String repaymentSchedule;
		public Long getLoanId() {
			return loanId;
		}
		public void setLoanId(Long loanId) {
			this.loanId = loanId;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public String getLoanType() {
			return loanType;
		}
		public void setLoanType(String loanType) {
			this.loanType = loanType;
		}
		public Double getLoanAmount() {
			return loanAmount;
		}
		public void setLoanAmount(Double loanAmount) {
			this.loanAmount = loanAmount;
		}
		public Double getInterestRate() {
			return interestRate;
		}
		public void setInterestRate(Double interestRate) {
			this.interestRate = interestRate;
		}
		public String getLoanStatus() {
			return loanStatus;
		}
		public void setLoanStatus(String loanStatus) {
			this.loanStatus = loanStatus;
		}
		public String getRepaymentSchedule() {
			return repaymentSchedule;
		}
		public void setRepaymentSchedule(String repaymentSchedule) {
			this.repaymentSchedule = repaymentSchedule;
		}
		public Loan(Long loanId, Long userId, String loanType, Double loanAmount, Double interestRate,
				String loanStatus, String repaymentSchedule) {
			super();
			this.loanId = loanId;
			this.userId = userId;
			this.loanType = loanType;
			this.loanAmount = loanAmount;
			this.interestRate = interestRate;
			this.loanStatus = loanStatus;
			this.repaymentSchedule = repaymentSchedule;
		}
	

}
