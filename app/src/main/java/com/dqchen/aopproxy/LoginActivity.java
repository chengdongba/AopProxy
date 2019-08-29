package com.dqchen.aopproxy;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dqchen.aopproxy.util.ShadPreferenceUtil;

import static com.dqchen.aopproxy.util.ShadPreferenceUtil.IS_LOGIN;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view) {
        ShadPreferenceUtil.setBooleanSp(IS_LOGIN,true,this);
        finish();
    }
}
