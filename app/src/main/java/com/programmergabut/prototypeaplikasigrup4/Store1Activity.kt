package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import android.os.Bundle
import com.programmergabut.prototypeaplikasigrup4.ReservationActivity.Companion.PLACE_MSG
import com.programmergabut.prototypeaplikasigrup4.ReservationActivity.Companion.PLACE_NAME
import kotlinx.android.synthetic.main.activity_reservation.*
import kotlinx.android.synthetic.main.activity_store1.*
import kotlinx.android.synthetic.main.activity_store1.btn_reserve
import kotlinx.android.synthetic.main.activity_store1.ic_back

class Store1Activity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store1)

        setListener()
    }


    private fun setListener(){
        btn_reserve.setOnClickListener{
            val intent = Intent(this, ReservationActivity::class.java)
            intent.putExtra(PLACE_NAME, "POPOLO COFFEE")
            intent.putExtra(PLACE_MSG, "Don't stay too long!")
            startActivity(intent)
        }

        ic_back.setOnClickListener{
            finish()
        }
    }
}