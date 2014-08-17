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
import android.app.AlertDialog;
import android.content.DialogInterface;

public class SearchActivity extends Activity {

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        /*
        TextView tv = new TextView(this);
        tv.setText("Hello 2nd View!"+bundle.getString("NAME"));
        setContentView(tv);
        */
        setContentView(R.layout.search);
        TextView txtResult = (TextView) findViewById(R.id.searchresult);
        txtResult.setText("Hello 2nd View!  "+bundle.getString("NAME"));
        Button btnMessage = (Button) findViewById(R.id.message);
        btnMessage.setOnClickListener(new MessageListener());
    }
    
	class MessageListener implements OnClickListener
	{
		public void onClick(View v) 
		{
			new AlertDialog.Builder(SearchActivity.this) 
		     .setTitle("Android 提示") 
		     .setMessage("这是一个提示,请确定") 
		     .setPositiveButton("确定", 
		    		 new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							//空方法，让消息对话框消失
						}
					
		    		 //new DialogInterface.OnClickListener(){ 
                     //	public void onClick(DialogInterface dialoginterface, int i){ 
                                     //按钮事件 
                     		//finish();
                     		
                     //   } 
                     }) 
		     .show();
		}		
	}

}
