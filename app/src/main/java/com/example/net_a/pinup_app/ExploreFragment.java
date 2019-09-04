package com.example.net_a.pinup_app;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {


    public ExploreFragment() {
        // Required empty public constructor
    }

    View view;
    String url;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_explore, container, false);
        WebView mywebview= (WebView) view.findViewById(R.id.webview);
        WebSettings webSettings=mywebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        //mywebview.loadUrl("http://test.pinupcampaigns.net/m_index");
             url="http://test.pinupcampaigns.net/m_index";

        mywebview.setWebViewClient(new PinUpWebViewClient());
        mywebview.loadUrl(url);
        return view;
    }


}
