package com.grokkingTheCodingInterview.hotelmanagementsystem.Model;

import java.util.HashMap;

public class AddressDAL {
	
	private HashMap<String, Address> addressMap = new HashMap<String, Address>();
	
	public AddressDAL() {
		addressMap.put("New Delhi", new Address("Africa Ave, Diplomatic Enclave, Chanakyapuri","New Delhi","Delhi","110023","India"));
		addressMap.put("Udaipur", new Address("HM8M+7G7, Pichola","Udaipur","Rajasthan","313001","India"));
		addressMap.put("Bengaluru", new Address("23, HAL Old Airport Rd, HAL 2nd Stage, Kodihalli","Bengaluru","Karnataka","560008","India"));
		addressMap.put("Chennai", new Address("Adyar Sea Face, Leela Palace Rd, MRC Nagar, Raja Annamalai Puram","Chennai","Tamil Nadu","600028","India"));
	}
	
	public Address getAddressMap(String city) {
		return addressMap.get(city);
	}
}
