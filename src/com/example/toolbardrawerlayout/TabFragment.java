package com.example.toolbardrawerlayout;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment{
	private TabLayout tablayout;
	private ViewPager viewpager;
	private SimpleFragmentPagerAdapter pagerAdapter;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.tabfragment, container, false);
	}
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		tablayout=(TabLayout) view.findViewById(R.id.tablayout);
		viewpager=(ViewPager) view.findViewById(R.id.viewpager);
		pagerAdapter=  new SimpleFragmentPagerAdapter(getChildFragmentManager(), getContext());
		viewpager.setAdapter(pagerAdapter);
		tablayout.setupWithViewPager(viewpager);
	}
}
