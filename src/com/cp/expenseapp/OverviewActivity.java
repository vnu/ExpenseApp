package com.cp.expenseapp;



import com.cp.expenseapp.fragments.ExpenseListFragment;
import com.cp.expenseapp.fragments.IncomeListFragment;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

public class OverviewActivity extends FragmentActivity implements TabListener {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_overview);
		setNavigationTabs();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.overview, menu);
		return true;
	}
	
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	
	public void setNavigationTabs(){
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(true);
		Tab tabExpense= actionBar.newTab().setText("Expense")
				.setTag("ExpenseListFragment")
				//.setIcon(R.drawable.ic_home)
				.setTabListener(this);
		Tab tabIncome= actionBar.newTab().setText("Income")
				.setTag("IncomeListFragment")
				//.setIcon(R.drawable.ic_at)
				.setTabListener(this);
		Tab tabAll= actionBar.newTab().setText("All")
				.setTag("AllListFragment")
				//.setIcon(R.drawable.ic_at)
				.setTabListener(this);
		Tab tabSharedExpense= actionBar.newTab().setText("Shared Expense")
				.setTag("SharedListFragment")
				//.setIcon(R.drawable.ic_at)
				.setTabListener(this);
		
		actionBar.addTab(tabExpense);
		actionBar.addTab(tabIncome);
		actionBar.addTab(tabAll);
		actionBar.addTab(tabSharedExpense);
		actionBar.selectTab(tabAll);

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = fragmentManager.beginTransaction();
		if (tab.getTag() == ("ExpenseListFragment")){
			fts.replace(R.id.overview_frame_container, new ExpenseListFragment());
		}
		else
			if(tab.getTag() == ("IncomeListFragment")){
			fts.replace(R.id.overview_frame_container, new IncomeListFragment());
			}
			else
				if(tab.getTag() == ("SharedListFragment")){
					//fts.replace(R.id.overview_frame_container, new IncomeListFragment());
					}
				else
					//fts.replace(R.id.overview_frame_container, new IncomeListFragment());
		fts.commit();
			
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}
