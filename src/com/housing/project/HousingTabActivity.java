package com.housing.project;

import com.code.project.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TabHost;

public class HousingTabActivity extends TabActivity {

	private TabHost mTabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_housing_tab);
		
		mTabHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		
		//on campus tab
		intent = new Intent(this, OnCampusActivity.class);
		
		spec = mTabHost.newTabSpec("OnCampus").setIndicator("On_campus").setContent(intent);
		mTabHost.addTab(spec);
		
		//off campus tab
		intent = new Intent(this, OffCampusActivity.class);
		
		spec = mTabHost.newTabSpec("OffCampus").setIndicator("Off_campus").setContent(intent);
		mTabHost.addTab(spec);
		
		mTabHost.setCurrentTab(1);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.housing_tab, menu);
		return true;
	}

}
