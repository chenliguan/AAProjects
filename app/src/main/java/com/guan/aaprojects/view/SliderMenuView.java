package com.guan.aaprojects.view;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.guan.aaprojects.R;
import com.guan.aaprojects.adapter.SliderMenuAdapter;
import com.guan.aaprojects.model.SliderMenuItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guan
 * @file com.guan.aaprojects.view
 * @date 2015/8/29
 * @Version 1.0
 */
public class SliderMenuView {

    private Activity mActivity;
    private List mMenuList;
    private boolean mIsClosed;
    private RelativeLayout layBottomBox;
    private OnSlideMenuListener mOnSlideMenuListener;

    /**
     * 1、定义回调接口
     */
    public interface OnSlideMenuListener {
        public abstract void onSlideMenuItemClick(View view,SliderMenuItem sliderMenuItem);
    }

    public SliderMenuView(Activity mActivity) {
        this.mActivity = mActivity;
        mOnSlideMenuListener = (OnSlideMenuListener) mActivity;

        initVariable();
        initView();
        initListeners();
    }

    private void initVariable() {
        mMenuList = new ArrayList();
        mIsClosed = true;
    }

    private void initView() {
        layBottomBox = (RelativeLayout) mActivity.findViewById(R.id.include_bottom);
    }

    private void initListeners() {
        layBottomBox.setOnClickListener(new OnSlideMenuClick());

        layBottomBox.setFocusableInTouchMode(true);
        layBottomBox.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (keyCode == KeyEvent.KEYCODE_MENU && event.getAction() == KeyEvent.ACTION_UP) {
                    toggle();
                }
                return false;
            }
        });
    }

    public void open() {
        RelativeLayout.LayoutParams _layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);
        _layoutParams.addRule(RelativeLayout.BELOW, R.id.include_title);
        layBottomBox.setLayoutParams(_layoutParams);
        mIsClosed = false;
    }

    public void close() {
        RelativeLayout.LayoutParams _layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, 196);
        _layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layBottomBox.setLayoutParams(_layoutParams);
        mIsClosed = true;
    }

    public void toggle() {
        if (mIsClosed) {
            open();
        } else {
            close();
        }
    }

    public void add(SliderMenuItem slideMenuItem) {
        mMenuList.add(slideMenuItem);
    }

    public void bindList() {
        SliderMenuAdapter _slideMenuAdapter = new SliderMenuAdapter(mActivity, mMenuList);
        ListView _listView = (ListView) mActivity.findViewById(R.id.lv_slidelist);
        _listView.setAdapter(_slideMenuAdapter);
        _listView.setOnItemClickListener(new OnSlideMenuItemClick());
    }

    public void onSlideMenuClick() {

    }

    private class OnSlideMenuClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            toggle();
        }
    }

    private class OnSlideMenuItemClick implements android.widget.AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

            /**
             * 2、在某个情景下需要执行的方法
             */
            SliderMenuItem _sliderMenuItem = (SliderMenuItem) adapterView.getItemAtPosition(position);
            mOnSlideMenuListener.onSlideMenuItemClick(view,_sliderMenuItem);
        }
    }
}
