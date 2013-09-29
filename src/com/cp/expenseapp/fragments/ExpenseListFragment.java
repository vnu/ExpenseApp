package com.cp.expenseapp.fragments;


import org.json.JSONArray;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


import com.cp.expenseapp.ExpenseappClient;
import com.cp.expenseapp.R;
import com.cp.expenseapp.models.Transaction;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ExpenseListFragment extends TransactionListFragment{
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		updateAndDisplayExpenses();
		
	}
	
	public void updateAndDisplayExpenses() {
		RequestParams params =new RequestParams();
		params.put("username", "androexp1");
		ExpenseappClient.getExpenses(params,new JsonHttpResponseHandler(){
		
			@Override
			public void onSuccess(JSONArray jsonTransactions){
				//Log.d("DEBUG", jsonTweets.toString());
				getTransactionAdapter().clear();
				getTransactionAdapter().addAll(Transaction.fromJson(jsonTransactions));
			}

			
		});
	}

}
