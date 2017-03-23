package com.fe.tabcontainerview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.fe.library.TabContainerView;
import com.fe.library.listener.OnTabSelectedListener;
import com.fe.library.widget.Tab;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        TabContainerView tabContainerView = (TabContainerView) findViewById(R.id.tab_containerview_main);

        tabContainerView.setAdapter(new MainTabContainerAdapter(getSupportFragmentManager(),
                new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()}));

        tabContainerView.setOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
            }
        });
    }
}
