package com.tf.hybridvsnativeui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by kamran on 7/7/16.
 */

public class FragmentIonic extends FragmentWeb {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((WebView) view.findViewById(R.id.web_view))
                .loadUrl("file:///android_asset/ionic-material/index.html");
    }
}
