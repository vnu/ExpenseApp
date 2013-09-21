package com.cp.expenseapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.cp.expenseapp.R;

public class ExpenseListFragment extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inf, ViewGroup parent, Bundle savedInstanceState){
		return inf.inflate(R.layout.fragments_expense_list, parent, false);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState){
		ListView lvExpenseList = (ListView) getActivity().findViewById(R.id.lvExpenseList);

		super.onActivityCreated(savedInstanceState);
	}

}
