package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*
import kotlinx.android.synthetic.main.activity_maps.*

private val centerArea = LatLng(-6.6055, 106.81062)

class MapsActivity : AppCompatActivity() {

    private var map: GoogleMap? = null
    private val zoomLevel = 20.2f

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

        val polyGone1 = map.addPolygon(PolygonOptions()
                .clickable(true)
                .add(LatLng(-6.60555, 106.81070),
                    LatLng(-6.60550, 106.81075),
                    LatLng(-6.60545, 106.81070),
                    LatLng(-6.60550, 106.81065))
        )

        polyGone1.strokeColor = ContextCompat.getColor(this, R.color.orange_900)
        polyGone1.fillColor = ContextCompat.getColor(this, R.color.orange_500_trans)
        polyGone1.tag = "1"

        val polyGone2 = map.addPolygon(PolygonOptions()
            .clickable(true)
            .add(LatLng(-6.60572, 106.81073),
                LatLng(-6.60567, 106.81078),
                LatLng(-6.60562, 106.81073),
                LatLng(-6.60567, 106.81068))
        )

        polyGone2.strokeColor = ContextCompat.getColor(this, R.color.green_700)
        polyGone2.fillColor = ContextCompat.getColor(this, R.color.green_500_trans)
        polyGone2.tag = "2"

        val polyGone3 = map.addPolygon(PolygonOptions()
            .clickable(true)
            .add(LatLng(-6.60545, 106.81050),
                LatLng(-6.60540, 106.81055),
                LatLng(-6.60535, 106.81050),
                LatLng(-6.60540, 106.81045))
        )

        polyGone3.strokeColor = ContextCompat.getColor(this, R.color.red_700)
        polyGone3.fillColor = ContextCompat.getColor(this, R.color.red_500_trans)
        polyGone3.tag = "3"

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(centerArea, zoomLevel))
        map.setOnPolygonClickListener{

            when(it.tag){
                "1" -> {
                    val intent = Intent(this, Store1Activity::class.java)
                    startActivity(intent)
                }
                "2" -> {
                    val intent = Intent(this, Store2Activity::class.java)
                    startActivity(intent)
                }
                "3" -> {
                    val intent = Intent(this, Store3Activity::class.java)
                    startActivity(intent)
                }
            }


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