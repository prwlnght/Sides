package com.example.helloworld;



import java.util.Set;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity  extends ActionBarActivity{

   
	private static final int REQUEST_ENABLE_BT = 3;
	BluetoothAdapter mBluetoothAdapter;
	private static final String TAG = "BluetoothExample";
	private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
	private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
	private ArrayAdapter<String> mArrayAdapter;
	private static final boolean D = true;
	public static final String EXTRA_MESSAGE = "MainActivityMessage";
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        
       
        
        if(mBluetoothAdapter == null){
	    	Toast.makeText(this, "Device does not support BT", Toast.LENGTH_SHORT).show();
	    }
	    else Toast.makeText(this, "BT here", Toast.LENGTH_LONG).show();
	    
	    if(!mBluetoothAdapter.isEnabled()){
	    	Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
	    	startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
	    	
	    }
	    
	    else 
	    	Toast.makeText(this, "BT already enabled", Toast.LENGTH_LONG).show();
	    
	    
	    //Register the BroadcastReceiver
        IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(mReceiver, filter); // Don't forget to unregister during onDestroy
    
	    
        // Register for broadcasts when discovery has finished
        filter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        this.registerReceiver(mReceiver, filter);
	  
	    //Assuming the Bluetooth was already enabled
	    //quering the paired devices
	    Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
	    // If there are paired devices
	    if (pairedDevices.size() > 0) {
	     // Loop through paired devices
	     for (BluetoothDevice device : pairedDevices) {
	         // Add the name and address to an array adapter to show in a ListView
	         
	    	 //TODO implement adding to the array adapter to show to the user 
	    	 //mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
	    	 Toast.makeText(this, device.getName(), Toast.LENGTH_SHORT).show();
	     }
	    }
	    
	    //here we start something 
	    mBluetoothAdapter.startDiscovery();
	
	}
	
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(D) Log.d(TAG, "onActivityResult " + resultCode);
        switch (requestCode) {
        case REQUEST_CONNECT_DEVICE_SECURE:
            // When DeviceListActivity returns with a device to connect
            if (resultCode == Activity.RESULT_OK) {
                //connectDevice(data, true);
            }
            break;
        case REQUEST_CONNECT_DEVICE_INSECURE:
            // When DeviceListActivity returns with a device to connect
            if (resultCode == Activity.RESULT_OK) {
                //connectDevice(data, false);
            }
            break;
        case REQUEST_ENABLE_BT:
            // When the request to enable Bluetooth returns
            if (resultCode == Activity.RESULT_OK) {
                // Bluetooth is now enabled, so set up a chat session
                //setupChat();
            } else {
                // User did not enable Bluetooth or an error occurred
                Log.d(TAG, "BT not enabled");
                Toast.makeText(this, R.string.bt_not_enabled_leaving, Toast.LENGTH_SHORT).show();
                finish();
            }
        }
    }
    
    
    // Create a BroadcastReceiver for ACTION_FOUND
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            // When discovery finds a device
            if (BluetoothDevice.ACTION_FOUND.equals(action)) {
                // Get the BluetoothDevice object from the Intent
                BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
                // Add the name and address to an array adapter to show in a ListView
             //   mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }
    };

    /** called when the user clicks send message
     * 
     */
    
    public void sendMessage(View v){
    	Toast.makeText(this, TAG, Toast.LENGTH_SHORT).show();
    	
    	//here we start an activity
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    
    public void sayHello(View v){
    	Toast.makeText(this, TAG, Toast.LENGTH_SHORT).show();
    	
    	//here we start an activity
    	Intent intent = new Intent(this, SayHelloActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message2);
    	String message = editText.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onDestroy(){
    	unregisterReceiver(mReceiver); 
    	super.onDestroy();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
