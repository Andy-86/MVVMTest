package com.example.andy.mvvmtest;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.andy.mvvmtest.databinding.ActivityMainBinding;

import java.util.List;


public class MainActivity extends AppCompatActivity implements MainVIewModle.DataListner{
    public volatile int a=1;
    private static final String TAG="MainActivity";
    ActivityMainBinding binding;
    Handler h;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        bean bean1=new bean(new ObservableField<String>("JJJJJJ"));
        binding.setBean(new MainVIewModle(this,this));
        myAdapter=new MyAdapter();
        binding.recycleview.setAdapter(myAdapter);
        binding.recycleview.setLayoutManager(new LinearLayoutManager(this));
    }


    @Override
    public void OndateChage(List<ListBean> list) {
        myAdapter.setList(list);
        myAdapter.notifyDataSetChanged();
    }
}
