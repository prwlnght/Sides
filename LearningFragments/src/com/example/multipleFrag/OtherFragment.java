package com.example.multipleFrag;
import com.example.learningfragments.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class OtherFragment extends Fragment {
	
	public OtherFragment() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_multiple_other, null);
		
		Button btnMulti = (Button)rootView.findViewById(R.id.MultiClickMe);
		
		btnMulti.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "Multi-Clicked", Toast.LENGTH_SHORT).show();
				
			}
		});
		
		return rootView;
	}
	
}
