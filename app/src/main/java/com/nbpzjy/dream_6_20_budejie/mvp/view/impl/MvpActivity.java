package com.nbpzjy.dream_6_20_budejie.mvp.view.impl;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.nbpzjy.dream_6_20_budejie.mvp.presenter.impl.MvpBasePresenter;
import com.nbpzjy.dream_6_20_budejie.mvp.view.MvpView;

/**
 * Created by zjygzc on 16/6/23.
 *
 * 定义UI层
 *
 * MVP可以进阶2次（升级）
 * 将V关联的P里
 */
public abstract class MvpActivity<P extends MvpBasePresenter> extends AppCompatActivity implements MvpView{

    //给P层绑定V

    private P presenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
        //绑定View
        if (this.presenter.attachView(this);)
    }

    //给子类实现
    public abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //解除绑定View
        if (this.presenter != null){
            this.presenter.dettachView();
            this.presenter = null;
        }
    }
}
