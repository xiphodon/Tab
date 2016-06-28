package com.gc.fragment_tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private LinearLayout id_tab_address;
    private LinearLayout id_tab_frd;
    private LinearLayout id_tab_settings;
    private LinearLayout id_tab_weixin;

    private ImageButton id_tab_weixin_img;
    private ImageButton id_tab_frd_img;
    private ImageButton id_tab_address_img;
    private ImageButton id_tab_settings_img;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

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

        id_tab_address = (LinearLayout) findViewById(R.id.id_tab_address);
        id_tab_frd = (LinearLayout) findViewById(R.id.id_tab_frd);
        id_tab_settings = (LinearLayout) findViewById(R.id.id_tab_settings);
        id_tab_weixin = (LinearLayout) findViewById(R.id.id_tab_weixin);

        id_tab_weixin_img = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        id_tab_frd_img = (ImageButton) findViewById(R.id.id_tab_frd_img);
        id_tab_address_img = (ImageButton) findViewById(R.id.id_tab_address_img);
        id_tab_settings_img = (ImageButton) findViewById(R.id.id_tab_settings_img);

    }

    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        //先全部隐藏
        hideFragment(transaction);
        // 把图片设置为亮的
        // 设置内容区域
        switch (i) {
            case 0:
                if (mTab01 == null) {
                    mTab01 = new WeixinFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else {
                    transaction.show(mTab01);
                }
                id_tab_weixin_img.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                if (mTab02 == null) {
                    mTab02 = new FrdFragment();
                    transaction.add(R.id.id_content, mTab02);
                } else {
                    transaction.show(mTab02);

                }
                id_tab_frd_img.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                if (mTab03 == null) {
                    mTab03 = new AddressFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else {
                    transaction.show(mTab03);
                }
                id_tab_address_img.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                if (mTab04 == null) {
                    mTab04 = new SettingFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else {
                    transaction.show(mTab04);
                }
                id_tab_settings_img.setImageResource(R.drawable.tab_settings_pressed);
                break;

        }

        transaction.commit();
    }


    private void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }
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

    /**
     * 将所有的图片切换为未选中的
     */
    private void resetImgs() {
        id_tab_weixin_img.setImageResource(R.drawable.tab_weixin_normal);
        id_tab_frd_img.setImageResource(R.drawable.tab_find_frd_normal);
        id_tab_address_img.setImageResource(R.drawable.tab_address_normal);
        id_tab_settings_img.setImageResource(R.drawable.tab_settings_normal);
    }
}
