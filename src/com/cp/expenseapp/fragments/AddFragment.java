package com.cp.expenseapp.fragments;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.cp.expenseapp.TwitterClientApp;
import com.cp.expenseapp.models.User;
import com.cp.expenseapp.ExpenseappClient;
import com.cp.expenseapp.R;
import com.cp.expenseapp.TwitterClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddFragment extends Fragment {
	
	EditText etAmount ;
	EditText etNotes = null;
	EditText etDate ;
	EditText etAccount ;
	EditText etVendor ;
	EditText etEmails = null;
	String username = "androexp1";
	RadioGroup rgTransaction;
	TextView tvVendor;
	MenuItem submit;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.fragment_add, container, false);
		//setupViews();
		return v;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

		
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
		submit=(MenuItem)getActivity().findViewById(R.id.transaction_submit);
		
		
	}
	
	public void setupViews() {
		etAmount = (EditText)getActivity().findViewById(R.id.etAmount);
		etDate = (EditText)getActivity().findViewById(R.id.etDate);
		etAccount = (EditText)getActivity().findViewById(R.id.etAccount);
		etVendor = (EditText)getActivity().findViewById(R.id.etVendor);
		
		//etEmails = (EditText)getActivity().findViewById(R.id.etEmail);
		//etNotes = (EditText)getActivity().findViewById(R.id.etNotes);

		
		
	}
	
	@Override
	public void onCreateOptionsMenu(
	      Menu menu, MenuInflater inflater) {
	   inflater.inflate(R.menu.add, menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		loadSavedPreferences();
		setupViews();
		
		String amount= etAmount.getText().toString();
		//String notes = etNotes.getText().toString();
		String date = etDate.getText().toString();
		String account = etAccount.getText().toString();
		String vendor = etVendor.getText().toString();
		String trans_type = (rgTransaction.getCheckedRadioButtonId()==R.id.rbExpense) ? "Expense" : "Income";
		//String emails = etEmails.getText().toString();
		
		RequestParams params = new RequestParams();
		params.put("amount", amount );
		params.put("notes", "notes" );
		params.put("trans_date", date );
		params.put("account", account );
		params.put("vendor", vendor );
		params.put("trans_type", trans_type );
		//params.put("username", "androexp1");
		params.put("username", username);
		params.put("emails", "emails");
		
		ExpenseappClient.postTransaction(params, new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONArray jsonTransactions){
				
				
//				if (getParent() == null) {
//				    setResult(Activity.RESULT_OK);
//				} else {
//				    getParent().setResult(Activity.RESULT_OK);
//				}
//				finish();

			}
			@Override
			public void onFailure(Throwable e){
				
			}
			

		});
		
		
		return true;
//		switch (item.getItemId()) {
//	      case R.id.edit_item:
//	         // do s.th.
//	         return true;
//	      default:
//	         return super.onOptionsItemSelected(item);
//	   }
	}
	
	private void loadSavedPreferences() {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this.getActivity());
		username = sharedPreferences.getString("username", "androexp1");
		
	}
	

}

