package com.example.xltesting

import android.app.Application
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.widget.Toast

class NetworkUtils : Application() {
    private var networkCallback: ConnectivityManager.NetworkCallback? = null
    private var hasShownToast = false  // Prevents repeated toast messages

    override fun onCreate() {
        super.onCreate()
        checkInitialNetworkStatus() // Check network status when app starts
        registerNetworkCallback()
    }

    private fun checkInitialNetworkStatus() {
        val connectivityManager = getSystemService(ConnectivityManager::class.java)
        val network = connectivityManager.activeNetwork
        val networkCapabilities = connectivityManager.getNetworkCapabilities(network)

        val isConnected = networkCapabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) == true

        if (!isConnected) {  // Show toast only if network is OFF at launch
            showToastOnce("Mobile Network is OFF")
        }
    }

    private fun registerNetworkCallback() {
        val connectivityManager = getSystemService(ConnectivityManager::class.java)

        val networkRequest = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()

        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onLost(network: Network) {
                showToastOnce("Mobile Network is OFF")  // Show only when network is lost
            }

            override fun onAvailable(network: Network) {
                hasShownToast = false  // Reset when network returns
            }
        }

        connectivityManager.registerNetworkCallback(networkRequest, networkCallback!!)
    }

    private fun showToastOnce(message: String) {
        if (!hasShownToast) {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
            hasShownToast = true  // Prevents repeating the toast
        }
    }
}
