package com.cp.expenseapp;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ExpenseappClient {

	  private static final String BASE_URL = "http://androexpense.herokuapp.com/";

	  private static AsyncHttpClient client = new AsyncHttpClient();
	  
	  public static void postTransaction( RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  String url = "transactions.json" ;
		  client.post(getAbsoluteUrl(url), params, responseHandler);
	  }
	  
	  public static void getTransactions( RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  String url = "transactions.json" ;
		  client.get(getAbsoluteUrl(url), params, responseHandler);
	  }
	
	  public static void getIncome(RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  String url = "transactions.json" ;
		  client.get(getAbsoluteUrl(url), params, responseHandler);
	  }
	
	  public static void getExpenses( RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  String url = "transactions.json" ;
		  client.get(getAbsoluteUrl(url), params, responseHandler);
	  }
	  
	  private static String getAbsoluteUrl(String relativeUrl) {
	      return BASE_URL + relativeUrl;
	  }
}

