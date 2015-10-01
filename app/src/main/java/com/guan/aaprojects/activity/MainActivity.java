package com.guan.aaprojects.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.guan.aaprojects.R;
import com.guan.aaprojects.adapter.GridAdapter;
import com.guan.aaprojects.model.SliderMenuItem;
import com.guan.aaprojects.view.SliderMenuView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Guan
 * @file com.example.guan.activity
 * @date 2015/8/14
 * @Version 1.0
 */
public class MainActivity extends FrameActivity implements SliderMenuView.OnSlideMenuListener {

    @Bind(R.id.gv_grid)
    GridView gvGrid;

    private List mStringList;
    private GridAdapter mGridAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppendMainBody(R.layout.main_body);

        ButterKnife.bind(this);

        initVariable();
        initView();
        bindData();
        createSlideMenu(R.array.slidemenu_activity_main);
    }

    /**
     * 初始化变量
     */
    private void initVariable() {
        mStringList = new ArrayList();

        mStringList.add(0, this.getString(R.string.grid_payout));
        mStringList.add(1, this.getString(R.string.grid_payout_manage));
        mStringList.add(2, this.getString(R.string.grid_statistics_manage));
        mStringList.add(3, this.getString(R.string.grid_accoutbook_manage));
        mStringList.add(4, this.getString(R.string.grid_category_manage));
        mStringList.add(5, this.getString(R.string.grid_user_manage));

        mGridAdapter = new GridAdapter(this, mStringList);
    }

    /**
     * 初始化视图
     */
    private void initView() {

    }

    /**
     * 绑定数据
     */
    private void bindData() {
        gvGrid.setAdapter(mGridAdapter);
    }


    /**
     * 3、设置监听器，实例化接口的回调
     *
     * @param view
     * @param sliderMenuItem
     */
    @Override
    public void onSlideMenuItemClick(View view, SliderMenuItem sliderMenuItem) {
        ShowMsg("sliderMenuItem.getTitle():" + sliderMenuItem.getTitle());
    }
}
