package com.fe.tabcontainerview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fe.library.TabContainerView;
import com.fe.library.listener.OnTabSelectedListener;
import com.fe.library.widget.Tab;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabContainerView tabContainer = (TabContainerView) findViewById(R.id.container_tab);
        Fragment[] fragments = new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()};
        tabContainer.setAdapter(new MainTabContainerAdapter(this, getSupportFragmentManager(), fragments));

        tabContainer.setCurrentItem(0);

        tabContainer.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                System.out.println("=====MainAcitivty  onTabSelected=====" + tab.getIndex());
            }
        });

    }
}
