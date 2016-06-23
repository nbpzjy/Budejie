package com.nbpzjy.dream_6_20_budejie.mvp.view.impl;

import android.app.Fragment;
import android.os.Bundle;

import com.nbpzjy.dream_6_20_budejie.mvp.presenter.impl.MvpBasePresenter;
import com.nbpzjy.dream_6_20_budejie.mvp.view.MvpView;

/**
 * Created by zjygzc on 16/6/23.
 *
 * 与Activity一样属于UI
 * 就是UI
 *
 * 在Fragment里将P和V关联，便于之后的调用
 */
public class MvpFragment<P extends MvpBasePresenter,V extends MvpView> extends Fragment{
    //<泛型定义>
    private P presenter;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.presenter = createPresenter();
        if (this.presenter != null){
            this.presenter.dettachView(createView());
        }
    }

    public abstract P createPresenter();

    public abstract V createView();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.presenter != null){
            this.presenter.dettachView();
            this.presenter = null;
        }
    }
}
