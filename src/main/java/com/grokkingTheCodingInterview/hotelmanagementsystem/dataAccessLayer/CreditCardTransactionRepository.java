package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.CreditCardTransaction;

@Repository
public interface CreditCardTransactionRepository extends JpaRepository<CreditCardTransaction, Integer>{

}
