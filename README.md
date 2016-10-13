# TipView
基于android-target-tooltip修改的---新功能提示view（可自定义提示样式）
####参考代码：https://github.com/sephiroth74/android-target-tooltip

只是基于这个代码改了一点，满足自己的需求

###ScreenShots

![image](https://github.com/yaoyao0719/TipView/blob/master/screenshots/2.png)

#### 备注：
- 1.原来的代码本身也是支持用户自定义提示样式的`withCustomView(R.layout.custom_view)`，但是这个方法设置以后，就没有“箭头了”，具体效果看截图；
- 2.源代码各个java代码实现的功能:
> 1.TooltipOverlay、TooltipOverlayDrawable 是用来实现目标view上的点击效果，在我这个项目中暂时没有用到；
> 
> 2.TooltipTextDrawable 实现背景---就是带有小箭头、圆角之类的背景，非常重要（核心就是代码画背景）；
> 
> 3.Tooltip 实现“提示view”的构建，展示，关闭，等等

- 3.主要修改的代码段落：

Tooltip initializeView（）方法中

```
if (null != mDrawable) {
    mTextView.setBackgroundDrawable(mDrawable);
if (mHideArrow) {
    mTextView.setPadding(mPadding / 2, mPadding / 2, mPadding / 2, mPadding / 2);
} else {
    mTextView.setPadding(mPadding, mPadding, mPadding, mPadding);
    }
}
```
这段代码中，mDrawable就是TooltipTextDrawable，指绘制的背景，所以只需要将mTextView改成我们需要的view就可以了，修改后：

```
if (null != mDrawable) {
    mLayout.setBackgroundDrawable(mDrawable);
if (mHideArrow) {
    mLayout.setPadding(mPadding / 2, mPadding / 2, mPadding / 2, mPadding / 2);
} else {
    mLayout.setPadding(mPadding, mPadding, mPadding, mPadding);
    }
}
```

其中mLayout就是我们自定义的样式，写在tooltip_view.xml中
```
mTextView = (TextView) mView.findViewById(android.R.id.text1);
mLbDismiss = (TextView) mView.findViewById(R.id.lbDismiss);
mLayout = (LinearLayout) mView.findViewById(R.id.layout);
```


