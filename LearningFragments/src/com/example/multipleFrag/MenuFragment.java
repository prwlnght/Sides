package com.example.multipleFrag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.learningfragments.R;

public class MenuFragment extends Fragment {

	Fragment frag;
	FragmentTransaction fragTransaction;

	public MenuFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.menu_multi, container, false);

		frag = new KoalaFragment();
		fragTransaction = getFragmentManager().beginTransaction().add(
				R.id.container, frag);
		fragTransaction.commit();

		Button buttonChair = (Button) view.findViewById(R.id.buttonChair);

		Button buttonKoala = (Button) view.findViewById(R.id.buttonKoala);

		Button buttonOthers = (Button) view.findViewById(R.id.buttonOthers);

		buttonChair.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				frag = new ChairFragment();
				fragTransaction = getFragmentManager().beginTransaction()
						.replace(R.id.container, frag);
				fragTransaction.commit();

			}
		});

		buttonKoala.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				frag = new KoalaFragment();
				fragTransaction = getFragmentManager().beginTransaction()
						.replace(R.id.container, frag);
				fragTransaction.commit();

			}
		});

		buttonChair.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				frag = new ChairFragment();
				fragTransaction = getFragmentManager().beginTransaction()
						.replace(R.id.container, frag);
				fragTransaction.commit();
			}
		});

		buttonOthers.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				frag = new OtherFragment();
				fragTransaction = getFragmentManager().beginTransaction()
						.replace(R.id.container, frag);
				fragTransaction.commit();

			}
		});

		return view;
	}

}
