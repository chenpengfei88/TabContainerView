# TabContainerView （实现底部导航栏效果）
#### 版本 V1.0

 ![image](https://github.com/chenpengfei88/TabContainerView/blob/master/app/src/main/res/drawable/xiaoguo.gif)
 
#### 如何使用
 
  Fragment[] fragments = new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()};
  tabContainerView = (TabContainerView) findViewById(R.id.tab_containerview_main);
  tabContainerView.setAdapter(new MainTabContainerAdapter(getSupportFragmentManager(), fragments));
        
        //设置当前选中的item
        
       tabContainerView.setCurrentItem(1);
       
       //设置当前有消息提示的item，提示小圆点
       
       tabContainerView.setCurrentMessageItem(1);
       
        //设置当前有消息提示的item，提示小圆点，小圆点有消息数量
        
       tabContainerView.setCurrentMessageItem(1, 3);
       
       小圆点的样式在layout的tab_item.xml中修改
       
       
    }
}


