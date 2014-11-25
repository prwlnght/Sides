package com.example.multipleFrag;

import com.example.learningfragments.R;
import com.example.learningfragments.R.id;
import com.example.learningfragments.R.layout;
import com.example.learningfragments.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MultipleFragmentActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multiple_fragment);
		
		
		
	if(savedInstanceState == null){
		getSupportFragmentManager().beginTransaction().add(R.id.menu_container, new MenuFragment()).commit();
		}
	}
}
