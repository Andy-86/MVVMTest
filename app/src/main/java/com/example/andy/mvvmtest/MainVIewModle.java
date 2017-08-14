package com.example.andy.mvvmtest;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by andy on 2017/8/9.
 */

public class MainVIewModle implements ViewModle {
    private static final String TAG = "MainVIewModle";
    public ObservableField<String> name;
    public ObservableField<String> password;
    public ObservableInt nameVisiable;
    public ObservableInt pswVisiable;
    public ObservableInt buttonVisiable;
    public ObservableBoolean buttonEnable;
    public ObservableInt recycleVisiable;
    private Context context;
    private DataListner listner;

    public MainVIewModle(Context context, DataListner listner) {
        this.context = context;
        this.listner = listner;
        nameVisiable = new ObservableInt(View.VISIBLE);
        pswVisiable = new ObservableInt(View.VISIBLE);
        buttonVisiable = new ObservableInt(View.VISIBLE);
        recycleVisiable = new ObservableInt(View.GONE);
        password = new ObservableField<>("");
        name = new ObservableField<>("");
        buttonEnable = new ObservableBoolean(false);

    }

    @Override
    public void destroy() {
        context = null;
        listner = null;
    }

    interface DataListner {
        public void OndateChage(List<ListBean> list);
    }

    public TextWatcher getnameTextWatcher() {
        return new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + " " + s.length() + password.get().length());
                if (s.length() > 4 && password.get().length() > 7)
                    buttonEnable.set(true);
                else
                    buttonEnable.set(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                name.set(s.toString());
            }
        };
    }

    public TextWatcher getpswTextWatcher() {
        return new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + s.length() + " " + name.get().length());
                if (s.length() > 7 && name.get().length() > 4)
                    buttonEnable.set(true);
                else
                    buttonEnable.set(false);
            }

            @Override
            public void afterTextChanged(Editable s) {
                password.set(s.toString());
            }
        };
    }

    public void OnclickChange(View view) {

        Log.d(TAG, "OnclickChange: " + view.getId());
        Toast.makeText(view.getContext(), "hhhhh", Toast.LENGTH_SHORT).show();
        login();
    }

    public void login() {
        User user = new User();
        user.setName(name.get());
        user.setPassword(password.get());
        recycleVisiable.set(View.VISIBLE);
        nameVisiable.set(View.GONE);
        pswVisiable.set(View.GONE);
        buttonVisiable.set(View.GONE);
//        LoginService service = LoginService.Factory.create();
//        service.dologin(user)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .subscribe(new Observer<List<ListBean>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<ListBean> value) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        List<ListBean> list=new ArrayList<ListBean>();
//                        for(int i=0;i<10;i++)
//                        {
//                            ListBean bean=new ListBean();
//                            bean.setTitle("On The NO"+i);
//                            bean.setSummary("This is No"+i+"News");
//                            bean.setWatchers(10+i);
//                            bean.setForks(5+i);
//                            bean.setForks(3+i);
//                            list.add(bean);
//                        }
//                        listner.OndateChage(list);
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
        List<ListBean> list=new ArrayList<ListBean>();
                        for(int i=0;i<10;i++)
                        {
                            ListBean bean=new ListBean();
                            bean.setTitle("On The NO"+i);
                            bean.setSummary("This is No"+i+"News");
                            bean.setWatchers(10+i);
                            bean.setForks(5+i);
                            bean.setForks(3+i);
                            list.add(bean);
                        }
                        listner.OndateChage(list);

    }
}
