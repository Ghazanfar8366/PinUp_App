package com.example.net_a.pinup_app;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Net_A on 12/9/2015.
 */
public class PinUpWebViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//        return super.shouldOverrideUrlLoading(view, url);
        view.loadUrl(url);
        return true;
    }
}
