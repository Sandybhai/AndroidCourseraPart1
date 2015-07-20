package com.example.moderartui;

import android.app.Activity;
import android.app.ActionBar;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.os.Build;

public class MainActivity extends Activity implements UIFragment.ImageSelectionListener{
    
	private UIFragment mUIFragment;
	private DialogFragment mDialog;
	protected static final String EXTRA_RES_ID = "POS";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mUIFragment = new UIFragment();
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, mUIFragment).commit();
			
		
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			
			mDialog = AlertDialogFragment.newInstance();
			mDialog.show(getFragmentManager(), "NOTE");
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	public void imageSelected(long id){
		Intent intent = new Intent(getApplicationContext(),
				ImageViewActivity.class);
		
		// Add the ID of the thumbnail to display as an Intent Extra
		intent.putExtra(EXTRA_RES_ID, (int) id);
		
		// Start the ImageViewActivity
		startActivity(intent);
		Log.i("INSIDE MAIN","hehe");
		 
		
	}
}
