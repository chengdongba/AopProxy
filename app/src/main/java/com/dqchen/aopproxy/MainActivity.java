package com.dqchen.aopproxy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Proxy;

public class MainActivity extends AppCompatActivity implements ILogin{

    private ILogin proxyLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        proxyLogin = (ILogin) Proxy.newProxyInstance(
                this.getClassLoader(), //类加载器
                new Class[]{ILogin.class}, //需要代理的类
                new MyHandler(this, this)//代理InvocationHandler
        );
    }

    /**
     * 我的淘宝
     * @param view
     */
    public void me(View view) {
        proxyLogin.toLogin();
    }

    /**
     * 购买
     * @param view
     */
    public void play(View view) {
        proxyLogin.toLogin();
    }

    /**
     * 查看
     * @param view
     */
    public void look(View view) {
    }

    @Override
    public void toLogin() {
        Intent intent = new Intent(
                MainActivity.this, MenberActivity.class);
        startActivity(intent);
    }
}
