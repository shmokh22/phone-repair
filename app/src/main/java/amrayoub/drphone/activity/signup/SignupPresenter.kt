package amrayoub.drphone.activity.signup

import android.util.Log
import android.widget.EditText
import amrayoub.drphone.data.SharedPrefsDataManager
import amrayoub.drphone.util.Utility


class SignupPresenter(val mDataManager: SharedPrefsDataManager) : SignupContract.Presenter {
    private lateinit var mSignView: SignupContract.View
    override fun attach(view: SignupContract.View) {
        mSignView = view
    }

    override fun registerUser(
        first_name_et: EditText, last_name_et: EditText, email_et: EditText,
        password_et: EditText, confirm_password_et: EditText, phone_et: EditText
    ) {

        //check fields
        val valid = Utility.SignUp(
            first_name_et, last_name_et,
            email_et, password_et, confirm_password_et, phone_et
        ).validate()

    }

    private fun addInSharedPrefs(email_et: EditText, user_access_token: String) {
        mDataManager.clear()
        mDataManager.saveEmailId(email_et.text.toString())
        mDataManager.saveToken(user_access_token)
    }
}