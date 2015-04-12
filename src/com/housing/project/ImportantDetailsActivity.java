package com.housing.project;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import net.sf.andpdf.pdfviewer.PdfViewerActivity;
import com.code.project.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ImportantDetailsActivity extends Activity implements OnItemClickListener{

	ListView list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_important_details);
		
		String[] list_items = {"Undergraduate Housing Rates","Graduate Housing Rates"};
		
		list = (ListView) findViewById(R.id.listView1);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,list_items);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	private void copyFile(InputStream in, OutputStream out) throws IOException
	{
	    byte[] buffer = new byte[1024];
	    int read;
	    while ((read = in.read(buffer)) != -1)
	    {
	        out.write(buffer, 0, read);
	    }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.important_details, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		AssetManager assetManager = getAssets();
		String fileName;

	    InputStream in = null;
	    OutputStream out = null;
	    
	    if(position == 0)
	    	fileName = "UnderGradRates.pdf";
	    
	    else
	    	fileName = "GradRates.pdf";
	    
	    File file = new File(getFilesDir(), fileName);
	    try
	    {
	        in = assetManager.open(fileName);
	        out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

	        copyFile(in, out);
	        in.close();
	        in = null;
	        out.flush();
	        out.close();
	        out = null;
	    } catch (Exception e)
	    {
	        Log.e("tag", e.getMessage());
	    }

	    Intent intent = new Intent(this, PDFViewerActivity.class);
	    intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME, getFilesDir()+ "/" + fileName);
	    startActivity(intent);
	
	}
}
