package com.blackbirds.shakil.macipaddress;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtIPAddress, txtMacAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtIPAddress = findViewById(R.id.txtIPAddress);
        txtMacAddress = findViewById(R.id.txtMacAddress);

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wifiManager.getConnectionInfo().getIpAddress());
        String mac = wifiManager.getConnectionInfo().getMacAddress();

        txtIPAddress.setText("IP Address: " + ip);
        txtMacAddress.setText("MAC Address: " + mac);
    }
}