package com.fe.tabcontainerview.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.fe.library.adapter.BaseAdapter;
import com.fe.library.widget.AbsTab;
import com.fe.tabcontainerview.ExampleOneTab;

/**
 * Created by chenpengfei on 2017/4/28.
 */
public class ExampleOneAdapter extends BaseAdapter {

    private String[] mStrArray;

    public ExampleOneAdapter(Context context, Fragment[] fragments, FragmentManager fragmentManager, String[] strArray) {
        super(context, fragments, fragmentManager);

        mStrArray = strArray;
    }

    @Override
    public AbsTab getTab(int index) {
        ExampleOneTab tab = new ExampleOneTab(mContext, index);
        tab.setText(mStrArray[index]);
        return tab;
    }
}
