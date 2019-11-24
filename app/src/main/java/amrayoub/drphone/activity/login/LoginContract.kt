package amrayoub.drphone.activity.login

import android.widget.EditText
import amrayoub.drphone.base.BasePresenter
import amrayoub.drphone.base.BaseView

interface LoginContract {
    interface View {
        fun onLoginButtonClick()
        fun onSignupButtonClick()
        fun onForgotButtonClick()
        fun openMainActivity()
        fun loginError(msg: String)
        fun startProgress()
        fun stopProgress()
    }

    interface Presenter : BasePresenter<View> {
        fun startLogin(emailId: String, userAccessToken: String)
        fun checkInput(emailId: EditText, password: EditText)
        fun authenticate(emailId: String, password: String)
    }
}