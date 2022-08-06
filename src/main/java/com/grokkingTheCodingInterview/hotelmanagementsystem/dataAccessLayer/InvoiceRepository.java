package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

}
