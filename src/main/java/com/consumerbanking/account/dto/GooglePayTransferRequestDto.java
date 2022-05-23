package com.consumerbanking.account.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

public class GooglePayTransferRequestDto {
	
	private BigDecimal amount;
	private Long fromPhoneNumber;
	private Long toPhoneNumber;
	private String transactionType;
	
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Long getFromPhoneNumber() {
		return fromPhoneNumber;
	}
	public void setFromPhoneNumber(Long fromPhoneNumber) {
		this.fromPhoneNumber = fromPhoneNumber;
	}
	public Long getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(Long toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}


}
