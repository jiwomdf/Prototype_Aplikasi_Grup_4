package com.programmergabut.prototypeaplikasigrup4

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_reservation.*
import java.text.SimpleDateFormat
import java.util.*


class ReservationActivity : BaseActivity(), TextWatcher {

    private var arrValidation = arrayOf(false, false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservation)

        setListener()
    }

    private fun setListener() {

        et_name.addTextChangedListener(this)
        et_phoneNumber.addTextChangedListener(this)
        et_numberGuest.addTextChangedListener(this)
        et_date.addTextChangedListener(this)
        et_time.addTextChangedListener(this)

        ic_back.setOnClickListener{
            finish()
        }
        btn_reserve.setOnClickListener{
            Toast.makeText(this, "Reservation created!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MapsActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        et_date.setOnClickListener{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                setDate(et_date)
            }
            else{
                /* Bug Here */
            }
        }
        et_time.setOnClickListener {
            setHours(et_time)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setDate(editText: EditText){
        val myCalendar = Calendar.getInstance();

        val date = OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            myCalendar.set(Calendar.YEAR, year)
            myCalendar.set(Calendar.MONTH, monthOfYear)
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd/MM/yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.US)

            editText.setText(sdf.format(myCalendar.time))
        }

        DatePickerDialog(this,
                date,
                myCalendar.get(Calendar.YEAR),
                myCalendar.get(Calendar.MONTH),
                myCalendar.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun setHours(editText: EditText) {

        val cal = Calendar.getInstance()
        val timeSetListener = TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            cal.apply {
                set(Calendar.HOUR_OF_DAY, hour)
                set(Calendar.MINUTE, minute)
            }
            val hourMinute = SimpleDateFormat("HH:mm", Locale.getDefault()).format(cal.time)
            editText.setText(hourMinute)
        }

        /*var datePickerThemeResId = 0
        if (Build.VERSION.SDK_INT >= 21) {
             datePickerThemeResId = AlertDialog.THEME_HOLO_LIGHT
        }*/
        var timePickerDialog: TimePickerDialog
        try {
            timePickerDialog = TimePickerDialog(this, 0, timeSetListener,
                    0, 0, true)
        }
        catch (e: Exception){
            timePickerDialog = TimePickerDialog(this, 0, timeSetListener,
                    0, 0, true)
        }

        timePickerDialog.show()
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        when(s.hashCode()){
            et_name.text.hashCode() -> validateInput(et_name.text.hashCode())
            et_phoneNumber.text.hashCode() -> validateInput(et_phoneNumber.text.hashCode())
            et_numberGuest.text.hashCode() -> validateInput(et_numberGuest.text.hashCode())
            et_date.text.hashCode() -> validateInput(et_date.text.hashCode())
            et_time.text.hashCode() -> validateInput(et_time.text.hashCode())
        }
    }

    private fun validateInput(hashCode: Int){
        when(hashCode){
            et_name.text.hashCode() -> {
                if (et_name.text.toString().length < 2) {
                    et_name.error = "your name is less than 2"
                    arrValidation[0] = false
                } else
                    arrValidation[0] = true
            }
            et_phoneNumber.text.hashCode() -> {
                if (et_phoneNumber.text.toString().length < 9) {
                    et_phoneNumber.error = "your phone number is less than 9"
                    arrValidation[1] = false
                } else
                    arrValidation[1] = true
            }
            et_numberGuest.text.hashCode() -> {
                if (et_numberGuest.text.toString().isEmpty()) {
                    et_numberGuest.error = "guest cannot be zero"
                    arrValidation[2] = false
                } else
                    arrValidation[2] = true
            }
            et_date.text.hashCode() -> {
                if (et_date.text.toString().isEmpty()) {
                    et_date.error = "date cannot be empty"
                    arrValidation[3] = false
                } else
                    arrValidation[3] = true
            }
            et_time.text.hashCode() -> {
                if (et_time.text.toString().isEmpty()) {
                    et_time.error = "time cannot be empty"
                    arrValidation[4] = false
                } else
                    arrValidation[4] = true
            }
        }

        if(arrValidation.contains(false)){
            btn_reserve.isEnabled = false
            btn_reserve.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
        }
        else{
            btn_reserve.isEnabled = true
            btn_reserve.setBackgroundColor(ContextCompat.getColor(this, R.color.red_500))
        }

    }

}