package com.nbpzjy.dream_6_20_budejie;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by zjygzc on 16/6/21.
 */
public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initView();
    }

    private void initView(){
        //欢迎页：给背景图片加载动画--渐变
        //找到需要添加动画的目标视图
        ImageView imv_splash=(ImageView)findViewById(R.id.imv_splash);
        //创建动画
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imv_splash,"alpha",0.2f,1.0f,0.1f);
        //ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imv_splash,"translation",curTranslationX,-500,curTranslation,0.2f);


        //平移：translationX 或者translationY 或者translationZ
        //渐变：alpha(0.2f-->1.0f
        //缩放：scaleX或者scaleY
        //旋转：rotationX或者rotationY

        objectAnimator.setDuration(8000);

        //8000代表毫秒，iOS用秒

        objectAnimator.start();

        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            }
        });

    }
}
