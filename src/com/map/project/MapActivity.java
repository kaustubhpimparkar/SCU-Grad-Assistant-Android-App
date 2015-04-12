package com.map.project;

import com.code.project.R;

import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.webkit.WebView;


public class MapActivity extends Activity {

	WebView webView;
	final static String url = "http://m.scu.edu/map/";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		
		webView = (WebView)findViewById(R.id.webiew_layout);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setVerticalFadingEdgeEnabled(true);
		webView.scrollTo(0, 100);
		webView.loadUrl(url);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

}
