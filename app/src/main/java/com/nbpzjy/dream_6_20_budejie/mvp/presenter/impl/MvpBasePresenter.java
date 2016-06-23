package com.nbpzjy.dream_6_20_budejie.mvp.presenter.impl;

import com.nbpzjy.dream_6_20_budejie.mvp.presenter.MvpPresenter;
import com.nbpzjy.dream_6_20_budejie.mvp.view.MvpView;

/**
 * Created by zjygzc on 16/6/23.
 */
public abstract class MvpBasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V view;

    @Override
    public void attachView(V view) {

        this.view = view;

    }

    @Override
    public void dettachView() {

        this.view = null;

    }
}
