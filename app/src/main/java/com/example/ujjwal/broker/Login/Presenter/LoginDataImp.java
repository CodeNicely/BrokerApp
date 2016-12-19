package com.example.ujjwal.broker.Login.Presenter;

import com.example.ujjwal.broker.Login.Data.LoginDataResponse;
import com.example.ujjwal.broker.Login.LoginCallback;
import com.example.ujjwal.broker.Login.Model.LoginBaseClassHelper;
import com.example.ujjwal.broker.Login.Model.RetrofitLoginHelper;

import com.example.ujjwal.broker.Login.View.LoginMain;
import com.example.ujjwal.broker.Login.View.LoginMainImp;

/**
 * Created by ujjwal on 13/10/16.
 */
public class LoginDataImp implements LoginData{
		private LoginBaseClassHelper loginBaseClassHelper;
	 	private LoginMain login;

	public LoginDataImp(LoginMain login,LoginBaseClassHelper loginBaseClassHelper) {
		this.loginBaseClassHelper = loginBaseClassHelper;
		this.login = login;
	}


	@Override
	public void getLoginData(String mobile, String firm, String name, String city, String category) {
		login.showProgressBar(true);
		loginBaseClassHelper.loginData(mobile, firm, name, city, category, new LoginCallback() {
			@Override
			public void onLoginSuccess(LoginDataResponse loginResponse) {
				if(loginResponse.isSuccess()) {
					login.showProgressBar(false);
					login.showLoginStatus(true);
				}
			}

			@Override
			public void onLoginFailure(String error) {
				login.showError(error);
				login.showLoginStatus(false);
				login.showProgressBar(false);
			}
		});

	}
}
