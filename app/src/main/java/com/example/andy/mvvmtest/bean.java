package com.example.andy.mvvmtest;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

/**
 * Created by andy on 2017/8/9.
 */

public class bean {
    private static final String TAG="bean";
    public ObservableField<String> name;

    public bean( ObservableField<String>  name) {
        this.name = name;
    }

    public  ObservableField<String>  getName() {
        return name;
    }

    public void setName( ObservableField<String>  name) {
        this.name = name;
    }

    public void OnclickChange(View view){

        Log.d(TAG, "OnclickChange: "+view.getId());
//        name.set("MMMMMMMMM");
    }
    public TextWatcher  getTextWatcher()
    {
        return new TextWatcher(){

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name.set(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
    }
}
