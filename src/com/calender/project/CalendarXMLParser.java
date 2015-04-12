package com.calender.project;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;



public class CalendarXMLParser {
	
	static final String KEY_TERM = "events";
	static final String KEY_DATE = "date";
	static final String KEY_DAY = "day";
	static final String KEY_DESCRIPTION = "description";
	
	
	public static List<CalendarSource> getDataFromFile(Context context,InputStream in) throws XmlPullParserException, IOException{
		
		List<CalendarSource> dataList = new ArrayList<CalendarSource>();
		
		CalendarSource curData = null;
		
		String curText = "";
		
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser = factory.newPullParser();
		
		//InputStream raw = context.getAssets().open("calendar.xml");
		
		parser.setInput(in, null);
		
		int eventType = parser.getEventType();
		
		while(eventType != XmlPullParser.END_DOCUMENT){
			String tagName = parser.getName();
			
			switch(eventType){
			case XmlPullParser.START_TAG:
				if (tagName.equalsIgnoreCase(KEY_TERM)) {
					curData = new CalendarSource();
				}
				break;
			case XmlPullParser.TEXT:
				curText = parser.getText();
				break;
			case XmlPullParser.END_TAG:
				if (tagName.equalsIgnoreCase(KEY_TERM)) {
					dataList.add(curData);
				} else if (tagName.equalsIgnoreCase(KEY_DATE)) {
					
					curData.setDate(curText);
				} else if (tagName.equalsIgnoreCase(KEY_DESCRIPTION)) {
					
					curData.setDescription(curText);
				} else if (tagName.equalsIgnoreCase(KEY_DAY)) {
					
					curData.setDay(curText);
				} 
				break;

			default:
				break;
			}
			//move on to next iteration
			eventType = parser.next();
		}
		
		return dataList;
		
	}

}
