package com.dqchen.aopproxy.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class ShadPreferenceUtil {
    public static final String IS_LOGIN = "isLogin";

    public static boolean getBooleanSp(String key, Context context){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key,false);
    }

    public static void clear(String key ,Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(key);
        edit.commit();
    }

    public static void setBooleanSp(String key,boolean value,Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean(key,value);
        edit.commit();
    }

}
