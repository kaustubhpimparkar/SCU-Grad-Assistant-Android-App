package com.housing.project;

import java.io.IOException;
import com.code.project.R;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OffCampusActivity extends Activity implements OnItemSelectedListener, OnClickListener {
	
	 String sort_by,search_by;
	 String sort_order="";
	 String query="";
	 Spinner spinner1,spinner2;
	 ListView list;
	 Button b;
	 Cursor c1;
	 CheckBox ch1; //= (CheckBox)findViewById(R.id.checkBox1);
	 CheckBox ch2;// = (CheckBox)findViewById(R.id.checkBox2);
	 EditText et;
	 
	 ArrayAdapter adapter1,adapter2;
	 DBHelper myDbHelper;	

	 String[] from = new String[] { "Apartment", "Address","City","State",
			 "Postal_Code","Telephone","Studio_Price_in_$","One_Bedroom_Price_in_$", 
			 "Two_Bedroom_Price_in_$","Three_Bedroom_Price_in_$","Deposit",
			 "Miles_from_SCU","Crd_Ck"};
 	 int[] to = new int[] { R.id.apartment_text, R.id.address_text, R.id.city_text, 
 			 R.id.state_text, R.id.postal_text,R.id.telephone_text,
 			 R.id.studio_text,R.id.onebedroom_text,R.id.twobedroom_text,
 			 R.id.threebedroom_text,R.id.deposit_text,R.id.miles_text,
 			 R.id.crd_ck_text};
 	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_off_campus);

		list = (ListView) findViewById(R.id.listView1);
		spinner1 = (Spinner)findViewById(R.id.spinner1);
		spinner2 = (Spinner)findViewById(R.id.spinner2);
		
		adapter1 = ArrayAdapter.createFromResource(this, R.array.SortBySpinner, android.R.layout.simple_spinner_item);
		spinner1.setAdapter(adapter1);
		adapter2 = ArrayAdapter.createFromResource(this, R.array.SearchBySpinner, android.R.layout.simple_spinner_item);
		spinner2.setAdapter(adapter2);
		
		spinner1.setOnItemSelectedListener(this);
		spinner2.setOnItemSelectedListener(this);
		
		ch1 = (CheckBox)findViewById(R.id.checkBox1);
		ch2 = (CheckBox)findViewById(R.id.checkBox2);
		ch1.setOnClickListener(this);
		ch2.setOnClickListener(this);			  
		
		et=(EditText)findViewById(R.id.editText1);
		et.setText("");
		
		myDbHelper = new DBHelper(this);
		
			   try {
				myDbHelper.createDataBase();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		
	    Cursor c = myDbHelper.getData();
	   	SimpleCursorAdapter adapter = new SimpleCursorAdapter(getApplicationContext(), R.layout.single_row , c, from, to);
		list.setAdapter(adapter);
		 
		Button b = (Button)findViewById(R.id.button1);
				
		b.setOnClickListener(new OnClickListener() {
					
				@Override
				public void onClick(View v) {
				
						getQueryforSorting();
						SimpleCursorAdapter adapter2 = new SimpleCursorAdapter(getApplicationContext(), R.layout.single_row , c1, from, to);
						list.setAdapter(adapter2);							
				
				}});
	}
	
	public void getQueryforSorting()
	{   
		
		if(sort_order!=null && et.getText().toString().length()==0)
		{
			query = "select * from offcampus_table ORDER BY "+sort_by+" " + sort_order;
			
		}
		
		if(sort_order==null && et.getText().toString().length()>0)
		{
			query = "select * from offcampus_table where " + search_by + " = UPPER('"+et.getText().toString()+"')";
		}
		
		if(sort_order!=null && et.getText().toString().length()>0)
		{
			query = "select * from offcampus_table where "+ search_by +" = UPPER('"+et.getText().toString()+"') ORDER BY "+sort_by+" " + sort_order;
		}
		
		c1 = myDbHelper.getDataforSort(query);
	}
	
	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		TextView sort_view = (TextView) view;
		if(ch1.isChecked())
		{	
			sort_order = (String) sort_view.getText();	
		}
		else
		{			
			sort_order = (String) sort_view.getText();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.off_campus, menu);
		return true;
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View view, int position,
			long arg3) {
		// TODO Auto-generated method stub
		if(arg0.getId()== R.id.spinner1)
		{
		//TextView myText = (TextView) view;
		sort_by = "Miles_from_SCU";//(String) myText.getText();
		}
		if(arg0.getId()== R.id.spinner2)
		{
		TextView myText1 = (TextView) view;
		search_by = (String) myText1.getText();
		}
		//Toast.makeText(this, "You selected"+myText.getText(), Toast.LENGTH_SHORT).show();		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		
		// TODO Auto-generated method stub		
	}
}