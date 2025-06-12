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

class LoginActivity : AppCompatActivity() {
    private lateinit var NetworkEditText1: EditText
    private lateinit var PasswordEditText1: EditText
    private lateinit var LoginButton1: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        NetworkEditText1 = findViewById(R.id.NetworkEdittext)
        PasswordEditText1 = findViewById(R.id.PasswordEdittext)
        LoginButton1 = findViewById(R.id.LoginButton)

      //  NetworkUtils.checkNetworkStatus(this) // Call network check


        LoginButton1.setOnClickListener {
            val network = NetworkEditText1.text.toString().trim()
            val password = PasswordEditText1.text.toString().trim()
            if (network.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "successful login", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter network and password", Toast.LENGTH_SHORT).show()
            }
        }
    }



}