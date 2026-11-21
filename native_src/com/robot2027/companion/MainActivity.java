package com.robot2027.companion;

import android.os.Bundle;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        registerPlugin(RobotNativePlugin.class);
        super.onCreate(savedInstanceState);

        if (this.bridge != null && this.bridge.getWebView() != null) {
            WebView wv = this.bridge.getWebView();
            wv.getSettings().setMediaPlaybackRequiresUserGesture(false);
            wv.setWebChromeClient(new WebChromeClient() {
                @Override
                public void onPermissionRequest(final PermissionRequest request) {
                    runOnUiThread(() -> request.grant(request.getResources()));
                }
            });
            wv.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                    String url = request.getUrl().toString();
                    if (url.startsWith("intent://") || url.startsWith("market://")) {
                        return true; // Chan thoat ra app ngoai
                    }
                    return false;
                }
            });
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        RobotNativePlugin.reapplyKioskIfLocked(this);
    }

    @Override
    public void onBackPressed() {
        // Khoa nut Back vat ly khi o che do Khuon mat Robot vinh vien
        if (!RobotNativePlugin.sKioskLocked) {
            super.onBackPressed();
        }
    }
}
