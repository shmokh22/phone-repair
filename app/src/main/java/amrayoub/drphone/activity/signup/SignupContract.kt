package amrayoub.drphone.activity.signup

import android.widget.EditText
import amrayoub.drphone.base.BasePresenter
import amrayoub.drphone.base.BaseView

interface SignupContract {
    interface View {
        fun userSuccessfullyRegistered()
        fun startProgress()
        fun stopProgress()
    }

    interface Presenter : BasePresenter<View> {
        fun registerUser(
            first_name_et: EditText,
            last_name_et: EditText,
            email_et: EditText,
            password_et: EditText,
            confirm_password_et: EditText,
            phone_et: EditText
        )
    }
}