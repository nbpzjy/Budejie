package com.nbpzjy.dream_6_20_budejie.mvp.presenter;

import com.nbpzjy.dream_6_20_budejie.mvp.view.MvpView;

/**
 * Created by zjygzc on 16/6/23.
 *
 * Presenter层，对V层和M层进行管理
 */
public interface MvpPresenter<V extends MvpView> {
    //绑定视图
    public void attachView(V view);
    //解除绑定
    public void dettachView();
}
