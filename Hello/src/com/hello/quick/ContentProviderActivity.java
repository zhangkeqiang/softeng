package com.hello.quick;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
//import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.Toast;

import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.content.ContentUris;
import android.net.Uri;
import android.database.Cursor;

@SuppressWarnings("deprecation")
public class ContentProviderActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        
        String strText = "Hello, ContentProvider demo View!"+bundle.getString("NAME");
     // Use the ContentUris method to produce the base URI for the contact with _ID == 23.
        Uri myPerson = ContentUris.withAppendedId(People.CONTENT_URI, 23);

        // Alternatively, use the Uri method to produce the base URI.
        // It takes a string rather than an integer.
        //Uri myPerson = Uri.withAppendedPath(People.CONTENT_URI, "23");

        // Then query for this specific record:
        Cursor cur = managedQuery(myPerson, null, null, null, null);
        int i=0;
        if (cur.moveToFirst()) {

            String name; 
            String phoneNumber; 
            int nameColumn = cur.getColumnIndex(People.NAME); 
            int phoneColumn = cur.getColumnIndex(People.NUMBER);
            String imagePath; 
        
            do {
                // Get the field values
                name = cur.getString(nameColumn);
                phoneNumber = cur.getString(phoneColumn);
                strText = strText + ". name is" +name;
                // Do something with the values. 
                

            } while (cur.moveToNext() && i++<10);

        }
        
        TextView tv = new TextView(this);
        tv.setText(strText);
        setContentView(tv);
        
        

        
    }   


}
