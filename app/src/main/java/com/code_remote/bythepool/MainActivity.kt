package com.code_remote.bythepool

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!isRequestPermissionsNeeded()) {
            startActivity(Intent(this, BluetoothScanActivity::class.java))
            finish()
        }
    }

    private fun isRequestPermissionsNeeded(): Boolean {
        for (permission in PERMISSIONS) {
            if (checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS,
                    REQ_PERMISSIONS
                )
                return true
            }
        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (REQ_PERMISSIONS_WRITE_SETTINGS == requestCode) {
            recreate()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (REQ_PERMISSIONS == requestCode ||
            REQ_PERMISSIONS_WRITE_SETTINGS == requestCode
        ) {
            recreate()
        }
    }

    companion object {
        private const val REQ_PERMISSIONS = 1337
        private const val REQ_PERMISSIONS_WRITE_SETTINGS = 1338

        private val PERMISSIONS = mutableListOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN

        ).run {
            this.toTypedArray()
        }
    }


}