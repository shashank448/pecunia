package com.capg.bankms.accountmgmt.ui;

import java.util.*;
import java.util.Date;

import com.capg.bankms.accountmgmt.entities.Address;
import com.capg.bankms.accountmgmt.exception.InvalidAddressException;
import com.capg.bankms.accountmgmt.exception.InvalidCustomerAadharException;
import com.capg.bankms.accountmgmt.exception.InvalidCustomerContactException;
import com.capg.bankms.accountmgmt.exception.InvalidCustomerDOBException;
import com.capg.bankms.accountmgmt.exception.InvalidCustomerGenderException;
import com.capg.bankms.accountmgmt.exception.InvalidCustomerPanException;
import com.capg.bankms.accountmgmt.exception.InvalidNameException;

public class AccountValidations {
public static void validateCustomerName(String customerName) {
	if(customerName==null||customerName.isEmpty()||!(customerName.matches("[a-zA-Z]+"))) {
		throw new InvalidNameException("Invalid Name");
	}
}
public static void validateCustomerContact(String customerContact) {
	if(customerContact.length()!=10) {
		throw new InvalidCustomerContactException("Invalid Customer Contact Number");
	}
	

}
public static void validateCustomerAadhar(String customerAadhar) {
	if(customerAadhar.length()!=12) {
		throw new InvalidCustomerAadharException("Invalid Customer Aadhar Number");
	}
}
public static void validateCustomerPan(String customerPan) {
	if(!(customerPan.matches("[A-Z] {3} [0-9] {4} [A-Z] {1} ")))
	{
		throw new InvalidCustomerPanException("Invalid Customer Pan Number");
	}
}
public static void validateCustomerDOB(Date customerDOB) {
	String s=customerDOB.toString();	
	String []arr=s.split(" ");
	List month=new ArrayList();
	month.add("Jan");month.add("Feb");month.add("Mar");month.add("Apr");month.add("May");month.add("Jun");month.add("Jul");month.add("Aug");month.add("Sep");month.add("Oct");month.add("Nov");month.add("Dec");
	if(month.contains(arr[1]))
	{
        if(Integer.parseInt(arr[2])>0&&Integer.parseInt(arr[2])<31)
        {
        	if(Integer.parseInt(arr[5])<2000)
        	
        	{
     
        	}
        	
        	}
        	}
	
        	else
	{
		throw new InvalidCustomerDOBException("invalid date");
	}
        }
        
        

        
 public static void validateCustomerGender(String customerGender) {
	 if(!(customerGender.equals("Male")&&customerGender.equals("Female"))){
	 throw new InvalidCustomerGenderException("Invalid Gender");	 
		 
 }
	 }
 
public static void validateAddressFields(String addressLine1,String addressLine2,String addressCity,String addressState,String addressCountry,String addressZipcode) {

    if(addressLine1.matches("[a-zA-Z0-9!/-(:)']+$")&& addressLine2.matches("[a-zA-Z0-9!/-(:)']+$") &&
    addressState.matches("[a-zA-Z]+$") && addressCity.matches("[a-zA-Z]+$") && addressCountry.matches("[a-zA-Z]+$") && (addressZipcode.length()==6) )
   {

		
    }
    else 
    {
    	throw new InvalidAddressException("validated unsuccessfully!!!!!");
    	}
    }
	
	}

