package com.example.ujjwal.broker.OtpVerification.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ujjwal.broker.Deals.View.DealsActivity;
import com.example.ujjwal.broker.OtpVerification.Data.OtpResponse;
import com.example.ujjwal.broker.OtpVerification.Model.RetrofitOtpVerifyHelper;
import com.example.ujjwal.broker.OtpVerification.Presenter.OtpVerifyPresenter;
import com.example.ujjwal.broker.OtpVerification.Presenter.OtpVerifyPresenterImp;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.helper.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by ujjwal on 13/10/16.
 */

public class OtpActivity extends AppCompatActivity implements OtpActivityInterface {


	@BindView(R.id.otpIn)
	Button sendOtp;

	@BindView(R.id.input_otp)
	EditText editTextOtp;

	@BindView(R.id.progress_bar_otp)
	ProgressBar progressBar;



	private String mobile_no;
	private String otp_number;
	private OtpVerifyPresenter otpVerifyPresenter;
	private SharedPrefs sharedPrefs;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_otp);
		ButterKnife.bind(this);
		if (getIntent() != null) {
			Bundle bundle = getIntent().getExtras();
			mobile_no = bundle.getString("mobile");
		}

		sharedPrefs = new SharedPrefs(this);
		TextView textView = (TextView) findViewById(R.id.mobile_text);
		textView.setText("Please enter the OTP sent to your mobile number " + mobile_no);

		editTextOtp = (EditText) findViewById(R.id.input_otp);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar_otp);
		editTextOtp.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {

			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
			if (s.length()==5){
				otp_number = editTextOtp.getText().toString();
				otpVerifyPresenter = new OtpVerifyPresenterImp(OtpActivity.this, new RetrofitOtpVerifyHelper());
				otpVerifyPresenter.getOtpData(otp_number, mobile_no);
			}
			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});
	}

	public void proceed_verify(View view) {

		otp_number = editTextOtp.getText().toString();
		otpVerifyPresenter = new OtpVerifyPresenterImp(this, new RetrofitOtpVerifyHelper());
		otpVerifyPresenter.getOtpData(otp_number, mobile_no);

	}



	@Override
	public void showProgressbar(boolean show) {
		if (show) {
			progressBar.setVisibility(View.VISIBLE);
		} else {
			progressBar.setVisibility(View.INVISIBLE);
		}

	}

	@Override
	public void showError(String error) {
		Toast.makeText(this, error, Toast.LENGTH_LONG).show();
	}

	@Override
	public void otpStatus(OtpResponse otpResponse) {
		;
		if (otpResponse.isSuccess())

		{
			Intent i = new Intent(this, DealsActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			sharedPrefs.setAccessToken(otpResponse.getAccess_token());
			sharedPrefs.setLogin(true);
			startActivity(i);
			finish();
		} else {
			Toast.makeText(this, "Wrong Otp", Toast.LENGTH_LONG).show();
		}
	}
}
