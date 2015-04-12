package com.photos.project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
 
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
 
public class Utils {
 
    private Context _context;
 
    // constructor
    public Utils(Context context) {
        this._context = context;
    }
 
    // Reading file paths from SDCard
    public ArrayList<String> getFilePaths() {
        final ArrayList<String> filePaths = new ArrayList<String>();
 
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Photo_Gallery");
		
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> tasks, ParseException e) {
		    	 if(tasks != null){
		    		 filePaths.clear();
		        	  for (int i = 0; i < tasks.size(); i++) {
		        		  //filePaths.add(tasks.get(i));
		        		  filePaths.add(tasks.get(i).getString("photo_url"));
		        		  Log.v("Images paths",tasks.get(i).getString("photo_url"));
		        		 // tasks.getString("photo_url");
						}
		          }
		    }
		});
        return filePaths;
    }
 
    // Check supported file extensions
    private boolean IsSupportedFile(String filePath) {
        String ext = filePath.substring((filePath.lastIndexOf(".") + 1),
                filePath.length());
 
        if (AppConstant.FILE_EXTN
                .contains(ext.toLowerCase(Locale.getDefault())))
            return true;
        else
            return false;
 
    }
 
    /*
     * getting screen width
     */
    public int getScreenWidth() {
        int columnWidth;
        WindowManager wm = (WindowManager) _context
                .getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
 
        final Point point = new Point();
        try {
            display.getSize(point);
        } catch (java.lang.NoSuchMethodError ignore) { // Older device
            point.x = display.getWidth();
            point.y = display.getHeight();
        }
        columnWidth = point.x;
        return columnWidth;
    }
}
