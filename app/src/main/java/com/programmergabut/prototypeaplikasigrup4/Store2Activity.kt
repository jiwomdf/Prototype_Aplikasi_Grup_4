package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.programmergabut.prototypeaplikasigrup4.ReservationActivity.Companion.PLACE_MSG
import com.programmergabut.prototypeaplikasigrup4.ReservationActivity.Companion.PLACE_NAME
import kotlinx.android.synthetic.main.activity_reservation.*
import kotlinx.android.synthetic.main.activity_store1.*
import kotlinx.android.synthetic.main.activity_store1.btn_reserve
import kotlinx.android.synthetic.main.activity_store1.ic_back

class Store2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store2)
        setListener()
    }


    private fun setListener(){
        btn_reserve.setOnClickListener{
            val intent = Intent(this, ReservationActivity::class.java)
            intent.putExtra(PLACE_NAME, "SALAD KALE")
            intent.putExtra(PLACE_MSG, "Reserve soon!")
            startActivity(intent)
        }

        ic_back.setOnClickListener{
            finish()
        }
    }
}