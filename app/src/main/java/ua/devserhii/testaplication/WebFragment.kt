package ua.devserhii.testaplication

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.web_fragment.*

/**
 * Created by Vladislav Boiko on 20.04.2021.
 */
class WebFragment : Fragment(R.layout.web_fragment) {
    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView = wv_fragment
        // включаем поддержку JavaScript
        webView.settings.javaScriptEnabled = true
        // указываем страницу загрузки
        webView.loadUrl("http://developer.alexanderklimov.ru/android")
    }

    private class MyWebViewClient : WebViewClient() {
        @TargetApi(Build.VERSION_CODES.N)
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            view.loadUrl(request.url.toString())
            return true
        }
    }
}