package com.gc.viewpager_fragmentpageradapter_tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private LinearLayout id_tab_address;
    private LinearLayout id_tab_frd;
    private LinearLayout id_tab_settings;
    private LinearLayout id_tab_weixin;

    private ImageButton id_tab_weixin_img;
    private ImageButton id_tab_frd_img;
    private ImageButton id_tab_address_img;
    private ImageButton id_tab_settings_img;

    private ViewPager id_viewpager;
    private List<Fragment> mFragments;
    private FragmentPagerAdapter fragmentPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvents();

        setSelect(0);

    }

    private void initEvents() {

        id_tab_weixin.setOnClickListener(this);
        id_tab_frd.setOnClickListener(this);
        id_tab_address.setOnClickListener(this);
        id_tab_settings.setOnClickListener(this);

    }

    private void initView() {

        id_viewpager = (ViewPager) findViewById(R.id.id_viewpager);

        id_tab_address = (LinearLayout) findViewById(R.id.id_tab_address);
        id_tab_frd = (LinearLayout) findViewById(R.id.id_tab_frd);
        id_tab_settings = (LinearLayout) findViewById(R.id.id_tab_settings);
        id_tab_weixin = (LinearLayout) findViewById(R.id.id_tab_weixin);

        id_tab_weixin_img = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        id_tab_frd_img = (ImageButton) findViewById(R.id.id_tab_frd_img);
        id_tab_address_img = (ImageButton) findViewById(R.id.id_tab_address_img);
        id_tab_settings_img = (ImageButton) findViewById(R.id.id_tab_settings_img);

        mFragments = new ArrayList<Fragment>();
        Fragment mTab01 = new WeixinFragment();
        Fragment mTab02 = new FrdFragment();
        Fragment mTab03 = new AddressFragment();
        Fragment mTab04 = new SettingFragment();
        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);

        fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()){

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }
        };

        id_viewpager.setAdapter(fragmentPagerAdapter);

        id_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setSelect(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        resetImgs();

        switch (v.getId()) {
            case R.id.id_tab_weixin:
                setSelect(0);
                break;
            case R.id.id_tab_frd:
                setSelect(1);
                break;
            case R.id.id_tab_address:
                setSelect(2);
                break;
            case R.id.id_tab_settings:
                setSelect(3);
                break;

        }
    }

    private void setSelect(int i)
    {
        setTab(i);
        id_viewpager.setCurrentItem(i);
    }

    private void setTab(int i)
    {
        resetImgs();
        // 设置图片为亮色
        // 切换内容区域
        switch (i)
        {
            case 0:
                id_tab_weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                id_tab_frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                id_tab_address_img.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                id_tab_settings_img.setImageResource(R.drawable.tab_settings_pressed);
                break;
        }
    }


    /**
     * 将所有的图片切换为未选中的
     */
    private void resetImgs() {
        id_tab_weixin_img.setImageResource(R.drawable.tab_weixin_normal);
        id_tab_frd_img.setImageResource(R.drawable.tab_find_frd_normal);
        id_tab_address_img.setImageResource(R.drawable.tab_address_normal);
        id_tab_settings_img.setImageResource(R.drawable.tab_settings_normal);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        id_viewpager.clearOnPageChangeListeners();
    }
}
