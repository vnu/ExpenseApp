package com.cp.expenseapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cp.expenseapp.R;

public class SharedExpenseFragment extends Fragment{
	@Override
	public View onCreateView(LayoutInflater inf, ViewGroup parent, Bundle savedInstanceState){
		return inf.inflate(R.layout.fragment_shared_expense, parent, false);
	}
}
