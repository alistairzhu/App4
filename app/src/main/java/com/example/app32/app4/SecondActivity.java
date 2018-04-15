package com.example.app32.app4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SecondActivity extends AppCompatActivity {

    //String webUrl = "file:///android_asset/my.html";
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        this.webView =  findViewById(R.id.webView);

        webView.loadUrl("http://10.0.2.2:8080/");
       // this.webView.loadUrl(webUrl);

        this.webView.getSettings().setJavaScriptEnabled(true);
        this.webView.setWebViewClient(new WebViewClient());
    }

    @Override
    public  void  onBackPressed(){
        if (webView.canGoBack()){
            webView.goBack();
        }
        else {
            finish();
        }
    }
}
