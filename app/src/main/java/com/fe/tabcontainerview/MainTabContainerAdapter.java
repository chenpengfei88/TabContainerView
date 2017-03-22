package com.fe.tabcontainerview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.fe.library.adapter.BaseAdapter;

/**
 * Created by chenpengfei on 2017/3/21.
 */
public class MainTabContainerAdapter extends BaseAdapter {

    private Fragment[] fragmentArray;
    private FragmentManager fragmentManager;

    public MainTabContainerAdapter(FragmentManager fragmentManager, Fragment[] fragmentArray) {
        this.fragmentManager = fragmentManager;
        this.fragmentArray = fragmentArray;
    }

    @Override
    public int getCount() {
        return 4;
    }


    @Override
    public String[] getTextArray() {
        return new String[] {"主页", "工作", "应用", "我"};
    }

    @Override
    public Fragment[] getFragmentArray() {
        return fragmentArray;
    }

    @Override
    public int[] getIconImageArray() {
        return new int[] {R.drawable.icon_main, R.drawable.icon_work, R.drawable.icon_app, R.drawable.icon_mine};
    }

    @Override
    public int[] getSelectedIconImageArray() {
        return new int[] {R.drawable.icon_main_selected, R.drawable.icon_work_selected, R.drawable.icon_app_selected, R.drawable.icon_mine_selected};
    }

    @Override
    public FragmentManager getFragmentManager() {
        return fragmentManager;
    }
}
