package com.cellphones.project;


import com.banking.project.Constants;
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

public class CellPhoneActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cell_phone);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cell_phone, menu);
		return true;
	}
	
	public void attDetails(View view){
		String title = view.getTag().toString();
		createDialog(title,Constants.ATT_PHONE,Constants.ATT_URL,Constants.ATT_LAT,Constants.ATT_LONG);
	}
	
	public void verizonDetails(View view){
		String title = view.getTag().toString();
		createDialog(title,Constants.VERIZON_PHONE,Constants.VERIZON_URL,Constants.VERIZON_LAT,Constants.VERIZON_LONG);
	}
	
	public void tMobileDetails(View view){
		String title = view.getTag().toString();
		createDialog(title,Constants.T_MOBILE_PHONE,Constants.T_MOBILE_URL,Constants.T_MOBILE_LAT,Constants.T_MOBILE_LONG);
	}
	
	
	
	public void createDialog(final String title,final String phoneNumber,final String bankLink,final String bankLat,final String bankLong){
		final Dialog dialog = new Dialog(this);
		
		dialog.setContentView(R.layout.custom_dialog_cell_phone);
		dialog.setTitle(title);
		dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.DKGRAY));
		TextView callTextView = (TextView) dialog.findViewById(R.id.cell_phones_call_textview);
		TextView mapTextView = (TextView) dialog.findViewById(R.id.cell_phones_map_textview);
		TextView detailTextView = (TextView) dialog.findViewById(R.id.cell_phones_detail_textview);
		
		Button closeDialogButton = (Button)dialog.findViewById(R.id.cell_phones_close_button);
		
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
