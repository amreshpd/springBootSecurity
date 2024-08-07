package com.nt.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankOperationController {

	@GetMapping("/welcome")
	public ResponseEntity<String> showHomePage(){
		return new ResponseEntity<String>("welcome to Mr. AK::",HttpStatus.OK);
	}
	@GetMapping("/offers")
	public ResponseEntity<String> showOffers(){
		return new ResponseEntity<String>("Offers Page",HttpStatus.OK);
	}
	@GetMapping("/loan_approve")
	@PreAuthorize("hasAuthority('MANAGER')") //specifying authority
	public ResponseEntity<String> approveLoan(){
		int amount=new Random().nextInt(100000);
		return new ResponseEntity<String>("Loan Approved The amount is::"+amount,HttpStatus.OK);
	}
	@GetMapping("/balance")
	@PreAuthorize("hasAuthority('MANAGER','CUSTOMER')") //specifying authority
	public ResponseEntity<String> showBalance(){
		int amount=new Random().nextInt(500000);
		return new ResponseEntity<String>("balance is::"+amount,HttpStatus.OK);
	}
	
}
