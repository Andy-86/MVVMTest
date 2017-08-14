package com.example.andy.mvvmtest;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.andy.mvvmtest.databinding.ActivityMainBinding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    public volatile int a=1;
    private static final String TAG="MainActivity";
    ActivityMainBinding binding;
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        bean bean1=new bean(new ObservableField<String>("JJJJJJ"));
        binding.setBean(bean1);

    }


}
