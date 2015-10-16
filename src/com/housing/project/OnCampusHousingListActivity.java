package com.housing.project;

import com.code.project.R;
import com.imageloader.util.ImageLoader;
import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class OnCampusHousingListActivity extends Activity {

	TextView txtMsg;
	ViewGroup scrollViewgroup;
	ImageView icon;
	TextView caption;
	ImageView imageSelected;
	int loader = R.drawable.loading;
	
	String[] items = { "Bellarmine Hall" , "Casa Italiana" , "Graham Hall", "McLaughlin-Walsh Hall","Nobili Hall",
	"Park Avenue Apartments", "St. Clare Hall", "University Studios" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_on_campus_housing_list);
	
		imageSelected = (ImageView) findViewById(R.id.imageSelected);  
		scrollViewgroup = (ViewGroup) findViewById(R.id.viewgroup);
		
		ParseQuery query = new ParseQuery("housing_details");
		query.whereEqualTo("name", "Housing office");
		query.getFirstInBackground(new GetCallback() {

			@Override
			public void done(ParseObject object, ParseException error) {
					
				if (object == null) {
				      Log.d("score", "The getFirst request failed.");
				    } else {
				
				    	String image_url = object.getString("image_large");
				    	ImageLoader imgLoader = new ImageLoader(getApplicationContext());
						imgLoader.DisplayImage(image_url, loader, imageSelected);
				     
						String Desc = object.getString("description");
				    	TextView Description = (TextView)findViewById(R.id.textView1);
	                    Description.setText(Desc);
				    }
			}});
		
		//imageSelected.setImageResource(R.drawable.housing_office);
		
		Parse.initialize(this, "UNWFs2et9ZfgLTcoadWQpReVhuF0WOs5MeMUfpS4", "8cBnwp7UbWIuuHvWwIlE4s9DEE8fE2pKw3TLXL6g");
		
		//ParseQuery query1 = new ParseQuery("housing_details");
		
		for (int i = 0; i < items.length; i++) { 
	 
			final View singleFrame = getLayoutInflater().inflate( R.layout.horizonal_view, null ); 
			singleFrame.setId(i); 

			TextView caption = (TextView) singleFrame.findViewById(R.id.caption); 
						 
			ParseQuery query1 = new ParseQuery("housing_details");
			query1.whereEqualTo("name", items[i]);
			
			query1.getFirstInBackground(new GetCallback() {

			@Override
			public void done(ParseObject object, ParseException error) {
			
				ImageView icon = (ImageView) singleFrame.findViewById(R.id.icon);
			
				if (object == null) {
				      Log.d("score", "The getFirst request failed.");
				    } else {
				    	
				    	String image_url = object.getString("image");
				    	ImageLoader imgLoader = new ImageLoader(getApplicationContext());
						imgLoader.DisplayImage(image_url, loader, icon);
				     
				    }
			}});		


			caption.setText( items[i] ); 
			 
			scrollViewgroup.addView( singleFrame );
				
			singleFrame.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showLargeImage(singleFrame.getId());
			}
			});
		}
	}

	protected void showLargeImage(int frameId) {
		
		ParseQuery query = new ParseQuery("housing_details");
		query.whereEqualTo("name", items[frameId]);
		
		query.getFirstInBackground(new GetCallback() {

		@Override
		public void done(ParseObject object, ParseException error) {
		
			if (object == null) {
			      Log.d("score", "The getFirst request failed.");
			    } else {
			    	
			    	ImageLoader imgLoader = new ImageLoader(getApplicationContext());
			    	String image_url = object.getString("image_large");
					imgLoader.DisplayImage(image_url, loader, imageSelected);
			    	
			    	String Desc = object.getString("description");
			    	TextView Description = (TextView)findViewById(R.id.textView1);
                    Description.setText(Desc);
                    
			        Log.d("score", String.format("%s", Desc));
			      
			    }
		}});		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.on_campus_housing_list, menu);
		return true;
	}
}