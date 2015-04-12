package com.contacts.project;

import java.util.ArrayList;
import java.util.List;

import com.code.project.R;

import com.parse.FindCallback;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQuery.CachePolicy;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


public class ContactListActivity extends Activity implements OnItemClickListener {

	ListView contactlistView;
	ContactParseAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_list);
		Parse.initialize(this, "UNWFs2et9ZfgLTcoadWQpReVhuF0WOs5MeMUfpS4", "8cBnwp7UbWIuuHvWwIlE4s9DEE8fE2pKw3TLXL6g");
		
		ParseObject.registerSubclass(ContactDetailSource.class);
		
		contactlistView = (ListView) findViewById(R.id.contact_listview);
		
		adapter = new ContactParseAdapter(this, new ArrayList<ContactDetailSource>());
		contactlistView.setAdapter(adapter);
		contactlistView.setOnItemClickListener(this);
		updateData();
	}

	private void updateData() {
		// TODO Auto-generated method stub
	//	Log.v("update","Data");
		ParseQuery<ContactDetailSource> query = ParseQuery.getQuery(ContactDetailSource.class);
		query.setCachePolicy(CachePolicy.CACHE_THEN_NETWORK);
		  query.findInBackground(new FindCallback<ContactDetailSource>() {
		         
			@Override
			public void done(List<ContactDetailSource> tasks, ParseException error) {
				// TODO Auto-generated method stub
				 if(tasks != null){
		        	  adapter.clear();
		        	  for (int i = 0; i < tasks.size(); i++) {
							adapter.add(tasks.get(i));
						}
		          }
			}
		  });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.contact_list, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		ContactDetailSource source = adapter.getItem(position);
		Intent intent = new Intent(this,ContactDetailActivity.class);
		
		intent.putExtra("office_name", source.getOfficeName());
		intent.putExtra("office_email", source.getOfficeEmail());
		intent.putExtra("office_phone", source.getOfficePhone());
		intent.putExtra("office_long_description", source.getOfficeLongDescription());
		intent.putExtra("office_fax",source.getOfficeFax() );
		intent.putExtra("office_image",source.getOfficeImage());
		
		this.startActivity(intent);
		
		
		//Toast.makeText(this, source.getOfficeEmail(), Toast.LENGTH_SHORT).show();
		
	}

}
