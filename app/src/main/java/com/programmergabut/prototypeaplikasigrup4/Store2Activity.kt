package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_store1.*

class Store2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store2)
        setListener()
    }


    private fun setListener(){
        btn_reserve.setOnClickListener{
            val intent = Intent(this, ReservationActivity::class.java)
            intent.putExtra(ReservationActivity.PLACE_NAME, "SALAD KALE")
            startActivity(intent)
        }
    }
}