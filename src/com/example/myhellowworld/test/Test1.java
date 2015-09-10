package com.example.myhellowworld.test;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

@SuppressLint("NewApi")
@SuppressWarnings("rawtypes")
public class Test1 extends
		ActivityInstrumentationTestCase2 {
	// 对应re-sign.jar生成出来的信息框里的两个值
	private static String mainActiviy = "com.example.myhelloworld.MainActivity";
	private static Class<?> launchActivityClass;
	// 静态加载auncherActivityClass，被测程序主类
	static {
		try {
			launchActivityClass = Class.forName(mainActiviy);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public Test1() {
		super(launchActivityClass);
		// TODO Auto-generated constructor stub
	}

	public Solo solo;
	public Activity activity;

	@Override
	// 初始化Solo实例
	protected void setUp() throws Exception {
		super.setUp();
		this.activity = this.getActivity();// 与被测应用通讯
		this.solo = new Solo(getInstrumentation(), getActivity());
	}

	@Override
	// 清除实例，回收
	public void tearDown() throws Exception {
		try {
			this.solo.finishOpenedActivities();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.activity.finish();
		super.tearDown();
	}

	// ++++++++++++++++++++++++++++++++++++++++++++++
	public void test_helloWrold() {
		solo.clickOnText("Hello world!");
	}

	// ***********************自定义方法begin**********************************

	// ***********************自定义方法end**********************************

}
