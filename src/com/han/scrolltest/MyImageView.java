package com.han.scrolltest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.Scroller;

public class MyImageView extends ImageView {

	private Scroller scroller;
	
	public MyImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		scroller = new Scroller(context);
	}

	public void reset(){
		scroller.startScroll(getScrollX(), getScrollY(), -getScrollX(), -getScrollY(), 2000);
		//重绘
		invalidate();
	}
	
	@Override
	public void computeScroll() {
		if(scroller.computeScrollOffset()){//计算此次的偏移量，并保存起来，如果滑动没有完成返回true
			//立即滑动到指定的便宜量坐标
			this.scrollTo(scroller.getCurrX(), scroller.getCurrY());
			//重绘
			invalidate();//导致computeScroll()反复执行，直到滑动完成
		}
	}
}
