package com.fe.library.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Created by chenpengfei on 2017/3/22.
 */
public abstract class BaseAdapter {

    /**
     *  tab数量
     */
    public abstract int getCount();

    /**
     * tab text 数组
     */
    public abstract String[] getTextArray();

    /**
     * tab icon 数组
     */
    public abstract int[] getIconImageArray();

    /**
     * tab icon 选中 数组
     */
    public abstract int[] getSelectedIconImageArray();

    /**
     * fragment 数组
     */
    public abstract Fragment[] getFragmentArray();

    public abstract FragmentManager getFragmentManager();

}
