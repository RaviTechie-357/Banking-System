package com.bankingSystem.Baking_Backend.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankingSystem.Baking_Backend.Entityy.BillPayment;
import com.bankingSystem.Baking_Backend.userRepositoryy.BillPaymentRepository;

@Service
public class BillPaymentService {
	
	
	
	    @Autowired
	    private BillPaymentRepository billPaymentRepository;
	    
	    public BillPayment createBill(BillPayment bill) {
	        return billPaymentRepository.save(bill);
	    }

	    public BillPayment getBillById(Long id) {
	        return billPaymentRepository.findById(id).orElse(null);
	    }

	    public void payBill(Long id) {
	    	BillPayment bill = billPaymentRepository.findById(id).orElse(null);
	        if (bill != null) {
	            bill.setStatus("Paid");
	            billPaymentRepository.save(bill);
	        }
	    }
	    
	    public List<BillPayment> getAllBillPayments() {
	        return billPaymentRepository.findAll(); // Fetch all bill payments
	    }

}
