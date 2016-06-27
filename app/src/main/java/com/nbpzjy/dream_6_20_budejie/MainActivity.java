package com.nbpzjy.dream_6_20_budejie;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.nbpzjy.dream_6_20_budejie.R;
import com.nbpzjy.dream_6_20_budejie.pro.attention.view.AttentionFragment;
import com.nbpzjy.dream_6_20_budejie.pro.essence.view.EssenceFragment;
import com.nbpzjy.dream_6_20_budejie.pro.newpost.view.NewPostFragment;
import com.nbpzjy.dream_6_20_budejie.pro.profile.view.ProfileFragment;
import com.nbpzjy.dream_6_20_budejie.pro.publish.view.PublishFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TabHost.OnTabChangeListener{

    private List<MainTabItem> mainTabItemList;

    private FragmentTabHost fragmentTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTabHostRes();
        initFragmentTabHost();
    }

    //第一步:准备布局文件
    //第二步:准备资源文件
    //第三步:初始化资源
    private void initTabHostRes() {
        mainTabItemList = new ArrayList<MainTabItem>();
        //创建精华Tab
        mainTabItemList.add(new MainTabItem(
                R.mipmap.main_bottom_essence_normal,
                R.mipmap.main_bottom_essence_press,
                R.string.main_essence_text,
                EssenceFragment.class));
        //创建新帖Tab
        mainTabItemList.add(new MainTabItem(
                R.mipmap.main_bottom_newpost_normal,
                R.mipmap.main_bottom_newpost_press,
                R.string.main_newpost_text,
                NewPostFragment.class));
        //创建发布Tab
        mainTabItemList.add(new MainTabItem(
                R.mipmap.main_bottom_public_normal,
                R.mipmap.main_bottom_public_press,
                MainTabItem.DEFAULT_TITLE,
                PublishFragment.class));
        //创建关注Tab
        mainTabItemList.add(new MainTabItem(
                R.mipmap.main_bottom_attention_normal,
                R.mipmap.main_bottom_attention_press,
                R.string.main_attention_text,
                AttentionFragment.class));
        //创建我的Tab
        mainTabItemList.add(new MainTabItem(
                R.mipmap.main_bottom_mine_normal,
                R.mipmap.main_bottom_mine_press,
                R.string.main_mine_text,
                ProfileFragment.class));
    }

    //第四步:采用OO设计,定义Tab对象
    //第五步:初始化FragmentTabHost
    private void initFragmentTabHost() {
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //绑定TabHost到FragmentManager
        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        //去掉Tab之间的分割线
        fragmentTabHost.getTabWidget().setDividerDrawable(null);

        //遍历我们的Tab
        for (int i = 0; i < mainTabItemList.size(); i++) {
            MainTabItem mainTabItem = mainTabItemList.get(i);
            //创建一个Tab
            //newTabSpec:构造参数---传入Tab名字
            //setIndicator:指定Tab的样式
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(mainTabItem.getTitleString()).setIndicator(mainTabItem.getIndicator());
            //绑定Fragment
            //tabSpec参数:指定Tab
            //clss参数:指定tab对应的Fragment
            //args参数:给我们Fragment绑定参数
            fragmentTabHost.addTab(tabSpec,mainTabItem.getFragmentClass(),mainTabItem.getBundle());
            //给我们的FragmentTabHost设置背景
            fragmentTabHost.getTabWidget().getChildAt(i).setBackgroundColor(getResources().getColor(R.color.main_tab_bg));

            //给我们的Tab绑定监听
            fragmentTabHost.setOnTabChangedListener(this);

            if (i == 0){
                //默认选中第一个Tab
                mainTabItem.setChecked(true);
            }

        }
    }

    @Override
    public void onTabChanged(String tabId) {
        for (int i = 0; i < mainTabItemList.size(); i++) {
            MainTabItem mainTabItem = mainTabItemList.get(i);
            if (mainTabItem.getTitleString().equals(tabId)){
                mainTabItem.setChecked(true);
            }else {
                mainTabItem.setChecked(false);
            }
        }
    }


    //面向对象变成---MainTabItem代表每一个Tab
    class MainTabItem {

        //默认资源
        public static final int DEFAULT_TITLE = 0;

        //正常图片
        private int imageNormal;
        //选择图片
        private int imagePress;
        //tab的名字(资源ID)
        private int titleRes;
        //String类型的tab的名字
        private String titleString;
        //我们的Fragment
        private Class<? extends Fragment> fragmentClass;

        private View view;
        //图标
        private ImageView iv_tab;
        //显示tab名字的视图
        private TextView tv_tab;

        //创建Tab的构造方法
        public MainTabItem(int imageNormal,
                           int imagePress,
                           int titleRes,
                           Class<? extends Fragment> fragmentClass) {
            this.imageNormal = imageNormal;
            this.imagePress = imagePress;
            this.titleRes = titleRes;
            this.fragmentClass = fragmentClass;
        }

        public int getImageNormal() {
            return imageNormal;
        }

        public void setImageNormal(int imageNormal) {
            this.imageNormal = imageNormal;
        }

        public int getImagePress() {
            return imagePress;
        }

        public void setImagePress(int imagePress) {
            this.imagePress = imagePress;
        }

        public int getTitleRes() {
            return titleRes;
        }

        public void setTitleRes(int titleRes) {
            this.titleRes = titleRes;
        }

        public Bundle getBundle(){
            Bundle bundle = new Bundle();
            return bundle;
        }

        public String getTitleString() {
            if (this.titleRes == DEFAULT_TITLE) {
                titleString = "";
            } else {
                titleString = getResources().getString(titleRes);
            }
            return titleString;
        }

        public void setTitleString(String titleString) {
            this.titleString = titleString;
        }

        public Class<? extends Fragment> getFragmentClass() {
            return fragmentClass;
        }

        public void setFragmentClass(Class<? extends Fragment> fragmentClass) {
            this.fragmentClass = fragmentClass;
        }

        //该百年选中图标
        public void setChecked(boolean isChecked){
            if (isChecked){
                iv_tab.setImageDrawable(getResources().getDrawable(imagePress));
                tv_tab.setTextColor(getResources().getColor(R.color.main_tab_text_select));
            }else {
                iv_tab.setImageResource(imageNormal);
                tv_tab.setTextColor(getResources().getColor(R.color.main_tab_text_normal));
            }
        }


        public View getIndicator(){
            if (view == null){
                view = getLayoutInflater().inflate(R.layout.tab_indicator,null);
                iv_tab = (ImageView) view.findViewById(R.id.iv_tab);
                tv_tab = (TextView) view.findViewById(R.id.tv_tab);
                iv_tab.setImageResource(imagePress);
                tv_tab.setText(getTitleString());
            }
            return view;
        }

    }

}
