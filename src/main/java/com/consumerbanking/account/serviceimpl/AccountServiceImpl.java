package com.consumerbanking.account.serviceimpl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.consumerbanking.account.dto.AccountRequestDto;
import com.consumerbanking.account.dto.AccountResponseDto;
import com.consumerbanking.account.dto.FundTransferRequestDto;
import com.consumerbanking.account.dto.FundTransferResponseDto;
import com.consumerbanking.account.dto.GooglePayTransferRequestDto;
import com.consumerbanking.account.dto.GooglePayTransferResponseDto;
import com.consumerbanking.account.entity.Account;
import com.consumerbanking.account.repository.AccountRepository;
import com.consumerbanking.account.service.AccountService;


@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public AccountResponseDto saveAccountDetails(AccountRequestDto accountRequestDto) {
		// TODO Auto-generated method stub
		Account account=new Account();
		account.setAccountId(accountRequestDto.getAccountId());
		account.setAccountType(accountRequestDto.getAccountType());
		account.setBalance(accountRequestDto.getBalance());
		account.setOpenDate(accountRequestDto.getOpenDate());
		account.setPhoneNumber(accountRequestDto.getPhoneNumber());
		accountRepository.save(account);
		AccountResponseDto accountResponseDto=new AccountResponseDto();
		BeanUtils.copyProperties(account, accountResponseDto);
		return accountResponseDto;
		
		
	}

	@Override
	public FundTransferResponseDto performFundTransfer(FundTransferRequestDto fundTransferRequestDto) {
		// TODO Auto-generated method stub
		Optional<Account> fromAccount=accountRepository.findByAccountNumber(fundTransferRequestDto.getFromAccountNumber());
		Optional<Account> toAccount=accountRepository.findByAccountNumber(fundTransferRequestDto.getToAccountNumber());
		balanceCalculation(fromAccount.get(),toAccount.get(),fundTransferRequestDto.getTransactionType(),fundTransferRequestDto.getAmount());
		return null;

		
	}
	private void balanceCalculation(Account debitAccount,Account creditAccount,String transactionType, BigDecimal amount) {
		 debitAccount.setBalance(debitAccount.getBalance().subtract(amount));
		 creditAccount.setBalance(creditAccount.getBalance().add(amount));
		 accountRepository.save(debitAccount);
		 accountRepository.save(creditAccount);
	}

	@Override
	public GooglePayTransferResponseDto performGooglePayFundTransfer(GooglePayTransferRequestDto googlePayTransferRequestDto) {
		// TODO Auto-generated method stub
		Optional<Account> fromphone=accountRepository.findByPhoneNumber(googlePayTransferRequestDto.getFromPhoneNumber());
		Optional<Account> tophone=accountRepository.findByPhoneNumber(googlePayTransferRequestDto.getToPhoneNumber());
		balanceCalculation(fromphone.get(),tophone.get(),googlePayTransferRequestDto.getTransactionType(),googlePayTransferRequestDto.getAmount());
		return null;
	}

	@Override
	public Long getAccountNumberByPhoneNumber(Long phoneNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findByPhoneNumber(phoneNumber).get().getAccountNumber();
		
	}

}
