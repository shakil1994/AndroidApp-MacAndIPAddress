package com.blackbirds.shakil.kotlinmacandipaddress

import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Formatter
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var txtIPAddress: TextView? = null
    var txtMacAddress: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtIPAddress = findViewById(R.id.txtIPAddress)
        txtMacAddress = findViewById(R.id.txtMacAddress)

        val wifiManager = applicationContext.getSystemService(WIFI_SERVICE) as WifiManager
        val ip = Formatter.formatIpAddress(wifiManager.connectionInfo.ipAddress)
        val mac = wifiManager.connectionInfo.macAddress

        txtIPAddress?.text = "IP Address: $ip"
        txtMacAddress?.text = "MAC Address: $mac"
    }
}