package com.contacts.project;


import java.util.List;

import com.code.project.R;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

public class ContactParseAdapter extends ArrayAdapter<ContactDetailSource>{

	Context context;
	private List<ContactDetailSource> mTasks;
	
	public ContactParseAdapter(Context context, List<ContactDetailSource> objects) {
	      super(context, R.layout.list_block_contact, objects);
	      this.context = context;
	      this.mTasks = objects;
	      
	     // Log.v("ContactParseAdapter",""+mTasks.get(1).getOfficeName());
	  }
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		//Log.v("in view","in view");
		View view = convertView;
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view=inflater.inflate(R.layout.list_block_contact, null);
		
		ContactDetailSource source = mTasks.get(position);
		//Log.v("in view","in view");
		//Log.v("in view",""+source.getOfficeName());
		 TextView officeName = (TextView) view.findViewById(R.id.contact_title_textview);
		 TextView officedeShortDescription = (TextView) view.findViewById(R.id.contact_shortDesc_textview);
		 officeName.setText(source.getOfficeName());
		 officedeShortDescription.setText(source.getOfficeShortDescription());
		return view;
	}
	
	
	

}
