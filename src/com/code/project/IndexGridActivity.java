package com.code.project;

import com.banking.project.BankingActivity;
import com.calender.project.CalendarInfoActivity;
import com.cellphones.project.CellPhoneActivity;
import com.contacts.project.ContactListActivity;
import com.housing.project.HousingTabActivity;
import com.map.project.MapActivity;
import com.parse.Parse;

import com.transport.project.TransportActivity;
import com.weather.project.WeatherActivity;

import android.R.color;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.GridView;

public class IndexGridActivity extends Activity {

	GridView index_gridView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
		Parse.initialize(this, "UNWFs2et9ZfgLTcoadWQpReVhuF0WOs5MeMUfpS4", "8cBnwp7UbWIuuHvWwIlE4s9DEE8fE2pKw3TLXL6g");
		index_gridView = (GridView)findViewById(R.id.index_gridView);
		index_gridView.setBackgroundColor(color.darker_gray);
		Resources res = getResources();
		String title[]= res.getStringArray(R.array.content);
		int [] logos = {R.drawable.ic_contact,R.drawable.ic_calendar,R.drawable.ic_transportation,R.drawable.ic_weather,R.drawable.ic_housing,R.drawable.ic_currency,R.drawable.ic_cell_phone,R.drawable.ic_social};
		
		IndexAdapter adapter = new IndexAdapter(this,logos,title,"gridview");
		index_gridView.setAdapter(adapter);
		
		index_gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				
				Intent intent = null;
				switch (position) {
				case 0:
					intent = new Intent(getApplicationContext(),ContactListActivity.class);
					startActivity(intent);
					break;

				case 1:
					intent = new Intent(getApplicationContext(),CalendarInfoActivity.class);
					startActivity(intent);
					break;
					
				case 2:
					intent = new Intent(getApplicationContext(),TransportActivity.class);
					startActivity(intent);
					break;
					
				case 3:
					intent = new Intent(getApplicationContext(),WeatherActivity.class);
					startActivity(intent);
					break;
					
				case 4:
					intent = new Intent(getApplicationContext(),HousingTabActivity.class);
					startActivity(intent);
					break;	
					
				case 5:
					intent = new Intent(getApplicationContext(),BankingActivity.class);
					startActivity(intent);
					break;
				
				case 6:
					intent = new Intent(getApplicationContext(),CellPhoneActivity.class);
					startActivity(intent);
					break;
					
				case 7:
					intent = new Intent(getApplicationContext(),MapActivity.class);
					startActivity(intent);
					break;
					
				default:
					break;
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.index, menu);
		return true;
	}
	
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		
		return super.onMenuItemSelected(featureId, item);
	}
}
