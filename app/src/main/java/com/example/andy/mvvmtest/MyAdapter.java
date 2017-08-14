package com.example.andy.mvvmtest;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.andy.mvvmtest.databinding.RecycleviewItemBinding;

import java.util.Collections;
import java.util.List;

/**
 * Created by andy on 2017/8/13.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<ListBean> mylist;
    public MyAdapter()
    {
        mylist= Collections.emptyList();
    }
    public void MyAdapter(List<ListBean> list)
    {
        this.mylist=list;
    }
    public void setList(List<ListBean> list)
    {
        this.mylist=list;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      RecycleviewItemBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.recycleview_item,parent,false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindRepository(mylist.get(position));
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        final RecycleviewItemBinding binding;

        public MyViewHolder(RecycleviewItemBinding binding) {
            super(binding.cardView);
            this.binding = binding;
        }
        void bindRepository(ListBean repository) {
            if (binding.getViewModel() == null) {
                binding.setViewModel(new ItemVIewModle(itemView.getContext(), repository));
            } else {
                binding.getViewModel().setListBean(repository);
            }
        }
    }

}
