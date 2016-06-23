package com.nbpzjy.dream_6_20_budejie.pro.base.presenter;

import android.content.Context;

import com.nbpzjy.dream_6_20_budejie.mvp.model.MvpModel;
import com.nbpzjy.dream_6_20_budejie.mvp.presenter.impl.MvpBasePresenter;
import com.nbpzjy.dream_6_20_budejie.mvp.view.MvpView;
import com.nbpzjy.dream_6_20_budejie.pro.base.model.BaseModel;

/**
 * Created by zjygzc on 16/6/23.
 */
public abstract class BasePresenter<M extends BaseModel,V extends MvpView> extends MvpBasePresenter<V>{

    private Context context;
    private M model;

    public BasePresenter(Context context){
        this.context = context;
    }

    public Context getContext(){
        return context;
    }

    //子类来实现
    public M getModel(){
        if (this.model == null){
            this.model = bindModel();
        }
        return this.model;
    }

    public abstract M bindModel();
}
