package com.example.ujjwal.broker.Login.View;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ujjwal.broker.Login.Model.RetrofitLoginHelper;
import com.example.ujjwal.broker.Login.Presenter.LoginData;
import com.example.ujjwal.broker.Login.Presenter.LoginDataImp;
import com.example.ujjwal.broker.OtpVerification.View.OtpActivity;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.WelcomeScreen.View.WelcomeActivity;
import com.example.ujjwal.broker.helper.Keys;
import com.example.ujjwal.broker.helper.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 13/10/16.
 */
public class LoginMainImp extends AppCompatActivity implements LoginMain{
	private EditText editTextMobile;
	private EditText editTextName;
	private EditText editTextFirm;
	private EditText editTextCity;
	private EditText editTextCategory;

	private ProgressBar progressBar;
	private LoginData loginData;
	private String name,mobile,firm,city,category;
	private SharedPrefs sharedPrefs;

	@BindView(R.id.toolbar)
	Toolbar toolbar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		ButterKnife.bind(this);
		toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginMainImp.this,WelcomeActivity.class));
				finish();
			}
		});
		sharedPrefs =new SharedPrefs(this);
		initialise();
	}

	private void initialise() {
		editTextName= (EditText) findViewById(R.id.input_name);
		editTextFirm= (EditText) findViewById(R.id.input_firm);
		editTextMobile= (EditText) findViewById(R.id.input_mobile);
		editTextCity= (EditText) findViewById(R.id.input_city);
		editTextCategory=(EditText)findViewById(R.id.input_category);

		progressBar= (ProgressBar) findViewById(R.id.progressBar);

		editTextMobile.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			if(s.length()==10) {

				hideKeyboard();
			}
			}
			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	private void hideKeyboard() {

		View view = this.getCurrentFocus();
		if (view != null) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}

	}

	public void proceed(View v) {
		String name = editTextName.getText().toString();
		String mobile = editTextMobile.getText().toString();
		String firm = editTextFirm.getText().toString();
		String city = editTextCity.getText().toString();
		String category =editTextCategory.getText().toString();

		if(name.isEmpty()|| mobile.isEmpty()|| firm.isEmpty() || city.isEmpty()|| category.isEmpty()){
			showProgressBar(false);
			showError("Fields Cannot be empty");

		}
		else{

			loginData = new LoginDataImp(this, new RetrofitLoginHelper());
			loginData.getLoginData(mobile, firm, name,city,category);
			hideKeyboard();
		}
	}

	@Override
	public void showProgressBar(boolean show) {
	if (show){
	progressBar.setVisibility(View.VISIBLE);
	}else {
	progressBar.setVisibility(View.INVISIBLE);
	}
	}

	@Override
	public void showLoginStatus(boolean login) {

		if (login)
		{
			sharedPrefs.setMobile(mobile);

			Intent i = new Intent(this, OtpActivity.class);
			i.putExtra(Keys.KEY_MOBILE, mobile);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(i);
			finish();
		}
	}

	@Override
	public void showError(String message) {
		Toast.makeText(this,message,Toast.LENGTH_LONG).show();
	}

}
