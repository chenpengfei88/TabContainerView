# TabContainerView （实现底部导航栏效果）
### 版本 V1.0

 ![image](https://github.com/chenpengfei88/TabContainerView/blob/master/app/src/main/res/drawable/xiaoguo.gif)
 
#### 如何引用
 ```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
 compile 'com.github.chenpengfei88:TabContainerView:v1.0'
 ```
 
#### 如何使用
 ```
  Fragment[] fragments = new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()};
  TabContainerView tabContainerView = (TabContainerView) findViewById(R.id.tab_containerview_main);
  tabContainerView.setAdapter(new MainTabContainerAdapter(getSupportFragmentManager(), fragments));
 ```
#### 常用方法
 ```
   //设置当前选中的item
   tabContainerView.setCurrentItem(1);
   
   //设置当前有消息提示的item，提示小圆点
   tabContainerView.setCurrentMessageItem(1);
       
   //设置当前有消息提示的item，提示小圆点，小圆点有消息数量
   tabContainerView.setCurrentMessageItem(1, 3);
   
   //tab切换监听
   tabContainerView.setOnTabSelectedListener(new OnTabSelectedListener() {
        @Override
        public void onTabSelected(Tab tab) {
        }
   });
 ```
#### 资源属性
 ```
  <declare-styleable name="TabContainerViewStyle">
        <attr name="textSize" format="dimension" />
        <attr name="textColor" format="color" />
        <attr name="selectedTextColor" format="color" />
        <attr name="divideLineColor" format="color" />
        <attr name="divideLineHeight" format="integer" />
  </declare-styleable>
 ```
#### 源码逻辑解析
http://www.jianshu.com/p/7cccb5c054da



### 版本 V2.0

  ![image](https://github.com/chenpengfei88/TabContainerView/blob/master/app/src/main/res/drawable/xiaoguo2.0.gif)
  
  从效果图中可以看出V2.0和V1.0的区别
  V2.0的Tab UI是可以实现高度定制的，上面的效果图中Tab UI共有三种样式。
  V1.0的Tab UI是定死的
  
#### 如何引用
 ```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 
 compile 'com.github.chenpengfei88:TabContainerView:v2.0'
 ```
 #### 如何使用
 
 首先创建一个继承自AbsTab类的Tab类（项目中我默认实现了一个DefaultTab），
 然后创建一个继承自BaseAdapter类的适配器类（项目中我默认实现了一个DefaultAdapter）
 
 ```
  Fragment[] fragments = new Fragment[] {new MainFragment(), new WorkFragment(), new AppFragment(), new MineFragment()};
  TabContainerView tabContainerView = (TabContainerView) findViewById(R.id.tab_containerview_main);
  tabContainerView.setAdapter(new DefaultAdapter(this, fragments, getSupportFragmentManager(),           getResources().getStringArray(R.array.titleArray),
 getResources().getColor(R.color.colorPrimary), iconImageArray, selectedIconImageArray));
 ```
 #### 常用方法
 ```
   //设置当前选中的item
   tabContainerView.setCurrentItem(1);
   
   //设置当前有消息提示的item，提示小圆点
   tabContainerView.setCurrentMessageItem(1);
       
   //设置当前有消息提示的item，提示小圆点，小圆点有消息数量
   tabContainerView.setCurrentMessageItem(1, 3);
   
   //tab切换监听
   tabContainerView.setOnTabSelectedListener(new OnTabSelectedListener() {
        @Override
        public void onTabSelected(Tab tab) {
        }
   });
 ```
#### 资源属性
 ```
    <declare-styleable name="TabContainerViewStyle">
        <attr name="divideLineColor" format="color" />
        <attr name="divideLineHeight" format="integer" />
    </declare-styleable>
 ```
#### 源码逻辑解析
http://www.jianshu.com/p/9aaff43bbf9f

 
