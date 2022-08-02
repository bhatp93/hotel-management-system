package com.grokkingTheCodingInterview.hotelmanagementsystem.dataAccessLayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.grokkingTheCodingInterview.hotelmanagementsystem.Model.InvoiceItem;

@Component
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer>{
	
}
