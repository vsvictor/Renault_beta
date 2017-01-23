package com.rev.revdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.rev.revsdk.RevActivity;

public class MainActivity extends RevActivity {
    private WebView vvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vvMain = (WebView) findViewById(R.id.vvMain);
        vvMain.loadUrl("https://google.com");
    }

}
