package com.example.app32.app4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Adding now!", Toast.LENGTH_LONG).show();
                EditText num_text_1 = (EditText) findViewById(R.id.editText2);
                EditText  num_text_2 = (EditText) findViewById(R.id.editText3);
                TextView result = (TextView) findViewById(R.id.editText4);

                int mun_1 = Integer.parseInt(num_text_1.getText().toString());
                int mun_2 = Integer.parseInt(num_text_2.getText().toString());
                int reuslt = mun_1 + mun_2;
                result.setText("Result is:  " + reuslt);

                Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(myIntent);

               // setupViews();
            }

        });
    }


    private void setupViews() {
        final WebView webView = new WebView(this);
        setContentView(webView);

        webView.getSettings().setJavaScriptEnabled(true);



        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                webView.loadUrl("javascript: (function() { "
                        + "var script=document.createElement('script');"
                        + "script.type='text/javascript';script.src='file:///res//js//my.js';"
                        + "document.getElementsByTagName('head').item(0).appendChild(script);"
                        + "})()");
                webView.loadUrl("javascript: printAll()");
            }
        });

    }

}
