package com.consumerbanking.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.consumerbanking.account.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Optional<Account> findByAccountNumber(Long fromAccountNumber);
	Optional<Account> findByPhoneNumber(Long phoneNumber);


}
