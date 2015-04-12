package com.housing.project;

import java.util.ArrayList;

import com.code.project.R;
import com.code.project.R.layout;
import com.code.project.R.menu;
import com.contacts.project.ContactDetailActivity;
import com.contacts.project.ContactDetailSource;
import com.contacts.project.ContactParseAdapter;
import com.parse.Parse;
import com.parse.ParseObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class OnCampusActivity extends Activity implements OnItemClickListener {

	ListView list;
	String[] list_items = {"Check list of Apartments","Important Information"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_on_campus);
	
		list = (ListView) findViewById(R.id.listView1);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_items);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.on_campus, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
	
		if(position == 0)
		
			intent = new Intent(this, OnCampusHousingListActivity.class);	
		
		else
			
			intent = new Intent(this, ImportantDetailsActivity.class);	
		
		startActivity(intent);
	}
}