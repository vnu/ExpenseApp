package com.cp.expenseapp.fragments;

import org.json.JSONArray;

import com.cp.expenseapp.ExpenseappClient;
import com.cp.expenseapp.models.Transaction;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public class AllListFragment extends TransactionListFragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		updateAndDisplayExpenses();
		
	}
	
	public void updateAndDisplayExpenses() {
		RequestParams params =new RequestParams();
		params.put("username", "androexp1");
		ExpenseappClient.getTransactions(params,new JsonHttpResponseHandler(){
		
			@Override
			public void onSuccess(JSONArray jsonTransactions){
				//Log.d("DEBUG", jsonTweets.toString());
				getTransactionAdapter().clear();
				getTransactionAdapter().addAll(Transaction.fromJson(jsonTransactions));
			}

			
		});
	}

}
