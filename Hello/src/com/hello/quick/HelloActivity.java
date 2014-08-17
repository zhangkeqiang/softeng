package com.hello.quick;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class HelloActivity extends Activity implements OnClickListener {
	private Button btnBMI, btnAbout, btnOpenSearch, btnOpenContentProviderActivity;
	private EditText edtHeight;
	private EditText edtWeight;
	private TextView txtSuggest;
	private TextView txtResult ;
   	private static final int HELLO_ID = 1; 
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViews();
        
        //btnBmi.setOnClickListener(calcBMI);
        btnBMI.setOnClickListener(this);
        //btnAbout.setOnClickListener(new AboutListener());
        btnAbout.setOnClickListener(new OnClickListener(){   
            public void onClick(View v) {     
                // TODO Auto-generated method stub     
            	Toast.makeText(HelloActivity.this, "这是一个提示", Toast.LENGTH_SHORT).show(); 
    			   
            }     
        });    
        
        btnOpenSearch.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Intent i = new Intent(HelloActivity.this, SearchActivity.class);
        		Bundle bundle = new Bundle();
        		bundle.putString("NAME", "KeQiang");
        		i.putExtras(bundle);
        		startActivity(i);
        	}
        });
        
        btnOpenContentProviderActivity.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		Intent i = new Intent(HelloActivity.this, ContentProviderActivity.class);
        		Bundle bundle = new Bundle();
        		bundle.putString("NAME", "ContentProviderActivity Showcase");
        		i.putExtras(bundle);
        		startActivity(i);
        	}
        });
        
    }
    
    void findViews()
    {
    	btnBMI = (Button) findViewById(R.id.submit);
    	btnAbout = (Button) findViewById(R.id.about);
    	btnOpenSearch = (Button) findViewById(R.id.opensearch);
    	btnOpenContentProviderActivity = (Button) findViewById(R.id.btnOpenContentProviderActivity);
    	edtHeight = (EditText) findViewById(R.id.height);
    	edtWeight = (EditText) findViewById(R.id.weight);
    	txtSuggest=(TextView)findViewById(R.id.suggest);
    	txtResult = (TextView) findViewById(R.id.result);
    }
    
    public void onClick(View v) 
	{
	   	double dbHeight = Double.parseDouble(edtHeight.getText().toString());
	   	double dbWeight = Double.parseDouble(edtWeight.getText().toString());
	   	BMI bmi = new BMI(dbHeight, dbWeight);  	
		DecimalFormat nf = new DecimalFormat("0.00");			
	   	txtResult.setText("BMI is " + nf.format(bmi.getBMI()));
	   	//Give health advice
	   	txtSuggest.setText(bmi.getAdvice());
	   	//set the status message
	   	//1.Get a reference to the NotificationManager: 
	   	String ns = Context.NOTIFICATION_SERVICE; 
	   	NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);

	   	//2.Instantiate the Notification: 
	   	int icon = R.drawable.stat_happy;    
	   	CharSequence tickerText = getResources().getString(bmi.getAdvice()); 
	   	long when = System.currentTimeMillis(); 
	   	Notification notification = new Notification(icon, tickerText, when);
	    //set the default sound
	   	//notification.defaults |= Notification.DEFAULT_SOUND;
	   	//notification.defaults |= Notification.DEFAULT_VIBRATE;
	   	notification.sound = Uri.parse("file:///sdcard/music/a.mp3");
	   	//3.Define the Notification's expanded message and Intent: 	
	   	Context context = getApplicationContext(); 
	   	CharSequence contentTitle = "BMI Notification"; 
	   	CharSequence contentText = "Hello World!" + tickerText; 
	   	Intent notificationIntent = new Intent(this, HelloActivity.class); 
	   	PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0); 
 
	   	notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent); 	
	

	    //4.Pass the Notification to the NotificationManager: 	 	 
	   	mNotificationManager.notify(HELLO_ID, notification);
	   	// That's it. Your user has now been notified.

        /**/
			
	}
    @Override 
    protected void onStart() { 
        super.onStart(); 
        // The activity is about to become visible. 
        Log.d("Hello","onStart");
    } 

    @Override 
    protected void onResume() { 
        super.onResume(); 
        // The activity has become visible (it is now "resumed"). 
        Log.d("Hello","onResume");
    } 
    @Override 
    protected void onPause() { 
        super.onPause(); 
        // Another activity is taking focus (this activity is about to be "paused"). 
        Log.d("Hello","onPause");
    } 
    @Override 
    protected void onStop() { 
        super.onStop(); 
        // The activity is no longer visible (it is now "stopped") 
        Log.d("Hello","onStop");
    } 
    @Override 
    protected void onDestroy() { 
        super.onDestroy(); 
        // The activity is about to be destroyed. 
        Log.d("Hello","onDestroy");
    } 

}
