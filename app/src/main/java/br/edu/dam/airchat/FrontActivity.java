package br.edu.dam.airchat;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.bluetoothchat.R;

public class FrontActivity extends Activity
{
	private BluetoothManager bltManager;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_front);
		Context context = this;
		BluetoothAdapter bltAdapter = BluetoothAdapter.getDefaultAdapter();
		if (!bltAdapter.isEnabled())
		{
			// check if the bluetooth is enabled
			Intent enableBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			context.startActivity(enableBluetooth);
		}
		MyDeviceData.adress = bltAdapter.getAddress();
		MyDeviceData.name = bltAdapter.getName();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.front, menu);
		return true;
	}

	public void clientClick(View v)
	{
		Intent clt = new Intent(FrontActivity.this, ClientActivity.class);
		startActivity(clt);
	}

	public void serverClick(View v)
	{
		Intent srv = new Intent(FrontActivity.this, ServerActivity.class);
		startActivity(srv);
	}

}
