package com.transport.project;

import com.code.project.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TransportActivity extends Activity implements OnItemClickListener{

	ListView list;
	String[] list_items = {"Flying From San Jose","Flying From San Francisco","Flying From Oakland"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transport);
		
		list = (ListView) findViewById(R.id.listView1);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_items);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.transport, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		
		Intent intent = new Intent(TransportActivity.this,TransportDetailsActivity.class);
		intent.putExtra("list_index",position);
		startActivity(intent);
		
	//	Intent intent = new Intent();
		
	//	if(position == 0)
		
		//	intent = new Intent(this, TransportDetailsActivity.class);	
		
	//	else
			
		//	intent = new Intent(this, ImportantDetailsActivity.class);	
		
		//startActivity(intent);
		
	}

}
