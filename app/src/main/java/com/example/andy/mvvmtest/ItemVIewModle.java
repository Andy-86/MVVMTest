package com.example.andy.mvvmtest;

import android.content.Context;
import android.databinding.BaseObservable;

/**
 * Created by andy on 2017/8/13.
 */

public class ItemVIewModle extends BaseObservable implements ViewModle {
    private Context context;
    private ListBean bean;
    public ItemVIewModle(Context context, ListBean repository) {
        this.context=context;
        this.bean=repository;
    }

    @Override
    public void destroy() {

    }
    public void setListBean(ListBean bean)
    {

    }
    public String getTitle()
    {
        if(bean!=null)
            return bean.getTitle();
        else
            return "";
    }
    public String getSummary()
    {
        if(bean!=null)
            return bean.getSummary();
        else
            return "";
    }
    public String getwatchers()
    {
        if(bean!=null)
            return bean.getWatchers()+"";
        else
            return "";
    }
    public String getstars()
    {
        if(bean!=null)
            return bean.getStars()+"";
        else
            return "";
    }
    public String getforks()
    {
        if(bean!=null)
            return bean.getForks()+"";
        else
            return "";
    }
}
