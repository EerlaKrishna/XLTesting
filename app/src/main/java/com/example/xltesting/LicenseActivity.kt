package com.example.xltesting

import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.isDigitsOnly
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LicenseActivity : AppCompatActivity() {

    private lateinit var licenseEditText1: EditText
    private lateinit var licenseButton1: Button

    companion object {
        private const val LICENSE_DETAILS_COUNT = 6
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_license)
        licenseEditText1 = findViewById(R.id.licenseEditText)
        licenseButton1 = findViewById(R.id.LicenseButton)

        //NetworkUtils.checkNetworkStatus(this) // Call network check

        licenseButton1.setOnClickListener {
            validateLicense()
        }




    }

    private fun validateLicense() {
        val license = licenseEditText1.text.toString().trim()

        if (license.length > 15) {
            val licenseArrayList = license.split(":")

            if (licenseArrayList.size == LICENSE_DETAILS_COUNT && licenseArrayList.getOrNull(2)?.isDigitsOnly() == true) {
                // Proceed with valid license
                Toast.makeText(this, "License Validated", Toast.LENGTH_SHORT).show()
                val intent= Intent(this,LoginActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a valid license", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter  valid license", Toast.LENGTH_SHORT).show()
        }

    }

}