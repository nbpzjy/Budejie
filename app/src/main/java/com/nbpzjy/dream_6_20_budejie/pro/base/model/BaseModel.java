package com.nbpzjy.dream_6_20_budejie.pro.base.model;

import android.content.Context;

import com.nbpzjy.dream_6_20_budejie.mvp.model.MvpModel;
import com.nbpzjy.dream_6_20_budejie.mvp.view.MvpView;

/**
 * Created by zjygzc on 16/6/23.
 */
public class BaseModel implements MvpModel{

    private Context context;
    public BaseModel(Context context){

        this.context = context;
    }

    public Context getContext(){

        return context;
    }

}
