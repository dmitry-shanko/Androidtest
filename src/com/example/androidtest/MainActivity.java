package com.example.androidtest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_activity);
		ButtonRegisterListener registerListener = new ButtonRegisterListener();
		registerListener.setMainActivity(this);
		findViewById(R.id.button_register).setOnClickListener(registerListener);
		ButtonLoginListener loginListener = new ButtonLoginListener();
		loginListener.setMainActivity(this);
		findViewById(R.id.button_enter).setOnClickListener(loginListener);
		Intent intent = getIntent();
		if (intent != null)
		{
			Bundle bundle = intent.getExtras();
			if (bundle != null)
			{
				if("true".equalsIgnoreCase(bundle.getString("loginError")))
				{
					((TextView)findViewById(R.id.login_field_error)).setText(getString(R.string.login_field_error));
				}
				if("true".equalsIgnoreCase(bundle.getString("passwordError")))
				{
					((TextView)findViewById(R.id.password_field_error)).setText(getString(R.string.password_field_error));
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
