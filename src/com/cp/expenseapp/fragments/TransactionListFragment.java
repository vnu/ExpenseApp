package com.cp.expenseapp.fragments;

import java.util.ArrayList;

import com.cp.expenseapp.R;
import com.cp.expenseapp.TransactionAdapter;
import com.cp.expenseapp.models.Transaction;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class TransactionListFragment extends Fragment {
	TransactionAdapter transactionAdapter;
	ListView lvTransactions;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_transaction_list, container, false);
		lvTransactions = (ListView) v.findViewById(R.id.lvTransactions);
		lvTransactions.setAdapter(transactionAdapter);
		return v;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<Transaction> transaction = new ArrayList<Transaction>();
		transactionAdapter = new TransactionAdapter(getActivity(), transaction);
	}

	public TransactionAdapter getTransactionAdapter() {
		return transactionAdapter;
	}
}
