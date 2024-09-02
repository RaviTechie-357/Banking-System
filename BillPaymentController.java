package com.bankingSystem.Baking_Backend.UserControllerr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingSystem.Baking_Backend.Entityy.BillPayment;
import com.bankingSystem.Baking_Backend.UserService.BillPaymentService;

@RestController
@RequestMapping("/api/billpayments")
@CrossOrigin("http://localhost:4200")
public class BillPaymentController {
 
	
	  @Autowired
	    private BillPaymentService billService;

	    @PostMapping("/create")
	    public ResponseEntity<BillPayment> createBill(@RequestBody BillPayment bill) {
	        return ResponseEntity.ok(billService.createBill(bill));
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<BillPayment> getBillById(@PathVariable Long id) {
	        return ResponseEntity.ok(billService.getBillById(id));
	    }

	    @PostMapping("/pay/{id}")
	    public ResponseEntity<String> payBill(@PathVariable Long id) {
	        billService.payBill(id);
	        return ResponseEntity.ok("Bill paid successfully");
	    }
	    
	    @GetMapping("/all")
	    public List<BillPayment> getAllBillPayments() {
	        return billService.getAllBillPayments();
	    }


}
