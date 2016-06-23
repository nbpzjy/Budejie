package com.nbpzjy.dream_6_20_budejie.mvp.view.impl;

import com.nbpzjy.dream_6_20_budejie.mvp.view.MvpView;

/**
 * Created by zjygzc on 16/6/23.
 *
 * 接口，专门用来加载数据，回调监听
 */
public interface MvpLceView<M> extends MvpView{
    //显示正在加载--Loading
    public void showLoading(boolean isPullTorefresh);

    //显示ContentView
    public void showContent();

    //显示异常
    public void showError(Exception e, boolean isPullTorefresh);

    //绑定UI数据
    public void showData(M data);
}
