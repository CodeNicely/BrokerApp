package com.example.ujjwal.broker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ujjwal.broker.Login.View.LoginMainImp;

/**
 * Created by ujjwal on 13/10/16.
 */
public class WelcomeSliderScreen extends AppCompatActivity{


	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome_screen);

		Button button;
		button= (Button) findViewById(R.id.button_skip);
	}

	public  void skip (View v)
	{
		Intent i =new Intent(WelcomeSliderScreen.this,LoginMainImp.class);
		startActivity(i);
	}
}
