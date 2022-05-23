package com.consumerbanking.account.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.consumerbanking.account.dto.AccountRequestDto;
import com.consumerbanking.account.dto.AccountResponseDto;
import com.consumerbanking.account.dto.FundTransferRequestDto;
import com.consumerbanking.account.dto.FundTransferResponseDto;
import com.consumerbanking.account.dto.GooglePayTransferRequestDto;
import com.consumerbanking.account.dto.GooglePayTransferResponseDto;
import com.consumerbanking.account.service.AccountService;



@RestController
@Validated
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@PostMapping("/saveAccountDetails")
	public ResponseEntity<AccountResponseDto> saveAccountDetails(@RequestBody AccountRequestDto accountRequestDto)  {
         return ResponseEntity.status(HttpStatus.OK).body(accountService.saveAccountDetails(accountRequestDto));
}
	@PostMapping("/fundTransfer")
	public ResponseEntity<FundTransferResponseDto> sendAmount(@Valid @RequestBody FundTransferRequestDto fundTransferRequestDto) {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.performFundTransfer(fundTransferRequestDto));
	
		}
	@PostMapping("/googlePayfundTransfer")
	public ResponseEntity<GooglePayTransferResponseDto> performGooglePayFundTransfer(@Valid @RequestBody GooglePayTransferRequestDto googlePayTransferRequestDto) {
		return ResponseEntity.status(HttpStatus.OK).body(accountService.performGooglePayFundTransfer(googlePayTransferRequestDto));
	
		}
    @GetMapping("/getAccountNumber")
    public Long getAccountNumberByPhoneNumber(@RequestParam Long phoneNumber) {
    	return accountService.getAccountNumberByPhoneNumber(phoneNumber);
    	
    }
	
	



}
