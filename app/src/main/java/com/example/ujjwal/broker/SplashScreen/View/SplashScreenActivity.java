package com.example.ujjwal.broker.SplashScreen.View;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ujjwal.broker.Deals.View.DealsActivity;
import com.example.ujjwal.broker.Login.View.LoginMainImp;
import com.example.ujjwal.broker.R;
import com.example.ujjwal.broker.SplashScreen.Model.Data.SplashScreenData;
import com.example.ujjwal.broker.SplashScreen.Model.ReterofitSplashScreenProvider;
import com.example.ujjwal.broker.SplashScreen.Presenter.SplashScreenPresenter;
import com.example.ujjwal.broker.SplashScreen.Presenter.SplashScreenPresenterImpl;
import com.example.ujjwal.broker.helper.MyApplication;
import com.example.ujjwal.broker.helper.SharedPrefs;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 11/12/16.
 */
public class SplashScreenActivity extends Activity implements SplashScreenView {

	private Handler handler;
	private SplashScreenPresenter splashScreenPresenter ;
	private SharedPrefs sharedPrefs;
/*

	@BindView(R.id.BrokerApp_Logo)
	ImageView broker_app_logo;

	@BindView(R.id.CodeNicelyLogo)
	ImageView codenicely_logo;
*/




	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		ButterKnife.bind(this);
		/*Glide.with(this).load(R.drawable.ic_menu_gallery).into(codenicely_logo);
		Glide.with(this).load(R.drawable.ic_menu_gallery).into(broker_app_logo);
*/
		splashScreenPresenter =new SplashScreenPresenterImpl(this,new ReterofitSplashScreenProvider());
		splashScreenPresenter.sendFcm(MyApplication.getFcm_token());
		Log.i("SplashScreen","FCM Token"+MyApplication.getFcm_token());

		sharedPrefs = new SharedPrefs(this);

	}


	@Override
	public void onVersionRecived(SplashScreenData splashScreenData) throws PackageManager.NameNotFoundException {

		if(getPackageManager().getPackageInfo(getPackageName(),0).versionCode < splashScreenData.getVersion()
				&& !splashScreenData.isCompusory_Update()){

			final AlertDialog alertDialog=new AlertDialog.Builder(this).create();

			alertDialog.setCancelable(false);
			alertDialog.setTitle("App Update Available");
			alertDialog.setMessage("Please Update App for Better App Experience");
			alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"update", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					alertDialog.cancel();
					final String appPackageName= getPackageName(); // getPackageName() from Context or Activity object
					try {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
					}catch (android.content.ActivityNotFoundException e){
						startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
					}

					finish();
				}
			});
			alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"Not Now", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					alertDialog.cancel();

					if (sharedPrefs.iSLoggedIn()) {
						startActivity(new Intent(SplashScreenActivity.this, DealsActivity.class));
						finish();
					}else{
						startActivity(new Intent(SplashScreenActivity.this, LoginMainImp.class));
						finish();
					}

				}

			});

			alertDialog.show();
		}else if(getPackageManager().getPackageInfo(getPackageName(),0).versionCode < splashScreenData.getVersion()
				&& splashScreenData.isCompusory_Update()){

			final AlertDialog alertDialog =new AlertDialog.Builder(this).create();

			alertDialog.cancel();
			alertDialog.setTitle("App Update Availabale");
			alertDialog.setMessage("This is a compulsary update .Please update the app to enjoy our Services");
			alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"Update", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					alertDialog.cancel();
					final String appPackageName =getPackageName();
					try {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
					} catch (android.content.ActivityNotFoundException anfe) {
						startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
					}
					finish();
				}
			});
			alertDialog.show();



		}else {

			handler = new Handler();
			handler.postDelayed(new Runnable() {
				@Override
				public void run() {

					if (sharedPrefs.iSLoggedIn()) {
						startActivity(new Intent(SplashScreenActivity.this, DealsActivity.class));
						finish();
					}else{
						startActivity(new Intent(SplashScreenActivity.this, LoginMainImp.class));
						finish();
					}

				}
			}, 3000);
		}



	}

	@Override
	public void onFailed() {
	handler =new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				if(sharedPrefs.iSLoggedIn()){
					startActivity(new Intent(SplashScreenActivity.this, DealsActivity.class));
					finish();
				}
				else
				{
					startActivity(new Intent(SplashScreenActivity.this,LoginMainImp.class));
					finish();
				}

			}
		},3000);
	}

	@Override
	public void showMessage(String message) {
		Toast.makeText(SplashScreenActivity.this, message, Toast.LENGTH_SHORT).show();

	}
}
