package com.fe.library.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.fe.library.widget.AbsTab;

/**
 * Created by chenpengfei on 2017/3/22.
 */
public abstract class BaseAdapter {

    private Fragment[] mFragmentArray;
    private FragmentManager mFragmentManager;

    public BaseAdapter(Fragment[] fragments, FragmentManager fragmentManager) {
        mFragmentArray = fragments;
        mFragmentManager = fragmentManager;
    }

    /**
     *  tab数量
     */
    public int getCount() {
        return mFragmentArray != null ? mFragmentArray.length : 0;
    }

    /**
     * fragment 数组
     */
    public Fragment[] getFragmentArray() {
        return mFragmentArray;
    }

    public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    /**
     *  得到tab
     * @return
     */
    public abstract AbsTab getTab(int index);

}
