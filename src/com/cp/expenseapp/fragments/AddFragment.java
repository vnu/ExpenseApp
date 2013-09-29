package com.cp.expenseapp.fragments;

import java.util.ArrayList;

import com.cp.expenseapp.R;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddFragment extends Fragment {
	
	RadioGroup rgTransaction;
	TextView tvVendor;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_add, container, false);
		
		return v;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		tvVendor = (TextView) getView().findViewById(R.id.tvVendor);
		rgTransaction = (RadioGroup) getActivity().findViewById(R.id.rgTransaction);
		rgTransaction.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
		{
		    public void onCheckedChanged(RadioGroup rGroup, int checkedId)
		    {	
		    	FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
				
		    	switch (checkedId) {
		    	case R.id.rbExpense:  
		    						 tvVendor.setText(R.string.payee);
		    						 android.support.v4.app.FragmentTransaction ftsExpense = fragmentManager.beginTransaction();
									 ftsExpense.replace(R.id.add_more_frame_container, new AddMoreExpenseFragment());
									 ftsExpense.commit();
									 
									 break;
		    	case R.id.rbIncome:	 
		    						 tvVendor.setText(R.string.payer);
		    						 android.support.v4.app.FragmentTransaction ftsIncome = fragmentManager.beginTransaction();
									 ftsIncome.replace(R.id.add_more_frame_container, new AddMoreIncomeFragment());
									 ftsIncome.commit();
									 
									 break;
		         }
		    }
		});
	}
}

