package ua.devserhii.testaplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ShowingInterface {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showStartScreen()
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
