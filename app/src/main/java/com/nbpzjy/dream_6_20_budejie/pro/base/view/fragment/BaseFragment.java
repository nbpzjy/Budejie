package com.nbpzjy.dream_6_20_budejie.pro.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nbpzjy.dream_6_20_budejie.mvp.presenter.impl.MvpBasePresenter;
import com.nbpzjy.dream_6_20_budejie.mvp.view.impl.MvpBaseView;
import com.nbpzjy.dream_6_20_budejie.mvp.view.impl.MvpFragment;

/**
 * Created by zjygzc on 16/6/23.
 *
 * 抽象类，增加程序的可扩展性和可维护性
 * 架构的核心思想--利他之心
 *
 * 1.针对开发者之角度设计和实现功能，以便于将来的维护和框架替换等等
 * 2.站在公司角度设计和实现，一行代码的问题可能会影响整个项目的开发发布上线。目前多属于敏捷开发，核心就是版本的
 * 替代，升级，维护
 *      a.开发者--版本的迭代
 *      b.管理者--更加适合目前的敏捷开发方式的管理——用户的需求变更频繁，需要对程序进行升级变更。以前是瀑布开发
 *      模式，程序全部写完再发布。而当前的敏捷开发方式是一部分功能做好，就可以发布，后续的需要和功能做好再对程
 *      序进行升级替换
 * 3.站在用户的角度来设计和实现功能
 *
 */
public abstract class BaseFragment<P extends MvpBasePresenter,V extends MvpBaseView> extends MvpFragment<P,V> {
    //缓存布局，由于在切换的时候Fragment会被销毁
    private View contentView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (contentView == null){
            contentView = inflater.inflate(bindLayoutId(),container,false);
            initContenteView(contentView);

        }
        //判断Fragment对应的Activity是否存在这个视图

        ViewGroup parent = (ViewGroup) contentView.getParent();

        if (parent != null){
            //如果存在，则重写添加，这样的方式缓存视图
            parent.removeView(contentView);
        }
        return contentView;
    }
    public abstract int bindLayoutId();

    public abstract void initContenteView(View contentView);
}
