package com.example.lifetag;

import java.util.Calendar;
import android.view.KeyEvent;
import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.text.format.Time;
import android.view.Menu;
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	long milliSeconds;
	String name = "";
	String nricNumber = "";

	private static final int BIRTH_DATE_DIALOG_ID = 3;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setEventListeners();
		setContentView(R.layout.activity_main);
	}

	private void setEventListeners() {
		((EditText)findViewById(R.id.EditTextName)).setOnEditorActionListener(
			    new EditText.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			    if (actionId == EditorInfo.IME_ACTION_SEARCH ||
			            actionId == EditorInfo.IME_ACTION_DONE ||
			            event.getAction() == KeyEvent.ACTION_DOWN &&
			            event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
			        if (!event.isShiftPressed()) {
			           // the user is done typing. 
			        	String temp = v.getText().toString();
			        	if (!temp.equals(name)) {
			        		name = temp;
			        		System.out.println(name);
			        	}
			           return true; // consume.
			        }                
			    }
			    return false; // pass on to other listeners. 
			}
		});
		
		((EditText)findViewById(R.id.nricNo)).setOnEditorActionListener(
			    new EditText.OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
			    if (actionId == EditorInfo.IME_ACTION_SEARCH ||
			            actionId == EditorInfo.IME_ACTION_DONE ||
			            event.getAction() == KeyEvent.ACTION_DOWN &&
			            event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
			        if (!event.isShiftPressed()) {
			           // the user is done typing. 
			        	String temp = v.getText().toString();
			        	if (!temp.equals(nricNumber)) {
			        		nricNumber = temp;
			        		System.out.println(nricNumber);
			        	}
			           return true; // consume.
			        }                
			    }
			    return false; // pass on to other listeners. 
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	  protected Dialog onCreateDialog(int id) {
	    switch (id) {
	    case BIRTH_DATE_DIALOG_ID:
	        DatePickerDialog dateDlg = new DatePickerDialog(this,
	             new DatePickerDialog.OnDateSetListener() {
	             public void onDateSet(DatePicker view, int year,
	                                                 int monthOfYear, int dayOfMonth)
	             {
	                        Time chosenDate = new Time();
	                        chosenDate.set(dayOfMonth, monthOfYear, year);
	                        milliSeconds = chosenDate.toMillis(true);
	            }}, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE));
	          dateDlg.setMessage("What is your date of birth?");
	          return dateDlg;
	    }
	    return super.onCreateDialog(id);
	  }
	
	/*@Override
	protected void onResume() {
	    
	}*/
}
