package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.CheckTransaction;

@Repository
public interface CheckTransactionRepository extends JpaRepository<CheckTransaction, Integer>{

}
