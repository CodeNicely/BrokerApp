package com.example.ujjwal.broker.Login.Model;

import com.example.ujjwal.broker.Login.LoginCallback;

/**
 * Created by ujjwal on 13/10/16.
 */
public interface LoginBaseClassHelper {
	void loginData(String mobile,String firm, String name,String city,String category,
				   LoginCallback loginCallback);
}
