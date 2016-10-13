package com.example.ujjwal.broker.Login.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ujjwal.broker.Login.Model.RetrofitLoginHelper;
import com.example.ujjwal.broker.Login.Presenter.LoginData;
import com.example.ujjwal.broker.Login.Presenter.LoginDataImp;
import com.example.ujjwal.broker.OtpActivity;
import com.example.ujjwal.broker.R;

/**
 * Created by ujjwal on 13/10/16.
 */
public class LoginMainImp extends AppCompatActivity implements LoginMain{
	private EditText editTextMobile;
	private TextInputLayout textInputLayoutMobile;
	private TextInputLayout textInputLayoutName;
	private EditText editTextName;
	private EditText editTextFirm;
	private TextInputLayout textInputLayoutFirm;

	private ProgressBar progressBar;
	private Button button;
	private LoginData loginData;
	private RetrofitLoginHelper retrofitLoginHelper;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		initialise();
	}

	private void initialise() {
		editTextName= (EditText) findViewById(R.id.input_name);
		editTextFirm= (EditText) findViewById(R.id.input_firm);
		editTextMobile= (EditText) findViewById(R.id.input_mobile);
		textInputLayoutName= (TextInputLayout) findViewById(R.id.input_layout_name);
		textInputLayoutFirm= (TextInputLayout) findViewById(R.id.input_layout_firm);
		textInputLayoutMobile= (TextInputLayout) findViewById(R.id.input_layout_mobile);

	}
	public void proceed(View v)
	{
		String name=editTextName.getText().toString();
		String mobile =editTextMobile.getText().toString();
		String firm=editTextFirm.getText().toString();

		loginData= new LoginDataImp(this,new RetrofitLoginHelper());
		loginData.getLoginData(mobile,firm,name);

	}

	@Override
	public void showProgressBar(boolean show) {
	/*if (show){
	progressBar.setVisibility(View.VISIBLE);
	}else {
	progressBar.setVisibility(View.INVISIBLE);
	}
	*/}

	@Override
	public void showLoginStatus(boolean login) {

		if (login)
		{
			Intent i = new Intent(this, OtpActivity.class);
			startActivity(i);
		}
	}

	@Override
	public void showError(String message) {
		Toast.makeText(this,message,Toast.LENGTH_LONG).show();
	}

}
