package com.code_remote.bythepool

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bluetooth_scan.*
import kotlinx.android.synthetic.main.list_bluetooth_item.view.*


class BluetoothScanActivity : AppCompatActivity() {

    private lateinit var bluetoothAdapter: BluetoothAdapter
    private lateinit var listAdapter: BluetoothDeviceListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth_scan)

        listAdapter = BluetoothDeviceListAdapter(this)
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        bluetoothList.adapter = listAdapter
        if (!bluetoothAdapter.isEnabled) {
            Toast.makeText(this, "Bluetooth is Disabled", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onResume() {
        bluetoothAdapter.bluetoothLeScanner.startScan(scannerCallback)
        super.onResume()
    }

    override fun onPause() {
        bluetoothAdapter.bluetoothLeScanner.stopScan(scannerCallback)
        super.onPause()
    }


    private val scannerCallback: ScanCallback = object : ScanCallback() {

        override fun onScanResult(callbackType: Int, result: ScanResult?) {
            super.onScanResult(callbackType, result)
            result?.let {
                listAdapter.items.add(it.device)
                listAdapter.notifyDataSetChanged()
            }
        }
    }

    class BluetoothDeviceListAdapter(
        context: Context,
        val items: MutableList<BluetoothDevice> = mutableListOf()
    ) : BaseAdapter() {

        private val inflater = LayoutInflater.from(context)

        override fun getCount(): Int {
            return items.size
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val rootView =
                convertView ?: inflater.inflate(R.layout.list_bluetooth_item, parent, false)

            rootView.deviceName.text = items[position].run {
                """
                            ${name}
                            ${address}
                            """.trimIndent()
            }

            return rootView
        }


        override fun getItem(position: Int): Any {
            return Any()
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

    }
}