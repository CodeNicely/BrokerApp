package com.example.ujjwal.broker.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ujjwal on 10/12/16.
 */
public class SharedPrefs {


	//shared preference file name
	private static final String KEY_IS_LOGGED_IN="isLoggedIn";
	private static final String PREFERENCE_NAME="Welcome";
	private static final String KEY_MOBILE = "mobile";
	private static final String KEY_ACCESS_TOKEN ="access_token" ;

	//Shared Preferences
	SharedPreferences pref ;
	SharedPreferences.Editor editor;
	Context _context;

	//Shared Preference Mode
	int PRIVATE_MODE = 0;

	public SharedPrefs(Context context){
	this._context =context;
	pref =_context.getSharedPreferences(PREFERENCE_NAME,PRIVATE_MODE);
	editor=pref.edit() ;
	}

	public void setLogin(boolean isLoggedIn){
	editor.putBoolean(KEY_IS_LOGGED_IN,isLoggedIn);
		editor.commit();
		
	}
	public boolean iSLoggedIn(){
		return pref.getBoolean(KEY_IS_LOGGED_IN,false);
	}




	public void setMobile(String mobile) {

		editor.putString(KEY_MOBILE, mobile);
		editor.commit();

	}
	public String getAccessToken(){
		return  pref.getString(KEY_ACCESS_TOKEN,null);
	}

	public  void setAccessToken(String accessToken){
		editor.putString(KEY_ACCESS_TOKEN,accessToken);
		editor.commit();
	}
}
