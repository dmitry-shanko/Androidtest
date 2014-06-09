package com.example.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class ButtonLoginListener implements OnClickListener 
{

	private Activity mainActivity;

	@Override
	public void onClick(View v) 
	{
		if (null == this.mainActivity)
		{
			//Заглушка
			//throw new NullPointerException();
		}
		else
		{
			EditText loginField = ((EditText)mainActivity.findViewById(R.id.login_field));
			EditText passwordField = ((EditText)mainActivity.findViewById(R.id.password_field));
			if ((loginField != null) && (passwordField != null))
			{
				String login = loginField.getText().toString();
				String password = passwordField.getText().toString();
				Intent intent = null;
				Bundle b = new Bundle();
				if("1234".equals(login))
				{
					intent = new Intent(mainActivity, MainActivity.class);
					b.putString("loginError", "true");
					b.putString("passwordError", "true");
				}
				else
				{
					intent = new Intent(mainActivity, SecondActivity.class);
					b.putString("message", "Your login:".concat(login).concat(".\nYour password:").concat(password));
				}				
				intent.putExtras(b);
				mainActivity.startActivity(intent);
			}			
		}
	}

	public void setMainActivity(Activity mainActivity)
	{
		this.mainActivity = mainActivity;
	}

	public Activity getMainActivity()
	{
		return this.mainActivity;
	}
}