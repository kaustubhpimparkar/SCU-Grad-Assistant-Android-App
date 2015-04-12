package com.housing.project;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;
import net.sf.andpdf.pdfviewer.R;
import android.os.Bundle;

public class PDFViewerActivity extends PdfViewerActivity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    // TODO Auto-generated method stub
	}

	public int getPreviousPageImageResource() { return R.drawable.left_arrow; }
    public int getNextPageImageResource() { return R.drawable.right_arrow; }
    public int getZoomInImageResource() { return R.drawable.zoom_in; }
    public int getZoomOutImageResource() { return R.drawable.zoom_out; }
    public int getPdfPasswordLayoutResource() { return 0 /*R.layout.pdf_file_password*/; }
    public int getPdfPageNumberResource() { return 0/*R.layout.dialog_pagenumber*/; }
    public int getPdfPasswordEditField() { return 0/*R.id.etPassword*/; }
    public int getPdfPasswordOkButton() { return 0/*R.id.btOK*/; }
    public int getPdfPasswordExitButton() { return 0/*R.id.btExit*/; }
    public int getPdfPageNumberEditField() { return 0/*R.id.pagenum_edit*/; }
    
}