package com.cp.expenseapp;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class ExpenseappClient {

	  private static final String BASE_URL = "http://api.twitter.com/1/";

	  private static AsyncHttpClient client = new AsyncHttpClient();
	  
	  public static void postTransaction( RequestParams params, AsyncHttpResponseHandler responseHandler) {
		  String url = "" ;
		  client.post(getAbsoluteUrl(url), params, responseHandler);
	  }
	  
	  private static String getAbsoluteUrl(String relativeUrl) {
	      return BASE_URL + relativeUrl;
	  }
}
