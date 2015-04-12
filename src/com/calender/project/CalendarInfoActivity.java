package com.calender.project;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import org.xmlpull.v1.XmlPullParserException;


import com.code.project.R;




import android.os.Bundle;
import android.app.Activity;
import android.content.Context;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.AdapterView;

import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class CalendarInfoActivity extends Activity{

	ListView listView;
	TextView currentQuarterTextView;
	Context context;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calendar_info);
		listView = (ListView)findViewById(R.id.calendar_listview);
		context = getApplicationContext();
		currentQuarterTextView = (TextView)findViewById(R.id.currentQuarter);
		displayList("Winter 2014","winter.xml");
		
		
	}
	
	private void displayList(String quarter,String xml){
		currentQuarterTextView.setText(quarter);
		List<CalendarSource> calanderList = null;
		InputStream raw;
			try {
				raw = context.getAssets().open(xml);
				calanderList = CalendarXMLParser.getDataFromFile(this,raw);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			}
		
		
		CalendarAdapter adapter = new CalendarAdapter(this,calanderList);
		//listView.setBackgroundColor()
		listView.setAdapter(adapter);
		listView.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    int pos, long id) {
                // TODO Auto-generated method stub

                Log.v("long clicked","pos: " + pos);

                return true;
            }
        });
		
	}
		
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.calendar_info, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		if(item.getItemId() == R.id.summer_quarter){
			displayList("Summer 2014","spring.xml");
		}else if(item.getItemId() == R.id.spring_quarter){
			displayList("Spring 2014","spring.xml");
		}
		else if(item.getItemId() == R.id.winter_quarter){
			displayList("Winter 2014","winter.xml");
		}
		return super.onOptionsItemSelected(item);
	}

	

	
	
	

		
	
}


