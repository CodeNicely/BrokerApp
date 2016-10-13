package com.example.ujjwal.broker.OtpVerification.View;

	import android.content.Intent;
	import android.os.Bundle;
	import android.support.design.widget.TextInputLayout;
	import android.support.v7.app.AppCompatActivity;
	import android.view.View;
	import android.widget.Button;
	import android.widget.EditText;
	import android.widget.ProgressBar;
	import android.widget.TextView;
	import android.widget.Toast;

	import com.example.ujjwal.broker.MainActivity;
	import com.example.ujjwal.broker.OtpVerification.Model.OtpVerifyHelperInterface;
	import com.example.ujjwal.broker.OtpVerification.Model.RetrofitOtpVerifyHelper;
	import com.example.ujjwal.broker.OtpVerification.Presenter.OtpVerifyData;
	import com.example.ujjwal.broker.OtpVerification.Presenter.OtpVerifyDataImp;
	import com.example.ujjwal.broker.R;


/**
 * Created by ujjwal on 13/10/16.
 */

public class OtpActivity extends AppCompatActivity implements OtpActivityInterface{


	private Button button;
	TextInputLayout textInputLayoutOtp;
	EditText editTextOtp;
	ProgressBar progressBar;
	String mobile_no;
	String otp_number;
	private OtpVerifyData otpVerifyData;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_otp);

				Bundle bundle = getIntent().getExtras();
			String mobile_no = bundle.getString("mobile");

			TextView txtView = (TextView) findViewById(R.id.mobile_text);
			txtView.setText("Please enter the OTP sent to your mobile number "+mobile_no);

			textInputLayoutOtp=(TextInputLayout)findViewById(R.id.input_layout_otp);
			editTextOtp=(EditText)findViewById(R.id.input_otp);
			button=(Button)findViewById(R.id.otpIn);
			progressBar=(ProgressBar)findViewById(R.id.progressBar);
		}
	public void proceed_verify(View view){

		otp_number=editTextOtp.getText().toString();
		otpVerifyData=new OtpVerifyDataImp(this,new RetrofitOtpVerifyHelper());
		otpVerifyData.getOtpData(otp_number,mobile_no);

	}


	@Override
	public void showProgressbar(boolean show) {
		if (show){
			progressBar.setVisibility(View.VISIBLE);
		}else {
			progressBar.setVisibility(View.INVISIBLE);
		}

	}

	@Override
	public void showError(String error) {
		Toast.makeText(this,error,Toast.LENGTH_LONG).show();
	}

	@Override
	public void otpStatus(boolean status) {
		if(status)
		{
			Intent i =new Intent(this, MainActivity.class);
			startActivity(i);
		}
		else
		{
			Toast.makeText(this,"Wrong Otp",Toast.LENGTH_LONG).show();
		}
	}
}