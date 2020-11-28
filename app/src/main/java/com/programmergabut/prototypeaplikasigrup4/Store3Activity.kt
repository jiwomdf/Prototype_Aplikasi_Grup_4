package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.programmergabut.prototypeaplikasigrup4.ReservationActivity.Companion.PLACE_MSG
import com.programmergabut.prototypeaplikasigrup4.ReservationActivity.Companion.PLACE_NAME
import kotlinx.android.synthetic.main.activity_reservation.*
import kotlinx.android.synthetic.main.activity_store1.*
import kotlinx.android.synthetic.main.activity_store1.btn_reserve
import kotlinx.android.synthetic.main.activity_store1.ic_back

class Store3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store3)

        setListener()
    }


    private fun setListener(){
        btn_reserve.setOnClickListener{
            val intent = Intent(this, ReservationActivity::class.java)
            intent.putExtra(PLACE_NAME, "SERIBU PAGI COFFEE")
            intent.putExtra(PLACE_MSG, "Stay healthy!")
            startActivity(intent)
        }

        ic_back.setOnClickListener{
            finish()
        }
    }
}