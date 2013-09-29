package com.cp.expenseapp.models;


public class Transaction extends BaseModel {

	public String getName() {
		// TODO Auto-generated method stub
		 return getString("text");
	}

	public String getAccount() {
		// TODO Auto-generated method stub
		 return getString("text");
	}

	public String getVendor() {
		// TODO Auto-generated method stub
		 return getString("text");
	}

	public String getAmount() {
		// TODO Auto-generated method stub
		 return getString("text");
	}

}
