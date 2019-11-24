package amrayoub.drphone.activity.splash

import amrayoub.drphone.DrPhoneApp
import amrayoub.drphone.R
import amrayoub.drphone.activity.login.LoginActivity
import amrayoub.drphone.activity.main.MainActivity
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log


class SplashActivity : Activity(), SplashContract.View {

    //MVP, presenter model for splash view
    private lateinit var mSplashPresenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Splash Activity", "OnCreate")
        setContentView(R.layout.activity_splash)
        //get data manager that holds the shared prefs object
        //initialize/set presenter
        setPresenter()
        //main thread delayed 1 second, to wait the UI of splash view to be rendered
        Handler().postDelayed({
            mSplashPresenter.decideNextActivity()
        }, 1000)
    }
    private fun setPresenter() {
        val dataManger = (application as DrPhoneApp).getDataManager()
        mSplashPresenter = SplashPresenter(dataManger)
        mSplashPresenter.attach(this)
    }
    override fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startNewActivity(intent)
    }

    override fun openLoginActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startNewActivity(intent)

    }

    //method for starting new activity
    private fun startNewActivity(intent: Intent) {
        startActivity(intent)
        //destroy current activity, to avoid splash screen when pressing back
        finish()
    }

    //some callbacks for debugging, the activity lifecycle
    override fun onStart() {
        super.onStart()
        Log.i("Splash Activity", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Splash Activity", "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Splash Activity", "OnPause")

    }

    override fun onStop() {
        super.onStop()
        Log.i("Splash Activity", "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Splash Activity", "OnCreate")
    }

}
