package com.example.taskandroid.LiveLocationKotlin

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.taskandroid.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class LiveLocationKotlin : AppCompatActivity(),
    OnMapReadyCallback, LocationListener {

    val REQUEST_CODE = 101
    var currentLocation: Location? = null
    private lateinit var mMap: GoogleMap
    lateinit var locationManager: LocationManager
    var fusedLocationProviderClient: FusedLocationProviderClient? = null
    private val locationPermissionCode = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_location_kotlin)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        fetchLocation()

    }

    private fun fetchLocation() {

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if ((ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED)
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                locationPermissionCode
            )
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5f, this)


        val task = fusedLocationProviderClient!!.lastLocation
        task.addOnSuccessListener { location ->
            if (location != null) {
                currentLocation = location
                val supportMapFragment =
                    (supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)
                supportMapFragment!!.getMapAsync(this@LiveLocationKotlin)

            }
        }
    }


    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val latLng = LatLng(currentLocation!!.latitude, currentLocation!!.longitude)
        val markerOptions = MarkerOptions().position(latLng).title("I Am Here!")
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
        googleMap.addMarker(markerOptions)


    }

    override fun onLocationChanged(p0: Location) {

        if (p0 != null) {
            val latLng = LatLng(
                p0.latitude, p0.longitude
            )
            mMap.animateCamera(CameraUpdateFactory.zoomTo(20f))
            mMap.addMarker(
                MarkerOptions().position(latLng).title("updated!")
            ) //marker title never updates
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 20f))
            Log.d("TAG", "onLocationChanged: ${latLng.latitude},${latLng.longitude}")
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE -> {
                if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLocation()
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}


