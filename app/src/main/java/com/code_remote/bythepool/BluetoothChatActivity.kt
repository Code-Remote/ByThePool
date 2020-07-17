package com.code_remote.bythepool

import android.annotation.SuppressLint
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.le.ScanCallback
import android.bluetooth.le.ScanResult
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_bluetooth_scan.*
import kotlinx.android.synthetic.main.list_bluetooth_item.view.*

class BluetoothChatActivity : AppCompatActivity() {

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

    private var mConnectedDeviceName: String? = null
    private val mHandler: Handler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {

            when (msg.what) {
                Constants.MESSAGE_STATE_CHANGE -> when (msg.arg1) {
                    BluetoothChatService.STATE_CONNECTED -> {
                        //clear list
                    }
                    BluetoothChatService.STATE_CONNECTING -> {
                    }// set connecting status
                    BluetoothChatService.STATE_LISTEN,
                    BluetoothChatService.STATE_NONE -> {
                    } //not connected


                }
                Constants.MESSAGE_WRITE -> {
                    // construct a string from the buffer
                    val writeBuf = msg.obj as ByteArray
                    val writeMessage = String(writeBuf)

                    // construct a string from the buffer
                    // construct a string from the buffer

                    //add message for me
                }
                Constants.MESSAGE_READ -> {
                    // construct a string from the valid bytes in the buffer
                    val readMessage = String(msg.obj as ByteArray, 0, msg.arg1)
                    //add message read
                }
                Constants.MESSAGE_DEVICE_NAME -> {
                    // save the connected device's name
                    mConnectedDeviceName =
                        msg.getData().getString(Constants.DEVICE_NAME)

                    Toast.makeText(
                        this@BluetoothChatActivity,
                        "Connected to $mConnectedDeviceName",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Constants.MESSAGE_TOAST -> {
                    Toast.makeText(
                        this@BluetoothChatActivity,
                        msg.getData().getString(Constants.TOAST),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

}