package com.guan.aaprojects.model;

/**
 * @author Guan
 * @file com.guan.aaprojects.bean
 * @date 2015/8/29
 * @Version 1.0
 */
public class SliderMenuItem {

    private int mItemId;
    private String mTitle;

    public SliderMenuItem(int mItemId, String mTitle) {
        this.mItemId = mItemId;
        this.mTitle = mTitle;
    }

    public int getItemId() {
        return mItemId;
    }

    public void setItemId(int pItemId) {
        this.mItemId = pItemId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String pTitle) {
        this.mTitle = pTitle;
    }
}
