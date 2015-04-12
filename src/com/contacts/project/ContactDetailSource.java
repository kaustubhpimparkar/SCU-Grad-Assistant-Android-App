package com.contacts.project;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("Contact_data")
public class ContactDetailSource extends ParseObject{
	
	public ContactDetailSource(){
		
	}
	
	public String getOfficePhone(){
	      return getString("office_phone");
	  }

	  public void setOfficePhone(String office_phone){
	      put("office_phone", office_phone);
	  }
	  
	  public String getOfficeImage(){
	      return getString("office_image");
	  }

	  public void setOfficeImage(String office_image){
	      put("office_image", office_image);
	  }

	  public String getOfficeEmail(){
	      return getString("office_email");
	  }

	  public void setOfficeEmail(String office_email){
	      put("office_email", office_email);
	  }

	  public String getOfficeName(){
	      return getString("office_name");
	  }

	  public void setOfficeName(String office_name){
	      put("office_name", office_name);
	  }

	  public String getOfficeShortDescription(){
	      return getString("office_short_description");
	  }

	  public void setOfficeShortDescription(String office_short_description){
	      put("office_short_description", office_short_description);
	  }

	  public String getOfficeLongDescription(){
	      return getString("office_long_description");
	  }

	  public void setOfficeLongDescription(String office_long_description){
	      put("office_long_description", office_long_description);
	  }
	  
	  public String getOfficeFax(){
	      return getString("office_fax");
	  }

	  public void setOfficeFax(String office_fax){
	      put("office_fax", office_fax);
	  }
	 
}
