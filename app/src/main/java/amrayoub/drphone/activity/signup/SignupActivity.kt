package amrayoub.drphone.activity.signup

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.mikhaellopez.circularimageview.CircularImageView
import amrayoub.drphone.DrPhoneApp
import amrayoub.drphone.R
import amrayoub.drphone.activity.main.MainActivity
import amrayoub.drphone.data.SharedPrefsDataManager
import java.io.IOException


class SignupActivity : AppCompatActivity(), SignupContract.View {

    override fun startProgress() {
        signUpProgressBar.visibility = View.VISIBLE
    }

    override fun stopProgress() {
        signUpProgressBar.visibility = View.GONE
    }

    private lateinit var mSignupPresenter: SignupContract.Presenter
    private val RESULT_LOAD_IMAGE = 1
    private lateinit var add_photo_civ: CircularImageView
    private lateinit var first_name_et: EditText
    private lateinit var last_name_et: EditText
    private lateinit var email_et: EditText
    private lateinit var password_et: EditText
    private lateinit var confirm_password_et: EditText
    private lateinit var phone_et: EditText
    private lateinit var signup_btn: ImageButton
    private lateinit var signUpProgressBar: ConstraintLayout
    private lateinit var dataManager: SharedPrefsDataManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        dataManager = (application as DrPhoneApp).getDataManager()
        setPresenter()
        setupUI()
        setupClickListeners()

    }

    //initializing UI components
    private fun setupUI() {
        add_photo_civ = findViewById(R.id.civ_signup_photo_add)
        first_name_et = findViewById(R.id.et_signup_first_username)
        last_name_et = findViewById(R.id.et_signup_last_username)
        email_et = findViewById(R.id.et_signup_email)
        password_et = findViewById(R.id.et_signup_password)
        confirm_password_et = findViewById(R.id.et_signup_confirm_password)
        phone_et = findViewById(R.id.et_signup_phone)
        signup_btn = findViewById(R.id.btn_signup_signupbutton)
        signUpProgressBar = findViewById(R.id.pb_signup_determinateBar)
    }

    // handling buttons actions
    private fun setupClickListeners() {

        signup_btn.setOnClickListener {
            signUpBtnPressed()
        }
        add_photo_civ.setOnClickListener {
            importUserImage()
        }
    }

    private fun signUpBtnPressed() {
        startProgress()
        //register new user
        mSignupPresenter.registerUser(
            first_name_et, last_name_et, email_et,
            password_et, confirm_password_et, phone_et
        )
    }

    private fun importUserImage() {
        val intent = Intent(
            Intent.ACTION_PICK,
            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )

        startActivityForResult(intent, RESULT_LOAD_IMAGE)
    }

    //response of adding an image
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //check if returns the same code value it sent
        if (requestCode == RESULT_LOAD_IMAGE) {
            if (data != null) {
                val contentURI = data.data
                try {
                    val bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, contentURI)
                    add_photo_civ.setImageBitmap(bitmap)
                } catch (e: IOException) {
                    e.printStackTrace()
                    Toast.makeText(this, "Failed!", Toast.LENGTH_SHORT).show()
                }

            }

        }
    }

    private fun setPresenter() {
        mSignupPresenter = SignupPresenter(dataManager)
        mSignupPresenter.attach(this)
    }

    override fun userSuccessfullyRegistered() {
        stopProgress()
        Toast.makeText(this, "User Successfully Registered", Toast.LENGTH_LONG).show()
        startActivity()
    }

    private fun startActivity() {

        val intent = Intent(this, MainActivity::class.java)
        //clear activities stack
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent) // Launch the MainActivity
        finish()         // Close down the SignUpActivity
    }
}
