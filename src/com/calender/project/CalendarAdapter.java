package com.calender.project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import java.util.List;
import java.util.Locale;

import com.code.project.R;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;

import android.widget.TextView;


public class CalendarAdapter extends ArrayAdapter<CalendarSource>{
	
	Context context;
	
	TextView dateTextView;
	TextView dayTextView;
	TextView descriptionTextView;
	
	ImageView addtocalendarButton;
	
	
	public CalendarAdapter(Context context,List<CalendarSource> source) {
		super(context,R.layout.list_block_calendar,source);
		this.context = context;
	//	this.source = source;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View calendarBlock = convertView;
		if(calendarBlock  == null){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			calendarBlock = inflater.inflate(R.layout.list_block_calendar,null);
		}
		
		dateTextView = (TextView) calendarBlock.findViewById(R.id.calendar_date_textview);
		
		dayTextView = (TextView) calendarBlock.findViewById(R.id.calendar_day_textview);
		
		descriptionTextView = (TextView) calendarBlock.findViewById(R.id.calendar_description_textview);
		
		addtocalendarButton = (ImageView) calendarBlock.findViewById(R.id.calendar_add_to_calendar_imageView);
		
		//addtocalendarButton.setTag(position);
		
		
		
		dateTextView.setText(getItem(position).getDate());
	
		dayTextView.setText(getItem(position).getDay());
	
		descriptionTextView.setText(getItem(position).getDescription());
		
		addtocalendarButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Calendar cal = Calendar.getInstance(); 
				//String string = "January 2, 2010";
				String dateString = dateTextView.getText()+", 2014";
				
				  Intent intent = new Intent(Intent.ACTION_EDIT);
				  intent.setType("vnd.android.cursor.item/event");
				  Log.v("Begin Time",""+cal.getTime());
				  intent.putExtra("beginTime",Date.parse(dateString) );
				  intent.putExtra("allDay", true);
				  intent.putExtra("rrule", "FREQ=YEARLY");
				  
				  intent.putExtra("title", descriptionTextView.getText().toString());
				  context.startActivity(intent);
				
			}
		});
		
		return calendarBlock;
		
	}

}
