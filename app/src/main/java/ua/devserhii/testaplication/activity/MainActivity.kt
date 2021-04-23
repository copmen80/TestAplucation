package ua.devserhii.testaplication.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.facebook.applinks.AppLinkData
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.onesignal.OneSignal
import ua.devserhii.testaplication.Constants.ONESIGNAL_APP_ID
import ua.devserhii.testaplication.R
import ua.devserhii.testaplication.ShowingInterface
import ua.devserhii.testaplication.activity.fragments.StartScreenFragment
import ua.devserhii.testaplication.activity.fragments.WebFragment


class MainActivity : AppCompatActivity(), ShowingInterface {

    private lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onRetainNonConfigurationInstance()

        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)

        showStartScreen()

        AppLinkData.fetchDeferredAppLinkData(this) {}


    }


    override fun showStartScreen() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, StartScreenFragment())
            .commit()
    }

    override fun showWebView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, WebFragment())
            .commit()
    }
}
