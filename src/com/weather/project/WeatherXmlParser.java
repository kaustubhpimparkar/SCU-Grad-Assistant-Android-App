package com.weather.project;

import java.io.BufferedReader;
import java.io.FileInputStream;

import java.io.IOException;

import java.io.InputStreamReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;
import android.util.Log;

public class WeatherXmlParser extends XmlPullParserFactory{
	
	static final String KEY_CURRENT = "data";
	static final String KEY_WEATHER = "weather";
	
	static final String KEY_TEMPERATURE_CELSIUS = "temp_C";
	static final String KEY_TEMPERATURE_FAHRENHEIT = "temp_F";
	
	static final String KEY_WEATHER_ICON_URL = "weatherIconUrl";
	static final String KEY_WEATHER_DESC = "weatherDesc";
	static final String KEY_WEATHER_SPEED_MILES = "windspeedMiles";
	
	static final String KEY_WEATHER_HUMIDITY = "humidity";
	
	static final String KEY_MAX_TEMPERATURE_CELSIUS = "tempMaxC";
	static final String KEY_MAX_TEMPERATURE_FAHRENHEIT = "tempMaxF";
	
	static final String KEY_MIN_TEMPERATURE_CELSIUS = "tempMinC";
	static final String KEY_MIN_TEMPERATURE_FAHRENHEIT = "tempMinF";
	
	static final String KEY_LOCATION = "query";
	static final String KEY_DATE = "date";
	
	
	
	
	public static WeatherClass getDataFromXml(Context context) throws XmlPullParserException, IOException{
		 WeatherClass object = null;	
		 Log.v("getDAtafromXML","datefromxml");
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		
		XmlPullParser parser = factory.newPullParser();
		
		FileInputStream fis = context.openFileInput("weather.xml");
		Log.v("is file available",""+fis.available());
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
		Log.v("getDAtafromXML",""+reader);
		parser.setInput(reader);
		
		String currentText = "";
		
		int eventType = parser.getEventType();
		Log.v("getDAtafromXML","eventType :"+eventType);
		Log.v("getName","getName :"+parser.getName());
		
		while(eventType != XmlPullParser.END_DOCUMENT){
			String tagName = parser.getName();
			
			switch (eventType) {
			case XmlPullParser.START_TAG:
				if(tagName.equalsIgnoreCase(KEY_CURRENT)){
					object = new WeatherClass();
				}
				break;
			case XmlPullParser.TEXT:
				currentText = parser.getText();
				break;
			case XmlPullParser.END_TAG:
				if(tagName.equalsIgnoreCase(KEY_TEMPERATURE_CELSIUS)){
					object.setCurrentTemperatureCelsius(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_TEMPERATURE_FAHRENHEIT)){
					object.setCurrentTemperatureFahrenheit(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_MAX_TEMPERATURE_CELSIUS)){
					object.setWeatherTemperatureMax(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_WEATHER_ICON_URL)){
					object.setWeatherIconUrl(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_WEATHER_DESC)){
					object.setWeatherDesc(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_WEATHER_HUMIDITY)){
					object.setWeatherHumidity(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_WEATHER_SPEED_MILES)){
					object.setWeatherWindSpeedMiles(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_LOCATION)){
					object.setWeatherLocation(currentText);
				}else if(tagName.equalsIgnoreCase(KEY_DATE)){
					object.setWeatherDate(currentText);
				}
				break;
			default:
				break;
			}
			eventType = parser.next();
			//Log.v("Current Text",""+currentText);
		}
		
		return object;
		
	}

}
