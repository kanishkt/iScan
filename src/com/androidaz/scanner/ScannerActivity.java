package com.androidaz.scanner;

import android.app.AlertDialog;
import android.app.SearchManager.OnCancelListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.client.android.CaptureActivity;

public class ScannerActivity extends CaptureActivity 
{
	AlertDialog alertDialog;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        super.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    
    @Override 
    public void handleDecode(Result rawResult, Bitmap barcode) 
    {
    	//barcode.
    	//rawResult.getBarcodeFormat();
    	//rawResult.
    	Toast.makeText(this.getApplicationContext(), "Scanned code " + rawResult.getText(), Toast.LENGTH_LONG);
    	
    	
    	AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(rawResult.getText()+"---"+rawResult.getBarcodeFormat());
        
//        rawResult.
        
        alertDialog = alertDialogBuilder.create();
        
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.song);
        mediaPlayer.start();
        alertDialog.show();
        alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {         
            @Override
            public void onCancel(DialogInterface dialog) {
                //do whatever you want the back key to do
            	  	finish();
            	    Intent intent = new Intent(ScannerActivity.this, ScannerActivity.class);
            	    startActivity(intent);
            }
        });
    }
}