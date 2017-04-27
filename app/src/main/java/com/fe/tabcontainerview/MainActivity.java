package com.fe.tabcontainerview;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.fe.library.TabContainerView;
import com.fe.library.adapter.DefaultAdapter;


public class MainActivity extends AppCompatActivity {

    private TabContainerView tabContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        int[] iconImageArray = {R.drawable.icon_main, R.drawable.icon_work, R.drawable.icon_app, R.drawable.icon_mine};
        int[] selectedIconImageArray = {R.drawable.icon_main_selected, R.drawable.icon_work_selected, R.drawable.icon_app_selected, R.drawable.icon_mine_selected};
        Fragment[] fragments = new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()};

        tabContainerView = (TabContainerView) findViewById(R.id.tab_containerview_main);
        tabContainerView.setAdapter(new DefaultAdapter(this, fragments, getSupportFragmentManager(), getResources().getStringArray(R.array.titleArray),
           getResources().getColor(R.color.colorPrimary), iconImageArray, selectedIconImageArray));
    }
}
