package com.code.project;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.TextView;

public class IndexAdapter extends ArrayAdapter<String> {
	
	Context context;
	ImageView logo;
	TextView title;
	
	String[] titles;
	int[] logoId;
	private String currentView;
	
	public IndexAdapter(Context context,int[] logos,String[] titles,String whichView) {
		super(context, R.layout.grid_block,titles);
		this.context = context;
		this.logoId = logos;
		this.titles = titles;
		this.currentView = whichView;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return titles.length;
	}

	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
	
		View grid = convertView;
	
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(currentView.equals("listview")){
			grid = inflater.inflate(R.layout.list_block, parent, false);
		}else{
			grid = inflater.inflate(R.layout.grid_block, parent, false);
		}
		
		logo = (ImageView) grid.findViewById(R.id.imgItem);
		title = (TextView) grid.findViewById(R.id.txtItem);
		
		logo.setImageResource(logoId[position]);
		title.setText(titles[position]);
		//logo.setTag(titles[position]);
		return grid;
	}

}
