package com.example.androidtest;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ButtonRegisterListener implements OnClickListener 
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
			Intent intent = new Intent(mainActivity, RegisterActivity.class);
			mainActivity.startActivity(intent);
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
