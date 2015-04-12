package com.weather.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.xmlpull.v1.XmlPullParserException;

import com.code.project.R;
import com.imageloader.util.ImageLoader;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherActivity extends Activity {

	public static final String URL = "http://api.worldweatheronline.com/free/v1/weather.ashx?q=Santa+Clara%2C+US&format=xml&num_of_days=1&date=today&cc=yes&includelocation=no&key=3drttz44qgyjwygp3mb5m5ck";

	WeatherClass weatherObject;
	TextView locationTextView,dateTextView,descriptionTextView,temperatureCelsiusTextView,temperatureFahrenheitTextView,windspeedTextView,humidityTextView;
	
	ImageView weatherIconImageView;
	
	TextView humidityLabel,windSpeedLabel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weather);
		
		initializeUIComponents();
		weatherObject = new WeatherClass();
		
		if(isNetworkAvailable()){
			//download xml from internet
			DownloadTask  download = new DownloadTask();
			download.execute();			
			
		}else{
			//use local copy of xml last stored
		}
		
	}

	
	private void initializeUIComponents() {
		locationTextView = (TextView) findViewById(R.id.weather_location_textview); 
		dateTextView = (TextView)findViewById(R.id.weather_date);
		descriptionTextView = (TextView)findViewById(R.id.weather_description);
		temperatureCelsiusTextView = (TextView)findViewById(R.id.weather_celcius);
		//temperatureFahrenheitTextView = (TextView)findViewById(R.id.weather_fahrenheit);
		windspeedTextView = (TextView)findViewById(R.id.weather_windspeed_value_textview);
		humidityTextView = (TextView)findViewById(R.id.weather_humidity_textview);
		humidityLabel = (TextView)findViewById(R.id.weather_humidity);
		windSpeedLabel = (TextView)findViewById(R.id.weather_windspeed);
		
		
		weatherIconImageView = (ImageView)findViewById(R.id.weather_cloud_imageview);
		
	}


	//to check if internet connection is available or not
	private boolean isNetworkAvailable() {
		ConnectivityManager connectivityManager =  (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
		return networkInfo != null && networkInfo.isConnected();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.weather, menu);
		return true;
	}
	
	private class DownloadTask extends AsyncTask<Void, Void, Void>{

		@Override
		protected Void doInBackground(Void... params) {
			//Download the file
			Log.v("in download task", "in async task");
			try {
				Downloader.DownloadfromURL(URL, openFileOutput("weather.xml", Context.MODE_PRIVATE));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			int loader = R.drawable.loading;
			ImageLoader imgLoader = new ImageLoader(getApplicationContext());
			Log.v("onpostexecute", ""+result);
			try {
			weatherObject=WeatherXmlParser.getDataFromXml(WeatherActivity.this);
			String location = weatherObject.getWeatherLocation();
			locationTextView.setText(location.split("\\,")[0]);
			dateTextView.setText(weatherObject.getWeatherDate());
			descriptionTextView.setText(weatherObject.getWeatherDesc());
			
			temperatureCelsiusTextView.setText(weatherObject.getCurrentTemperatureCelsius() +" \u2103");
			//temperatureFahrenheitTextView.setText(weatherObject.getCurrentTemperatureFahrenheit() + " \u2109");
			
			windspeedTextView.setText(weatherObject.getWeatherWindSpeedMiles() + "mph");
			humidityTextView.setText(weatherObject.getWeatherHumidity() + "%");
			windSpeedLabel.setText("Wind Speed ");
			humidityLabel.setText("Humidity ");
			 String image_url = weatherObject.getWeatherIconUrl();
			 Log.v("image_url",""+image_url);
			 imgLoader.DisplayImage(image_url, loader, weatherIconImageView);
		    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			super.onPostExecute(result);
		}
		
		public Object fetch(String address) throws MalformedURLException,
	    IOException {
	        java.net.URL url = new java.net.URL(address);
			
	        Object content = url.getContent();
	        return content;
	    } 
		
		private Drawable ImageOperations(Context ctx, String url) {
	        try {
	            InputStream is = (InputStream) this.fetch(url);
	            Drawable d = Drawable.createFromStream(is, "src");
	            return d;
	        } catch (MalformedURLException e) {
	            return null;
	        } catch (IOException e) {
	            return null;
	        }
	    }
		
		
		
	}
}
