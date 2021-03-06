package com.um.ui;

import com.um.dvtca.R;
import com.um.dvbstack.Ca;
import com.um.dvbstack.DVB;
import com.um.controller.AppBaseActivity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Dvt_small_pin extends AppBaseActivity{
	private Button enter_btn;
	private EditText pin;
	
	@Override
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dvt_small_pin);
			    
		pin = (EditText)findViewById(R.id.editText1);
		pin.setText(pin.getText().toString());
		pin.setSelection(pin.getText().toString().length());
		
		/*button*/
		enter_btn = (Button)findViewById(R.id.button1);
		
		enter_btn.setText(R.string.ok);
		
		enter_btn.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View arg0) {
				
				Ca ca = new Ca(DVB.getInstance());
				
				String str = String.valueOf(pin.getText());
				byte[] temp1 = str.getBytes();	
				Log.i("CA","CA str:"+str);	
				
				if(temp1.length != 8){
					new AlertDialog.Builder(Dvt_small_pin.this)
					.setMessage(R.string.dvt_pin_err)
					.setPositiveButton("ok", null)
					.show();
					
					return;
				}
				
				if(ca.CaVerifyPin(temp1,8) != 0)
				{
					new AlertDialog.Builder(Dvt_small_pin.this)
//					.setTitle(R.string.dvt_change_watch_level_notice)
					.setMessage(R.string.dvt_pin_err)
					.setPositiveButton("ok", null)
					.show();
					Log.i("CA","CA CaVerifyPin fail");	
				}
				else
				{
		        	Intent it1 = new Intent(Dvt_small_pin.this, Dvt_ipp_order_info.class);
		        	startActivity(it1);   
				}
			}
			}
		);

        setAutoFinish(Constant.AUTO_FINISH_WAIT_TIME_SHORT, null);
	}
	
	@Override
	protected void onPause(){
        super.onPause();
        finish();
	}
}
