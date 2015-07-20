package com.example.moderartui;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.moderartui.ImageAdapter;;

public class UIFragment extends Fragment {

	public interface ImageSelectionListener{
		public void imageSelected(long id);
	}
	
	protected static final String EXTRA_RES_ID = "POS";
	GridView grid;
	private ArrayList<Integer> mThumbIdsFlowers = new ArrayList<Integer>(
			Arrays.asList(R.drawable.cream,R.drawable.pink,R.drawable.blue,R.drawable.grey,R.drawable.pic1,R.drawable.pic2,R.drawable.pic3));
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		// super.onCreateView(inflater, container, savedInstanceState);
	    // Write Stuff here
		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		grid =(GridView) rootView.findViewById(R.id.gridview);
		grid.setAdapter(new ImageAdapter(getActivity().getApplicationContext(), mThumbIdsFlowers));
		grid.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				//Create an Intent to start the ImageViewActivity
				Intent intent = new Intent(getActivity().getApplicationContext(),
						ImageViewActivity.class);
				
				// Add the ID of the thumbnail to display as an Intent Extra
				intent.putExtra(EXTRA_RES_ID, (int) id);
				
				// Start the ImageViewActivity
				startActivity(intent);
			}
		});
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
	}

}
