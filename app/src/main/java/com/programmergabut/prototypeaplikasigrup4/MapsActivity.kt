package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import kotlinx.android.synthetic.main.activity_main.*

private val indonesiaLatLang = LatLng(-6.6055, 106.8107)

class MainActivity : AppCompatActivity() {

    private var map: GoogleMap? = null
    private val zoomLevel = 24f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync {
            map = it
            animateCamera()
            map?.setOnMapClickListener {
                val intent = Intent(this, StoreActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun animateCamera() {
        map?.animateCamera(
            CameraUpdateFactory.newLatLngZoom(indonesiaLatLang, zoomLevel)
        )
    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onStart() {
        super.onStart()
        mapView?.onStart()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }

}