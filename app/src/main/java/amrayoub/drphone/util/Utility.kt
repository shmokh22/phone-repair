package amrayoub.drphone.util

import android.widget.EditText

class Utility {
    class SignIn(var login_email_et: EditText, var login_password_et: EditText) {
        fun validate(): Boolean {
            if (checkEmail() && checkPassword())
                return true
            return false
        }

        private fun checkEmail(): Boolean {
            val bool: Boolean = android.util.Patterns.EMAIL_ADDRESS.matcher(login_email_et.text).matches()
            if (!bool) {//email is not matching with the standard Email template.
                login_email_et.error = "Not a valid email address"
            }
            return bool
        }

        private fun checkPassword(): Boolean {
            if (login_password_et.text.length >= 8)
                return true
            login_password_et.error = "Not a valid password"
            return false
        }
    }

    class SignUp(var signup_first_name_et: EditText, var signup_last_name_et: EditText,
                 var signup_email_et: EditText,
                 var signup_password_et: EditText, var signup_confirm_password_et: EditText,
                 var signup_phone_et: EditText) {

        fun validate():Boolean{
            return checkName() && checkEmail() && checkPassword() && checkConfirmPassword()
        }

        private fun checkName(): Boolean {
            if (signup_first_name_et.text.toString() == null) {
                signup_first_name_et.error = "Fill This Field"
                return false
            }
            if (signup_last_name_et.text.toString() == null) {
                signup_last_name_et.error = "Fill This Field"
                return false
            }
            return true
        }

        private fun checkEmail(): Boolean {
            val bool: Boolean = android.util.Patterns.EMAIL_ADDRESS.matcher(signup_email_et.text).matches()
            if (!bool) {//email is not matching with the standard Email template.
                signup_email_et.error = "Not a valid email address"
            }
            return bool
        }

        private fun checkPassword(): Boolean {
            if (signup_password_et.text.length >= 8)
                return true
            signup_password_et.error = "Not a valid password"
            return false
        }

        private fun checkConfirmPassword(): Boolean {
            if (signup_password_et.text.toString() != signup_confirm_password_et.text.toString()) {
                signup_confirm_password_et.error = "Passwords doesn't match"
            }
            return true
        }

        private fun checkPhone() {

        }
    }
}
