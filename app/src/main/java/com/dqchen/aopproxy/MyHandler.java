package com.dqchen.aopproxy;

import android.content.Context;
import android.content.Intent;

import com.dqchen.aopproxy.util.ShadPreferenceUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    private Object target;
    private Context context;

    public MyHandler(Object context, Context context1) {
        this.target = context;
        this.context = context1;
    }

    /**
     * 拦截object对象的所有方法
     * @param proxy 1
     * @param method  1
     * @param args 1
     * @return 1
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        if (ShadPreferenceUtil.getBooleanSp(ShadPreferenceUtil.IS_LOGIN,context)){
            result = method.invoke(target,args);
        }else {
            Intent intent = new Intent(context,LoginActivity.class);
            context.startActivity(intent);
        }
        return result;
    }
}
