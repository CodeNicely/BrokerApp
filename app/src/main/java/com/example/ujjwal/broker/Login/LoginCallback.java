package com.example.ujjwal.broker.Login;

import com.example.ujjwal.broker.Login.Data.LoginDataResponse;

/**
 * Created by ujjwal on 13/10/16.
 */
public interface LoginCallback {


	void onLoginSuccess(LoginDataResponse loginResponse);
	void onLoginFailure(String error);
}
