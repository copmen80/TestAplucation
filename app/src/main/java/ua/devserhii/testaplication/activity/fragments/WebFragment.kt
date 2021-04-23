package ua.devserhii.testaplication.activity.fragments

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import kotlinx.android.synthetic.main.web_fragment.*
import ua.devserhii.testaplication.R


class WebFragment : Fragment(R.layout.web_fragment) {
    private lateinit var webView: WebView
    private lateinit var remoteConfig: FirebaseRemoteConfig
    private var url: String = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = wv_fragment
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = MyWebViewClient()
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)

        initRemoteConfig()
    }

    private fun initRemoteConfig() {
        remoteConfig = FirebaseRemoteConfig.getInstance()
        remoteConfig.setConfigSettingsAsync(FirebaseRemoteConfigSettings.Builder().build())

        val defaultData = hashMapOf<String, Any>()
        defaultData["webViewURL"] = "https://pin-up.games/"

        remoteConfig.setDefaultsAsync(defaultData)
        remoteConfig.activate()
        remoteConfig.fetch()
            .addOnSuccessListener {
                url = remoteConfig.getString("urlForWebView")

                if (url.isNotEmpty())
                    webView.loadUrl(url)
                else
                    webView.loadUrl("https://pin-up.games/")
            }
    }

    private class MyWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }
    }
}

