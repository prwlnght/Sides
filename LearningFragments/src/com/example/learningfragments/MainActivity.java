package com.example.learningfragments;


import com.example.multipleFrag.MultipleFragmentActivity;
import com.example.multitouch.MultiTouchActivity;
import com.example.simpleFrag.SimpleFragmentActivity;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;



public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void simple(View v){
    	//create Intent
    	Intent intent = new Intent(getApplicationContext(), SimpleFragmentActivity.class);
    	startActivity(intent);
    }
    
    
    public void multiple(View v){
    	//create Intent
    	Intent intent = new Intent(getApplicationContext(), MultipleFragmentActivity.class);
    	startActivity(intent);
    }
    
    
    public void multiTouch(View v){
    	//create Intent
    	Intent intent = new Intent(getApplicationContext(), MultiTouchActivity.class);
    	startActivity(intent);
    }
}