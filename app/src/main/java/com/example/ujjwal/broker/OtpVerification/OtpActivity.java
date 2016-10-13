package com.example.ujjwal.broker.OtpVerification;

	import android.os.Bundle;
	import android.support.v7.app.AppCompatActivity;
	import android.widget.TextView;

	import com.example.ujjwal.broker.R;


/**
 * Created by ujjwal on 13/10/16.
 */

public class OtpActivity extends AppCompatActivity {

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_otp);
			Bundle bundle = getIntent().getExtras();
			String message = bundle.getString("mobile");

			TextView txtView = (TextView) findViewById(R.id.mobile_text);
			txtView.setText("Please enter the OTP sent to your mobile number "+message);

		}

}