package com.nbpzjy.dream_6_20_budejie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nbpzjy.dream_6_20_budejie.views.CircleIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by zjygzc on 16/6/22.
 */
public class GuideActivity extends Activity {

    private List<Integer> imageList;
    //存放资源
    private List<ImageView> imageViewList;
    //存放视图集合
    private ViewPager vp_guide;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initImageList();
        initImageViewList();
        initView();



    }

    private void initImageList(){
        imageList =new ArrayList<Integer>();
        imageList.add(R.mipmap.surprise_background_default);
        imageList.add(R.mipmap.surprise_background_grass);
        imageList.add(R.mipmap.surprise_background_roof);
        imageList.add(R.mipmap.surprise_background_window);
    }
    private void initImageViewList(){
        imageViewList=new ArrayList<ImageView>();
        for (int i=0;i<imageList.size();i++){
            ImageView imageView=new ImageView(this);
            imageViewList.add(imageView);
        }
    }


    private void initView(){
        /**
         * 1准备资源，2加载资源，3初始化控件，4绑定资源
         */
        vp_guide=(ViewPager)findViewById(R.id.vp_guide);
        //定义adapter==绑定数据

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        //给页码的控件绑定分页


        GuideAdapter guideAdapter=new GuideAdapter();
        vp_guide.setAdapter(guideAdapter);

        indicator.setViewPager(vp_guide);

        //开始调用tv_gomain，用TextView定义一个tv_main取得布局文件中的参数,用final固定tv_main的值不变
        final TextView tv_main = (TextView)findViewById(R.id.tv_main);
        //开始编写跳转代码
        //在这里设置监听点击，点击时从GuideActivity启动MainActivity
        tv_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this,MainActivity.class));

            }
        });

        //实现跳转前，对vp_guide设置监听
        //主要是在检测welcome页是否为最后一页
        //如果是最后一页，则显示进入主页几个字，否则不显示
        vp_guide.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //判断当前叶的position是不是整个guide页中的imageviewlist中的最后一个页面
                // 方法就是整个imageviewlist-1，从第0个开始
                if (position < imageViewList.size()-1){
                    //如果不是最后一页，那么不显示tv_gomain
                    tv_main.setVisibility(View.GONE);
                    //如果是最后一页，那么显示tv_main用以跳转至mainactivity
                }else {tv_main.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
    class GuideAdapter extends PagerAdapter{


        //配置适配器大小，数据管理器，数据丢到这里，由这里去映射处理
        @Override
        public int getCount() {
            return imageViewList.size();
        }

        //判断是不是View（即我们指定的对象，可以是view，fragment等等）

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        //不在屏幕中显示的时候，销毁之
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViewList.get(position));

        }

        //获取某一个视图的下标，并返回
        @Override
        public int getItemPosition(Object object) {
            return super.getItemPosition(object);
        }

        //创建视图
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            //开始创建视图，imageView从imageViewList中提取
            ImageView imageView=imageViewList.get(position);

            //绑定资源
            imageView.setImageResource(imageList.get(position));
            //指定视图的宽高
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            container.addView(imageView,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            return imageView;
        }
    }


}
