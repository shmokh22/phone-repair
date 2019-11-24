package amrayoub.drphone.data

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class SharedPrefsHelper(context: Context) {
    private val MY_PREFS = "ESSEN_PREFS"

    private val EMAIL = "EMAIL"

    private val TOKEN = "TOKEN"

    private val ZIP_CODE = "ZIP_CODE"


    var mSharedPreferences: SharedPreferences

    init {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE)
    }

    fun clear() {
        mSharedPreferences.edit().clear().apply()
    }

    fun putEmail(email: String) {
        mSharedPreferences.edit().putString(EMAIL, email).apply()
    }

    fun getEmail(): String {
        return mSharedPreferences.getString(EMAIL, null)
    }

    fun putToken(token: String) {
        mSharedPreferences.edit().putString(TOKEN, token).apply()
    }

    fun getToken(): String {
        return mSharedPreferences.getString(TOKEN, null)
    }

    fun putZipCode(zipCode: String) {
        mSharedPreferences.edit().putString(ZIP_CODE, zipCode).apply()
    }

    fun getZipCode(): String {
        return mSharedPreferences.getString(ZIP_CODE, "")
    }

    fun getLoggedInMode(): Boolean {
        return mSharedPreferences.getBoolean("IS_LOGGED_IN", false)
    }

    fun setLoggedInMode(loggedIn: Boolean) {
        mSharedPreferences.edit().putBoolean("IS_LOGGED_IN", loggedIn).apply()
    }

}