package amrayoub.drphone.data

import android.os.SystemClock

class SharedPrefsDataManager(sharedPrefsHelper: SharedPrefsHelper) {
    var mSharedPrefsHelper: SharedPrefsHelper

    init {
        mSharedPrefsHelper = sharedPrefsHelper
    }

    fun clear() {
        mSharedPrefsHelper.clear()
    }

    fun saveEmailId(email: String) {
        mSharedPrefsHelper.putEmail(email)
    }

    fun getEmailId(): String {
        return mSharedPrefsHelper.getEmail()
    }

    fun saveToken(token: String) {
        mSharedPrefsHelper.putToken(token)
    }

    fun getToken(): String {
        return mSharedPrefsHelper.getToken()
    }

    fun saveZipCode(zipCode:String){
        mSharedPrefsHelper.putZipCode(zipCode)
    }

    fun getZipCode():String{
        return mSharedPrefsHelper.getZipCode()
    }
    fun setLoggedIn() {
        mSharedPrefsHelper.setLoggedInMode(true)
    }

    fun getLoggedInMode(): Boolean {
        return mSharedPrefsHelper.getLoggedInMode()
    }

}