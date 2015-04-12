package com.code.project;

import com.parse.Parse;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SplashScreenActivity extends Activity {

	private static int SPLASH_TIME_OUT = 3000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index_list);
		setContentView(R.layout.splashscreen);
		if(isNetworkAvailable()){
			Parse.initialize(this, "UNWFs2et9ZfgLTcoadWQpReVhuF0WOs5MeMUfpS4", "8cBnwp7UbWIuuHvWwIlE4s9DEE8fE2pKw3TLXL6g");
		}else{
			Toast.makeText(this, "Please Check The Internet Connection", Toast.LENGTH_SHORT).show();
		}
		
		new Handler().postDelayed(new Runnable() { 
            @Override
            public void run() {              
                Intent i = new Intent(SplashScreenActivity.this,IndexGridActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
	}
	
	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		return networkInfo != null && networkInfo.isConnected();
	}
}
