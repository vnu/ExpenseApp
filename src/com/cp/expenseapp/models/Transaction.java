package com.cp.expenseapp.models;

import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




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
	
	public static Transaction fromJson(JSONObject jsonObject) {
        Transaction transaction = new Transaction();
        //try {
            transaction.jsonObject = jsonObject;
            //transaction.user = User.fromJson(jsonObject.getJSONObject("user"));
//        //} catch (JSONException e) {
//            e.printStackTrace();
//            return null;
//        }
        return transaction;
    }

	public static ArrayList<Transaction> fromJson(
			JSONArray jsonArray) {
		ArrayList<Transaction> transactions = new ArrayList<Transaction>(jsonArray.length());

        for (int i=0; i < jsonArray.length(); i++) {
            JSONObject transactionJson = null;
            try {
                transactionJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            Transaction transaction = Transaction.fromJson(transactionJson);
            if (transaction != null) {
                transactions.add(transaction);
            }
        }

        return transactions;
	}

}
