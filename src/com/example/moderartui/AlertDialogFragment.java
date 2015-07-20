package com.example.moderartui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment {
	public static AlertDialogFragment newInstance() {
		return new AlertDialogFragment();
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//return super.onCreateDialog(savedInstanceState);
		return new AlertDialog.Builder(getActivity())
		.setMessage("You could check out more art here!!")
		
		// User cannot dismiss dialog by hitting back button
		.setCancelable(false)
		
		
		// Set up No Button
				
		.setNegativeButton("Not Now",
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dismiss();
					}
				})		
		.setPositiveButton("Check Out", 
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = null;
						Uri link =Uri.parse("http://www.jehangirartgallery.com/");
						intent = new Intent(Intent.ACTION_VIEW,link);
						startActivity(intent);
					}
				}).create();		

}

	}



