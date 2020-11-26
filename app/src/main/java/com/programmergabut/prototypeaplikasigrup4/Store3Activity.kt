package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_store1.*

class Store3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store3)

        setListener()
    }


    private fun setListener(){
        btn_reserve.setOnClickListener{
            val intent = Intent(this, ReservationActivity::class.java)
            intent.putExtra(ReservationActivity.PLACE_NAME, "SERIBU PAGI COFFEE")
            startActivity(intent)
        }
    }
}