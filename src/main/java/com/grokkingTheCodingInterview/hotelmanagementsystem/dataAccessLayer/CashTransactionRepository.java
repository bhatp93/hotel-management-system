package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.CashTransaction;
@Repository
public interface CashTransactionRepository extends JpaRepository<CashTransaction, Integer>{

}
