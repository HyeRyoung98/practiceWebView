package com.example.practicewebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = "https://jerryjerryjerry.tistory.com/72";
        init();
        setURL(url);

    }

    private void init() {
        webView = findViewById(R.id.webView);
        //자바스크립트 사용이 가능하도록 설정. 디폴트는 false
        webView.getSettings().setJavaScriptEnabled(true);
    }

    //웹뷰 실행
    private void setURL(String url) {
        webView.loadUrl(url);
        //크롬에서 실행
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClientClass());
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if((keyCode==KeyEvent.KEYCODE_BACK)&&webView.canGoBack()){
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
