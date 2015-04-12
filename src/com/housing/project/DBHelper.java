package com.housing.project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{

    private static String DB_NAME = "mobilescu";
    private SQLiteDatabase mydatabase; 
    private final Context myContext;
    private static String DB_PATH;
    
    public DBHelper(Context context) {
    	 
    	super(context, DB_NAME, null, 1);
        this.myContext = context;
        DB_PATH = "/data/data/" + myContext.getPackageName() + "/" + "databases/";
    }
    
    public void createDataBase() throws IOException{
    	 
    	boolean dbExist = checkDataBase();
 
    	if(dbExist){;  	   	
        	    myContext.deleteDatabase(DB_NAME);
        	}
    	
    	
    	this.getReadableDatabase();
 
        	try {
       		this.close();
    			copyDataBase(); 
        		} catch (IOException e) {
 
        		throw new Error("Error copying database");
 
        	}
    	}
    //}
    private boolean checkDataBase(){
 
    	SQLiteDatabase checkDB = null;
 
    	try{
    		String myPath = DB_PATH + DB_NAME;
    		checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
    	}catch(SQLiteException e){
 
    	}
 
    	if(checkDB != null){
 
    		checkDB.close();
 
    	}
 
    	return checkDB != null ? true : false;
    }
 
    private void copyDataBase() throws IOException{
 
    	//Open your local db as the input stream
    	InputStream myInput = myContext.getAssets().open(DB_NAME);
 
    	String outFileName = DB_PATH + DB_NAME;
 
    	//Open the empty db as the output stream
    	OutputStream myOutput = new FileOutputStream(outFileName);
 
    	//transfer bytes from the inputfile to the outputfile
    	byte[] buffer = new byte[1024];
    	int length;
    	while ((length = myInput.read(buffer))>0){
    		myOutput.write(buffer, 0, length);
    	}
 
    	//Close the streams
    	myOutput.flush();
    	myOutput.close();
    	myInput.close();
 
    }
 
    public Cursor getData() {  
    	  String myPath = DB_PATH + DB_NAME;  
    	  mydatabase = SQLiteDatabase.openDatabase(myPath, null,  
    	  SQLiteDatabase.OPEN_READONLY);  
    	  Cursor c = mydatabase.rawQuery("SELECT * FROM offcampus_table", null);    
    	  return c;  
    	 } 
    	
    public Cursor getDataforSort(String query)
    {
    	Cursor c1 = mydatabase.rawQuery(query, null);
    	return c1;
    }
    
    @Override
	public synchronized void close() {
 
    	    if(mydatabase != null)
    		    mydatabase.close();
 
    	    super.close();
 
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
    
}