package com.lzy.webparser;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lzy.webparser.databinding.ActivityMainBinding;
import com.lzy.webparser.model.beans.MainModel;
import com.lzy.webparser.viewmodel.MainViewModel;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;
    MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel = new MainViewModel(new MainModel("https://m.taobao.com",""),this);
        mainViewModel.with(this);//自动绑定周期
        activityMainBinding.setViewModel(mainViewModel);
    }

}
