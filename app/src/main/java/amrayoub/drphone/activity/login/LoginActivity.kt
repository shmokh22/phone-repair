package amrayoub.drphone.activity.login

import android.content.Intent
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import amrayoub.drphone.DrPhoneApp
import amrayoub.drphone.R
import amrayoub.drphone.activity.main.MainActivity
import amrayoub.drphone.activity.signup.SignupActivity
import amrayoub.drphone.activity.splash.SplashPresenter
import amrayoub.drphone.dialog.ForgotPasswordDialogFagment

class LoginActivity : AppCompatActivity(), LoginContract.View {
    //show Error msg, if login fail
    override fun loginError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private lateinit var loginProgressBar: ConstraintLayout
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var forgotPasswordTextView: TextView
    private lateinit var signUpTextView: TextView
    private lateinit var loginButton: ImageButton
    private lateinit var mLoginPresenter: LoginContract.Presenter

    //show loading bar
    override fun startProgress() {
        loginProgressBar.visibility = View.VISIBLE
    }

    //hide loading bar
    override fun stopProgress() {
        loginProgressBar.visibility = View.GONE
    }


    private fun setPresenter() {
        mLoginPresenter = LoginPresenter()
        mLoginPresenter.attach(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setPresenter()
        setupUI()
        setupClickListeners()
    }

    //initialize UI components
    private fun setupUI() {
        loginProgressBar = findViewById(R.id.pb_login_determinateBar)
        emailEditText = findViewById(R.id.et_login_email)
        passwordEditText = findViewById(R.id.et_login_password)
        forgotPasswordTextView = findViewById(R.id.tv_login_layout_forgotPassword)
        signUpTextView = findViewById(R.id.tv_login_layout_signUp)
        loginButton = findViewById(R.id.btn_login_loginbutton)
    }

    //handle button clicks
    private fun setupClickListeners() {
        // your code to perform when the user clicks on the button
        signUpTextView.setOnClickListener {
            // your code to perform when the user clicks on the button
            onSignupButtonClick()
        }
        forgotPasswordTextView.setOnClickListener {
            // your code to perform when the user clicks on the button
            onForgotButtonClick()
        }
        loginButton.setOnClickListener {
            onLoginButtonClick()
        }
    }

    override fun onSignupButtonClick() {
        val intent = Intent(this, SignupActivity::class.java)
        // start your next activity
        startActivity(intent)
    }


    override fun onForgotButtonClick() {
        val newFragment = ForgotPasswordDialogFagment()
        val fm = this@LoginActivity.supportFragmentManager
        newFragment.show(fm, "Forgot_Password_Dialog")
    }

    override fun onLoginButtonClick() {
        mLoginPresenter.checkInput(emailEditText, passwordEditText)
    }

    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        // start your next activity
        startActivity(intent)
        finish()
    }

}
