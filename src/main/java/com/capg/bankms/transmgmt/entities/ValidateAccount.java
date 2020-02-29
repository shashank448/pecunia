package com.capg.bankms.transmgmt.entities;

public class ValidateAccount {
	
	
	public boolean validate(int acc_num) {
		String s=acc_num+"";
		if(s.length()==12)
			return true;
		else
			return false;
	}
}
