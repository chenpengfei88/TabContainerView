# TabContainerView
Android TabContainerView 实现底部导航栏效果

 ![image](https://github.com/chenpengfei88/TabContainerView/blob/master/app/src/main/res/drawable/xiaoguo.gif)
 
 # 使用
 
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
        
        //设置当前选中的item
        
       tabContainerView.setCurrentItem(1);
       
       //设置当前有消息提示的item，提示小圆点
       
       tabContainerView.setCurrentMessageItem(1);
       
        //设置当前有消息提示的item，提示小圆点，小圆点有消息数量
        
       tabContainerView.setCurrentMessageItem(1, 3);
       
    }
}


