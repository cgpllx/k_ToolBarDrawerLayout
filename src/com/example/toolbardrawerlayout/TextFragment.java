package com.example.toolbardrawerlayout;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TextFragment extends Fragment {
	FloatingActionButton floatingactionbutton;
	CoordinatorLayout coordinatorlayout;
	ListView listview;
	SwipeRefreshLayout swiperefreshlayout;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		swiperefreshlayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefreshlayout);
//		swiperefreshlayout.setBackgroundResource(R.drawable.ic_launcher);
//		swiperefreshlayout.setp
//		swiperefreshlayout.setColorSchemeResources(R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher);
		swiperefreshlayout.setColorSchemeResources(android.R.color.holo_green_light,android.R.color.holo_green_light,android.R.color.holo_green_light,android.R.color.holo_green_light);
		listview = (ListView) view.findViewById(R.id.listview);
		coordinatorlayout = (CoordinatorLayout) view.findViewById(R.id.coordinatorlayout1);
		floatingactionbutton = (FloatingActionButton) view.findViewById(R.id.floatingactionbutton);
		com.kubeiwu.customview.floatingactionbutton.FloatingActionButton lfloatingactionbutton; 
		lfloatingactionbutton = (com.kubeiwu.customview.floatingactionbutton.FloatingActionButton) view.findViewById(R.id.lfloatingactionbutton);
		lfloatingactionbutton.attachToListView(listview);
		floatingactionbutton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Snackbar.make(coordinatorlayout, "hahahah", Snackbar.LENGTH_LONG)
				// .setAction(R.string.snackbar_action, myOnClickListener)
						.show();
			}
		});
		listview.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				TextView textview = new TextView(getContext());
				textview.setHeight(100);
				textview.setText("position=" + position);
				return textview;
			}

			@Override
			public long getItemId(int position) {
				return 0;
			}

			@Override
			public Object getItem(int position) {

				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 50;
			}
		});

	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.clear();
		// setHasOptionsMenu(false);
		// super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.main, menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		Toast.makeText(getContext(), item.getItemId() + "", 1).show();

		return super.onOptionsItemSelected(item);
	}

	public static final String ARG_PAGE = "ARG_PAGE";
	private int mPage;

	public static TextFragment newInstance(int page) {
		Bundle args = new Bundle();
		args.putInt(ARG_PAGE, page);
		SwipeRefreshLayout d;
		TextFragment pageFragment = new TextFragment();
		pageFragment.setArguments(args);
		return pageFragment;
	}

}
