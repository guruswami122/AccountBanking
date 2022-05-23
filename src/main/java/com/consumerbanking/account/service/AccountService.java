package com.consumerbanking.account.service;

import com.consumerbanking.account.dto.AccountRequestDto;
import com.consumerbanking.account.dto.AccountResponseDto;
import com.consumerbanking.account.dto.FundTransferRequestDto;
import com.consumerbanking.account.dto.FundTransferResponseDto;
import com.consumerbanking.account.dto.GooglePayTransferRequestDto;
import com.consumerbanking.account.dto.GooglePayTransferResponseDto;


public interface AccountService {
	
	public AccountResponseDto saveAccountDetails(AccountRequestDto accountRequestDto) ;
	public FundTransferResponseDto performFundTransfer(FundTransferRequestDto fundTransferRequestDto);
	public GooglePayTransferResponseDto performGooglePayFundTransfer(GooglePayTransferRequestDto googlePayTransferRequestDto);
	public Long getAccountNumberByPhoneNumber(Long phoneNumber);


}
