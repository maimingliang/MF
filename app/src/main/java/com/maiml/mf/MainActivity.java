package com.maiml.mf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.maiml.mcode.LocalRouter;
import com.maiml.mcode.MApplication;
import com.maiml.mcode.MProvider;
import com.maiml.qqdemo.QQProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        QQProvider provider = (QQProvider) LocalRouter.getInstance(MyApplication.getMApplication()).getProvider("qqdemo");

        provider.findAction("qq").invoke(this,null);

    }
}
