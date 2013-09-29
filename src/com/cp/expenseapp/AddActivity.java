package com.cp.expenseapp;

import java.util.RandomAccess;

import org.json.JSONObject;


import com.cp.expenseapp.fragments.AddFragment;
import com.cp.expenseapp.fragments.AddMoreExpenseFragment;
import com.cp.expenseapp.fragments.AddMoreIncomeFragment;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.location.GpsStatus.Listener;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AddActivity extends FragmentActivity {

	EditText etAmount ;
	EditText etNotes ;
	EditText etDate ;
	EditText etAccount ;
	EditText etCategory ;
	EditText etVendor ;
	EditText etMode ;
	TextView tvToggle;
	TextView tvVendor;
	RadioGroup rgTransaction;
	RadioButton rbExpense;
	RadioButton rbIncome;
	Fragment addMoreExpenseFragment;
	Fragment addMoreIncomeFragment;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		setupViews();
		insertPrimaryFragment();
		insertSecondaryFragment();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add, menu);
		return true;
	}
	
	public void insertPrimaryFragment() {
		FragmentManager fragmentManager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = fragmentManager.beginTransaction();
		fts.replace(R.id.add_frame_container, new AddFragment());
		fts.commit();
		
		
	}
	
	public void insertSecondaryFragment() {
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = fragmentManager.beginTransaction();
		fts.replace(R.id.add_more_frame_container, new AddMoreExpenseFragment());
		addMoreExpenseFragment = (getSupportFragmentManager().findFragmentById(R.id.add_more_frame_container));
		fts.commit();
		
	}
	
	public void setupViews() {
		etAmount = (EditText) findViewById(R.id.etAmount);
		etNotes = (EditText) findViewById(R.id.etNotes);
		etDate = (EditText) findViewById(R.id.etDate);
		etAccount = (EditText) findViewById(R.id.etAccount);
		etCategory = (EditText) findViewById(R.id.etCategory);
		etVendor = (EditText) findViewById(R.id.etVendor);
		etMode = (EditText) findViewById(R.id.etPaymentMode);
		tvToggle = (TextView) findViewById(R.id.tvToggle);
		tvVendor = (TextView) findViewById(R.id.tvVendor);
		rgTransaction = (RadioGroup) findViewById(R.id.rgTransaction);
		
		
	}
	
	public void toggleFormVisibility(View v ) {
		android.support.v4.app.FragmentTransaction fts = getSupportFragmentManager().beginTransaction(); 

		if(tvToggle.getText().toString().equals("More")){
			findViewById(R.id.add_more_frame_container).setVisibility(View.VISIBLE);
			tvToggle.setText("Less");
//			if(rgTransaction.getCheckedRadioButtonId()==R.id.rbExpense  ){
//				addMoreExpenseFragment = (getSupportFragmentManager().findFragmentById(R.id.add_more_frame_container));
//				fts.show(addMoreExpenseFragment);  
//				fts.commit();
//
//			}
//			else
//			{
//				addMoreIncomeFragment = (AddMoreIncomeFragment)(getSupportFragmentManager().findFragmentById(R.id.add_more_frame_container));
//				fts.show(addMoreIncomeFragment);  
//				fts.commit();				
//			}
			
		}
		else{
			findViewById(R.id.add_more_frame_container).setVisibility(View.INVISIBLE);
			tvToggle.setText("More");
//			if(rgTransaction.getCheckedRadioButtonId()==R.id.rbExpense  ){
//				addMoreExpenseFragment = (getSupportFragmentManager().findFragmentById(R.id.add_more_frame_container));
//				fts.hide(addMoreExpenseFragment);  
//				fts.commit();
//			}
//			else
//			{
//				addMoreIncomeFragment = (AddMoreIncomeFragment)(getSupportFragmentManager().findFragmentById(R.id.add_more_frame_container));
//				fts.hide(addMoreIncomeFragment);  
//				fts.commit();
//			}
			
			
		}
		
	}
	
	public void onSubmit(View view) {
		String amount = etAmount.getText().toString();
		String notes = etNotes.getText().toString();
		String date = etDate.getText().toString();
		String account = etAccount.getText().toString();
		String category= etCategory.getText().toString();
		String vendor = etVendor.getText().toString();
		String mode = etMode.getText().toString();
		RequestParams params = new RequestParams();
		params.put("amount", amount );
		params.put("notes", notes );
		params.put("date", date );
		params.put("account", account );
		params.put("category", category );
		params.put("vendor", vendor );
		params.put("mode", mode );
//		ExpenseappClient.postTransaction(params, new JsonHttpResponseHandler(){
//			@Override
//			public void onSuccess(JSONObject jsonTweet){
//				
//				
//				if (getParent() == null) {
//				    setResult(Activity.RESULT_OK);
//				} else {
//				    getParent().setResult(Activity.RESULT_OK);
//				}
//				finish();
//
//			}
//			
//
//		});
		
		
	}
	

}
