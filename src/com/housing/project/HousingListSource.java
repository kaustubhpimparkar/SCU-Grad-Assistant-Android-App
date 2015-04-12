package com.housing.project;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Contact_data")
public class HousingListSource extends ParseObject{

	public HousingListSource()
	{
		
	}
	  public String getHousingDescription(){
	      return getString("housing_description");
	  }

	  public void setHousingDescription(String description){
	      put("housing_description", description);
	  }
}
