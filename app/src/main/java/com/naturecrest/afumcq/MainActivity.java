package com.naturecrest.afumcq;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/** Offline AFU M.Sc. Forestry MCQ trainer: shows the bundled HTML app in a WebView. */
public class MainActivity extends Activity {
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setStatusBarColor(0xFF17472E);
        }
        web = new WebView(this);
        web.setBackgroundColor(0xFFF6F8F4);
        WebSettings s = web.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true); // keeps progress, mistakes and bookmarks
        s.setTextZoom(100);
        web.setWebViewClient(new WebViewClient());
        web.loadDataWithBaseURL("https://afu-mcq.local/", readAsset("index.html"),
                "text/html", "UTF-8", null);
        setContentView(web);
    }

    private String readAsset(String name) {
        try (InputStream in = getAssets().open(name)) {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[65536];
            int n;
            while ((n = in.read(buf)) > 0) out.write(buf, 0, n);
            return new String(out.toByteArray(), "UTF-8");
        } catch (Exception e) {
            return "<p>Could not load the question bank.</p>";
        }
    }

    @Override
    public void onBackPressed() {
        // The page decides: close dialogs, confirm leaving a mock, go home, or exit.
        web.evaluateJavascript("window.__back ? window.__back() : 'exit'", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String v) {
                if (v != null && v.contains("exit")) finish();
            }
        });
    }
}
