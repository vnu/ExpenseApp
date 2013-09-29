package com.cp.expenseapp;


import org.json.JSONObject;

import com.codepath.oauth.OAuthLoginActivity;
import com.cp.expenseapp.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.Menu;
import android.view.View;

public class LoginActivity extends OAuthLoginActivity<TwitterClient> {

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	// Inflate the menu; this adds items to the action bar if it is present.
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
	
	
	// OAuth authenticated successfully, launch primary authenticated activity
	// i.e Display application "homepage"
    @Override
    public void onLoginSuccess() {
    	 loadLoggedInUserProfile();
    	 Intent i = new Intent(this, AddActivity.class);
    	 startActivity(i);
    }
    
    // OAuth authentication flow failed, handle the error
    // i.e Display an error dialog or toast
    @Override
    public void onLoginFailure(Exception e) {
        e.printStackTrace();
    }
    
    // Click handler method for the button used to start OAuth flow
    // Uses the client to initiate OAuth authorization
    // This should be tied to a button used to login
    public void loginToRest(View view) {
        getClient().connect();
    }
    

    public void loadLoggedInUserProfile() {
		TwitterClientApp.getRestClient().getUserProfile(new JsonHttpResponseHandler(){
			@Override
			public void onSuccess(JSONObject userProfile) {
				User user = User.fromJson(userProfile);
				savePreferences("username", user.getScreenName());
			}
		});
	
	}
	
	private void savePreferences(String key, String value) {
		SharedPreferences sharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor editor = sharedPreferences.edit();
		editor.putString(key, value);
		editor.commit();
	}

}
