package com.banking.project;

import com.code.project.R;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class BankingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_banking);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.banking, menu);
		return true;
	}
	
	
	public void bankofAmericaDetails(View view){
		String title = view.getTag().toString();
		createDialog(title,Constants.BANK_OF_AMERICA_PHONE,Constants.BANK_OF_AMERICA_URL,Constants.BANK_OF_AMERICA_LAT,Constants.BANK_OF_AMERICA_LONG);
	}
	
	public void wellsFargoDetails(View view){
		String title = view.getTag().toString();
		createDialog(title,Constants.WELLS_FARGO_PHONE,Constants.WELLS_FARGO_URL,Constants.WELLS_FARGO_LAT,Constants.WELLS_FARGO_LONG);
	}
	
	public void chaseDetails(View view){
		String title = view.getTag().toString();
		createDialog(title,Constants.CHASE_PHONE,Constants.CHASE_URL,Constants.CHASE_LAT,Constants.CHASE_LONG);
	}
	
	public void citiBankDetails(View view){
		String title = view.getTag().toString();
		createDialog(title,Constants.CITI_BANK_PHONE,Constants.CITI_BANK_URL,Constants.CITI_BANK_LAT,Constants.CITI_BANK_LONG);
	}
	
	public void createDialog(final String title,final String phoneNumber,final String bankLink,final String bankLat,final String bankLong){
		final Dialog dialog = new Dialog(this);
		
		dialog.setContentView(R.layout.custom_dialog_banking);
		dialog.setTitle(title);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.DKGRAY));
		TextView callTextView = (TextView) dialog.findViewById(R.id.banking_call_textview);
		TextView mapTextView = (TextView) dialog.findViewById(R.id.banking_map_textview);
		TextView detailTextView = (TextView) dialog.findViewById(R.id.banking_detail_textview);
		
		Button closeDialogButton = (Button)dialog.findViewById(R.id.banking_close_button);
		
		closeDialogButton.setOnClickListener(new OnClickListener() {
			//Intent intent = null;
			@Override
			public void onClick(View arg0) {
				dialog.dismiss();
				
			}
		});
		
		callTextView.setOnClickListener(new OnClickListener() {
			//Intent intent = null;
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				String number = "tel:"+phoneNumber;
				Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse(number));
				startActivity(intent);	
			}
		});
		
		detailTextView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				dialog.dismiss();
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.setData(Uri.parse(bankLink));
				startActivity(intent);
				
			}
		});
		
		mapTextView.setOnClickListener(new OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.dismiss();
				Intent intent = new Intent(Intent.ACTION_VIEW);
				//geo:<lat>,<long>?q=<lat>,<long>(Label+Name)
				//String UriString = "geo:"+bankLat+","+bankLong+"?q="+bankLat+","+bankLong+"("+title+")";
				String uri = "http://maps.google.com/maps?" + "saddr="+ Constants.UNIVERSITY_LAT + "," + Constants.UNIVERSITY_LONG + "&daddr=" + bankLat + "," + bankLong;
				intent.setData(Uri.parse(uri));
				Intent chooser = Intent.createChooser(intent, title+" Location");
				startActivity(chooser);
			}
		});
		
		dialog.show();

	}

}
