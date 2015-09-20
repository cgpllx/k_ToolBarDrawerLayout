package com.example.toolbardrawerlayout;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
	DrawerLayout mDrawerLayout;
	AppBarLayout appBarLayout;
	CoordinatorLayout coordinatorLayout;
	NavigationView navigationView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setNavigationIcon(R.drawable.ic_launcher);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//		navigationView = (NavigationView) findViewById(R.id.id_nv_menu);
		
//		setUpNavigationView(navigationView);
		// toolbar.setTitleTextColor(getResources().getColor(R.color.hong));

		// toolbar.settex
		setSupportActionBar(toolbar);
		// getSupportActionBar().setHomeButtonEnabled(true); // 设置返回键可用
		// getSupportActionBar().setDisplayHomeAsUpEnabled(true);

		// 创建返回键，并实现打开关/闭监听
		ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.abc_action_bar_home_description, R.string.abc_action_bar_home_description) {
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
				// mAnimationDrawable.stop();
			}

			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
				// mAnimationDrawable.start();
			}

		};
		// mDrawerToggle.setHomeAsUpIndicator(new DrawerArrowDrawable(this) {
		//
		// @Override
		// public boolean isLayoutRtl() {
		// return false;
		// }
		// });
		// mDrawerToggle.setHomeAsUpIndicator(R.drawable.ic_launcher);
		mDrawerToggle.setDrawerIndicatorEnabled(true);
		mDrawerToggle.syncState();
		mDrawerLayout.setDrawerListener(mDrawerToggle);
//		NavigationView navigationView=(NavigationView) findViewById(R.id.id_nv_menu);
//		setupDrawerContent(navigationView);
	}

//	private void setUpNavigationView(NavigationView navigationView2) {
//		TextView textview=new TextView(this);
//		textview.setText("footerview");
//		textview.setHeight(100);
//		FrameLayout.LayoutParams para=new FrameLayout.LayoutParams(300, 300, Gravity.BOTTOM);
//		navigationView2.addView(textview,para);
//	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add("fff");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings11) {
			return super.onOptionsItemSelected(item);
		}
		return super.onOptionsItemSelected(item);
	}

	private void setupDrawerContent(NavigationView navigationView) {
		navigationView.setNavigationItemSelectedListener(

		new NavigationView.OnNavigationItemSelectedListener() {

			@Override
			public boolean onNavigationItemSelected(MenuItem menuItem) {
				menuItem.setChecked(true);
				mDrawerLayout.closeDrawers();
				return true;
			}
		});
	}
}
