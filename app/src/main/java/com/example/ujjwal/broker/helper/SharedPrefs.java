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
	private static final String KEY_HELPLINE_NUMBER1="helpline_mobile1";
	private static final String KEY_HELPLINE_NUMBER2="helpline_mobile2";
	private static final String KEY_HELPLINE_NUMBER3="helpline_mobile3";
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
	public void setHelplineNumber1(String helpline_number) {
		editor.putString(KEY_HELPLINE_NUMBER1, helpline_number);

		editor.commit();

	}

	public void setHelplineNumber2(String helpline_number) {
		editor.putString(KEY_HELPLINE_NUMBER2, helpline_number);

		editor.commit();

	}public void setHelplineNumber3(String helpline_number) {
		editor.putString(KEY_HELPLINE_NUMBER3, helpline_number);

		editor.commit();

	}
	public String getHelplineNumber1() {
		return pref.getString(KEY_HELPLINE_NUMBER1,"9425503905");
	}
	public String getHelplineNumber2() {
		return pref.getString(KEY_HELPLINE_NUMBER1,"9406202298");
	}
	public String getHelplineNumber3() {
		return pref.getString(KEY_HELPLINE_NUMBER1,"9300293177");
	}
}
