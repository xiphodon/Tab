package com.gc.tab;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

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
    private ArrayList<View> viewList;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvents();
    }

    private void initEvents() {

        id_tab_weixin.setOnClickListener(this);
        id_tab_frd.setOnClickListener(this);
        id_tab_address.setOnClickListener(this);
        id_tab_settings.setOnClickListener(this);

        id_viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                resetImg();

                switch (position){
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

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

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


        View tab01 = View.inflate(this, R.layout.tab01,null);
        View tab02 = View.inflate(this, R.layout.tab02,null);
        View tab03 = View.inflate(this, R.layout.tab03,null);
        View tab04 = View.inflate(this, R.layout.tab04,null);

        viewList = new ArrayList<>();
        viewList.add(tab01);
        viewList.add(tab02);
        viewList.add(tab03);
        viewList.add(tab04);

        pagerAdapter = new PagerAdapter(){

            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                View view = viewList.get(position);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                container.removeView(viewList.get(position));
            }
        };

        id_viewpager.setAdapter(pagerAdapter);
    }

    @Override
    public void onClick(View v) {

        resetImg();

        switch (v.getId()){
            case R.id.id_tab_weixin:
                id_viewpager.setCurrentItem(0);
                id_tab_weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case R.id.id_tab_frd:
                id_viewpager.setCurrentItem(1);
                id_tab_frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case R.id.id_tab_address:
                id_viewpager.setCurrentItem(2);
                id_tab_address_img.setImageResource(R.drawable.tab_address_pressed);
                break;
            case R.id.id_tab_settings:
                id_viewpager.setCurrentItem(3);
                id_tab_settings_img.setImageResource(R.drawable.tab_settings_pressed);
                break;

        }

    }

    /**
     * 将所有的图片切换为未选中的
     */
    private void resetImg(){
        id_tab_weixin_img.setImageResource(R.drawable.tab_weixin_normal);
        id_tab_frd_img.setImageResource(R.drawable.tab_find_frd_normal);
        id_tab_address_img.setImageResource(R.drawable.tab_address_normal);
        id_tab_settings_img.setImageResource(R.drawable.tab_settings_normal);
    }
}
