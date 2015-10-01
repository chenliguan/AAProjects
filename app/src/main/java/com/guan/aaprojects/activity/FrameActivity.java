package com.guan.aaprojects.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.guan.aaprojects.R;
import com.guan.aaprojects.model.SliderMenuItem;
import com.guan.aaprojects.view.SliderMenuView;

/**
 * @author Guan
 * @file com.example.guan.activity
 * @date 2015/8/14
 * @Version 1.0
 */
public class FrameActivity extends BaseActivity {

    SliderMenuView mSliderMenuView;

    /**
     * 把与业务相关的系统框架、界面初始化、设置等操作封装
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    /**
     * 动态添加主界面的girdview布局
     *
     * @param pResID
     */
    protected void AppendMainBody(int pResID) {
        LinearLayout _mainBody = (LinearLayout) findViewById(R.id.llyt_main_body);
        View _view = LayoutInflater.from(this).inflate(pResID, null);
        _mainBody.addView(_view, RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
    }

    /**
     * 创建菜单
     *
     * @param ResId
     */
    protected void createSlideMenu(int ResId) {

        mSliderMenuView = new SliderMenuView(this);
        String[] _menuItemArray = getResources().getStringArray(ResId);

        for (int i = 0; i < _menuItemArray.length; i++) {
            SliderMenuItem _item = new SliderMenuItem(i, _menuItemArray[i]);
            mSliderMenuView.add(_item);
        }

        mSliderMenuView.bindList();
    }

}
