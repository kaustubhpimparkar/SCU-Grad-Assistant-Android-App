package com.transport.project;


import com.code.project.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.TextView;

public class TransportDetailsActivity extends Activity{

	//int position;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transport_details);
		
		final int position = getIntent().getExtras().getInt("list_index");
		
		String[] Desc = {
				"Mineta San Jose International Airport (SJC)\n\nhttp://www.flysanjose.com/fl/\n\nIf your final destination is the Santa Clara University campus you can take advantage of the Santa Clara Valley Transit Authority’s (VTA) free shuttle service. The shuttle stops every 10 minutes and makes a continuous loop between the Airport (both terminal A and B), the Metro Light Rail station and the Santa Clara Caltrain station directly across from campus.",
				"San Francisco International Airport (SFO)\n\nhttp://www.flysfo.com/web/page/index.jsp\n\nSanta Clara University can be reached in about 90 minutes from SFO using a combination of Bay Area Rapid Transit (BART) and Caltrain. More information including rates, route planning and timetables can be found on their websites.\n\nBay Area Rapid Transit (BART):\nhttp://www.bart.gov/\n\nCaltrain:\nhttp://www.caltrain.com/main.html",
				"Oakland International Airport (OAK)\n\nhttp://www.flyoakland.com/\n\nSanta Clara is also reachable via public transportation from Oakland International Airport. You can reach Santa Clara University from Oakland International Airport in approximately 2 and a half hours using a combination of buses and trains. Rates, route planners and timetables can be found on their respective websites:\n\nAlameda Contra Costa Transit:\nhttp://www.actransit.org/\n\nSanta Clara Valley Transit Authority:\nhttp://www.vta.org/\n\nBay Area Rapid Transit (BART):\nhttp://www.bart.gov/"		
			};
	
		final String[] Longitude = {TransportConstants.SJ_LONG,TransportConstants.SF_LONG,TransportConstants.OAK_LONG};
		final String[] Latitude = {TransportConstants.SJ_LAT,TransportConstants.SF_LAT,TransportConstants.OAK_LAT};
		final String[] title = {"Mineta San Jose International Airport to Santa Clara University","San Francisco International Airport to Santa Clara University","Oakland International Airport to Santa Clara University"};
		
		TextView tv3 = (TextView)findViewById(R.id.transport_desc_textView);
		tv3.setText(Desc[position]);
		
		Button mapButton = (Button)findViewById(R.id.button1);
		
		mapButton.setOnClickListener(new OnClickListener() {
			//Intent intent = null;
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_VIEW);
				//geo:<lat>,<long>?q=<lat>,<long>(Label+Name)
				//String UriString = "geo:"+bankLat+","+bankLong+"?q="+bankLat+","+bankLong+"("+title+")";
				String uri = "http://maps.google.com/maps?" + "saddr="+ TransportConstants.UNIVERSITY_LAT + "," + TransportConstants.UNIVERSITY_LONG + "&daddr=" + Latitude[position] + "," + Longitude[position];
				//Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse(uri));
				intent.setData(Uri.parse(uri));
				Intent chooser = Intent.createChooser(intent, title[position]+" Location");
				startActivity(chooser);
				//startActivity(intent);
				
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.transport_details, menu);
		return true;
	}

}
