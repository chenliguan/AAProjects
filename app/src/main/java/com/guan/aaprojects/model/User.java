package com.guan.aaprojects.model;

import java.util.Date;

/**
 * @author Guan
 * @file com.guan.aaprojects.model
 * @date 2015/8/30
 * @Version 1.0
 */
public class User {

    /**
     * 用户表主键ID
     */
    private int mUserId;
    /**
     * 用户名称
     */
    private String mUserName;
    /**
     * 添加日期
     */
    private Date mCreateDate = new Date();
    /**
     * 状态0失效，1启用
     */
    private int mState = 1;

    public Date getCreateDate() {
        return mCreateDate;
    }

    public void setCreateDate(Date pCreateDate) {
        this.mCreateDate = mCreateDate;
    }

    public int getState() {
        return mState;
    }

    public void setState(int pState) {
        this.mState = mState;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int pUserId) {
        this.mUserId = mUserId;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }
}
