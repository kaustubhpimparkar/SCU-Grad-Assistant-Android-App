package com.contacts.project;

import com.code.project.R;

import com.imageloader.util.ImageLoader;


import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactDetailActivity extends Activity {

	TextView officeNameTextView,officePhoneTextView,officeEmailTextView,officeDescTextView,officeFaxTextView;
	ImageView officeImageView;
	int loader = R.drawable.loading;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact_detail);
		
		initializeUIComponents();
		setUiWithData();
		
	}

	private void setUiWithData() {
		//Code to get Images from URL and setting it into the ImageView
		ImageLoader imgLoader = new ImageLoader(getApplicationContext());
		
		Intent intent = getIntent();
		officeNameTextView.setText(intent.getStringExtra("office_name"));
		officeEmailTextView.setText(intent.getStringExtra("office_email"));
		officePhoneTextView.setText(intent.getStringExtra("office_phone"));
		officeDescTextView.setText(intent.getStringExtra("office_long_description"));
		officeFaxTextView.setText(intent.getStringExtra("office_fax"));
		//officeImageView.setImageResource(intent.getIntExtra("office_image", R.drawable.enrollment));
		//Log.v("officeImage",""+intent.getStringExtra("office_image"));
		String image_url = intent.getStringExtra("office_image");
		//Image URl, Loading image, Id of ImageView
		imgLoader.DisplayImage(image_url, loader, officeImageView);
		
	}

	private void initializeUIComponents() {
		//int loader = R.drawable.ic_launcher;
	//ImageLoader imgLoader = new ImageLoader(getApplicationContext());
		officeNameTextView = (TextView) findViewById(R.id.contact_name_textView);
		officeEmailTextView = (TextView) findViewById(R.id.contact_email_textView);
		officePhoneTextView = (TextView) findViewById(R.id.contact_phone_textView);
		officeDescTextView = (TextView) findViewById(R.id.contact_long_desc_textView);
		officeFaxTextView = (TextView) findViewById(R.id.contact_fax_textView);
		officeImageView = (ImageView)findViewById(R.id.contact_image_imageView);
		//String image_url = "http://api.androidhive.info/images/sample.jpg";
		//
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		getMenuInflater().inflate(R.menu.contact_detail, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		Intent intent = null;
		if(item.getItemId() == R.id.action_call){
			String number = "tel:"+officePhoneTextView.getText().toString();
			intent = new Intent(Intent.ACTION_DIAL,Uri.parse(number));
			startActivity(intent);
		}else if(item.getItemId() == R.id.action_share){
			Intent sendIntent = new Intent();
			sendIntent.setAction(Intent.ACTION_SEND);
			sendIntent.putExtra(Intent.EXTRA_TEXT,officeDescTextView.getText().toString());
			sendIntent.setType("text/plain");
			startActivity(Intent.createChooser(sendIntent, officeNameTextView.getText().toString()));
		}
		return super.onOptionsItemSelected(item);
	}

}
