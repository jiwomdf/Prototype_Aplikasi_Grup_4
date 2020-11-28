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
            setListener(it)
        }

    }

    private fun addPolyLine(map: GoogleMap) {

        /* kiri gede -> dia ke kanan nyerong bawah
        * kanan gede -> kanan nyerong bawah
        */

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


        val polyGone4 = map.addPolygon(PolygonOptions()
                .clickable(true)
                .add(LatLng(-6.60580, 106.81060),
                        LatLng(-6.60575, 106.81065),
                        LatLng(-6.60570, 106.81060),
                        LatLng(-6.60575, 106.81055))
        )

        polyGone4.strokeColor = ContextCompat.getColor(this, R.color.red_700)
        polyGone4.fillColor = ContextCompat.getColor(this, R.color.red_500_trans)


        val polyGone5 = map.addPolygon(PolygonOptions()
                .clickable(true)
                .add(LatLng(-6.60563, 106.81050),
                        LatLng(-6.60558, 106.81055),
                        LatLng(-6.60553, 106.81050),
                        LatLng(-6.60558, 106.81045))
        )

        polyGone5.strokeColor = ContextCompat.getColor(this, R.color.green_700)
        polyGone5.fillColor = ContextCompat.getColor(this, R.color.green_500_trans)

        val polyGone6 = map.addPolygon(PolygonOptions()
                .clickable(true)
                .add(LatLng(-6.60557, 106.81060),
                        LatLng(-6.60552, 106.81065),
                        LatLng(-6.60547, 106.81060),
                        LatLng(-6.60552, 106.81055))

        )

        polyGone6.strokeColor = ContextCompat.getColor(this, R.color.green_700)
        polyGone6.fillColor = ContextCompat.getColor(this, R.color.green_500_trans)

        val polyGone7 = map.addPolygon(PolygonOptions()
                .clickable(true)
                .add(LatLng(-6.60543, 106.81073),
                        LatLng(-6.60538, 106.81078),
                        LatLng(-6.60533, 106.81073),
                        LatLng(-6.60538, 106.81068))

        )

        polyGone7.strokeColor = ContextCompat.getColor(this, R.color.green_700)
        polyGone7.fillColor = ContextCompat.getColor(this, R.color.green_500_trans)


        val polyGone8 = map.addPolygon(PolygonOptions()
                .clickable(true)
                .add(LatLng(-6.60566, 106.81063),
                        LatLng(-6.60561, 106.81068),
                        LatLng(-6.60556, 106.81063),
                        LatLng(-6.60561, 106.81058))
        )

        polyGone8.strokeColor = ContextCompat.getColor(this, R.color.orange_700)
        polyGone8.fillColor = ContextCompat.getColor(this, R.color.orange_500_trans)

    }

    private fun setListener(map: GoogleMap) {
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