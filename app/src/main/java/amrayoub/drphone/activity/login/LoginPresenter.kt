package amrayoub.drphone.activity.login

import android.widget.EditText
import amrayoub.drphone.util.Utility


class LoginPresenter() : LoginContract.Presenter {
    private lateinit var mLoginView: LoginContract.View

    override fun attach(view: LoginContract.View) {
        mLoginView = view
    }

    override fun checkInput(emailId: EditText, password: EditText) {
        //check if the input fields are not empty and follow the standards
        if (Utility.SignIn(emailId, password).validate()) {
            mLoginView.startProgress()
            authenticate(emailId.text.toString(), password.text.toString())
        }
    }

    //authenticate user by  sending email and password to backend
    override fun authenticate(emailId: String, password: String) {
        //call API to authentication
        //create RetrofitClient instance for network calls.
        //call authenticateLogin method to authenticate user
        startLogin(emailId, "")
    }

    override fun startLogin(emailId: String, userAccessToken: String) {
        saveLoginData(emailId, userAccessToken)
        mLoginView.stopProgress()
        mLoginView.openMainActivity()
    }

    //save user info at the Shared Prefs
    private fun saveLoginData(emailId: String, userAccessToken: String) {
        /*mDataManager.saveEmailId(emailId)
        mDataManager.saveToken(userAccessToken)
        mDataManager.setLoggedIn()*/
    }

}