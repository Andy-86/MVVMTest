package com.example.andy.mvvmtest;

import android.content.Context;

/**
 * Created by andy on 2017/8/9.
 */

public class MainVIewModle implements ViewModle {
    private Context context;
    private DataListner listner;

    public MainVIewModle(Context context, DataListner listner) {
        this.context = context;
        this.listner = listner;
    }

    @Override
    public void destroy() {
        context = null;
        listner = null;
    }
    interface DataListner
    {
        public void  OndateChage();
    }
}
