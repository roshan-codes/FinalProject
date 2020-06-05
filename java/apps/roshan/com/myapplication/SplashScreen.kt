package apps.roshan.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import apps.roshan.com.myapplication.pref.AppPreference
import org.jetbrains.anko.startActivity

class SplashScreen : AppCompatActivity() {
    private lateinit var pref: AppPreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        pref = AppPreference(this, "book")

        Handler().postDelayed({
            if (pref.isLogin())
                startActivity<MainActivity>()
            else
                startActivity<LoginActivity>()
            finish()
        }, 2500) }
}
