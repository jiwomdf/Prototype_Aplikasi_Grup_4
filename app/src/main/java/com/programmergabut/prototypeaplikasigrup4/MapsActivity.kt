package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*

private val popoloCoffeeLatLng = LatLng(-6.6055, 106.8107)

class MapsActivity : AppCompatActivity() {

    private var map: GoogleMap? = null
    private val zoomLevel = 22f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync {
            map = it
            /*animateCamera()*/
            addPolyLine(it)
        }

    }

    private fun addPolyLine(map: GoogleMap) {

        val polyGone = map.addPolygon(PolygonOptions()
                .clickable(true)
                .add(LatLng(-6.60555, 106.81070),
                        LatLng(-6.60550, 106.81075),
                        LatLng(-6.60545, 106.81070),
                        LatLng(-6.60550, 106.81065))
        )

        polyGone.strokeColor = ContextCompat.getColor(this, R.color.red_700)
        polyGone.fillColor = ContextCompat.getColor(this, R.color.red_500_trans)

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(popoloCoffeeLatLng, zoomLevel))
        map.setOnPolygonClickListener{
            val intent = Intent(this, StoreActivity::class.java)
            startActivity(intent)
        }

    }

    /* private fun animateCamera() {
        map?.animateCamera(
            CameraUpdateFactory.newLatLngZoom(popoloCoffeeLatLng, zoomLevel)
        )
    } */

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