package com.programmergabut.prototypeaplikasigrup4

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity(), TextWatcher {

    private var arrValidation = arrayOf(false, false, false, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        setListener()
    }

    private fun setListener() {
        btn_do_register.setOnClickListener{
            showBottomSheet("Account Created", "your account is successfully created",
                    "back to login screen", isCancelable = false, isFinish = true)
        }

        et_username.addTextChangedListener(this)
        et_email.addTextChangedListener(this)
        et_password.addTextChangedListener(this)
        et_password_confirm.addTextChangedListener(this)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

    override fun afterTextChanged(s: Editable?) {
        when(s.hashCode()){
            et_username.text.hashCode() -> validateInput(et_username.text.hashCode())
            et_email.text.hashCode() -> validateInput(et_email.text.hashCode())
            et_password.text.hashCode() -> validateInput(et_password.text.hashCode())
            et_password_confirm.text.hashCode() -> validateInput(et_password_confirm.text.hashCode())
        }
    }

    private fun validateInput(hashCode: Int){
        when(hashCode){
            et_username.text.hashCode() -> {
                if (et_username.text.toString().length < 2) {
                    et_username.error = "username is less than 2"
                    arrValidation[0] = false
                } else
                    arrValidation[0] = true
            }
            et_email.text.hashCode() -> {
                if (et_email.text.toString().length < 2) {
                    et_email.error = "email is less than 2"
                    arrValidation[1] = false
                }
                else if(!et_email.text.toString().contains("@")){
                    et_email.error = "email must have @"
                    arrValidation[1] = false
                }
                else
                    arrValidation[1] = true
            }
            et_password.text.hashCode() -> {
                if (et_password.text.toString().isEmpty()) {
                    et_password.error = "password cannot be empty"
                    arrValidation[2] = false
                } else
                    arrValidation[2] = true
            }
            et_password_confirm.text.hashCode() -> {
                if (et_password_confirm.text.toString().isEmpty()) {
                    et_password_confirm.error = "confirm password cannot be empty"
                    arrValidation[3] = false
                }
                else
                    arrValidation[3] = true
            }
        }

        if(arrValidation.contains(false)){
            btn_do_register.isEnabled = false
            btn_do_register.setBackgroundColor(ContextCompat.getColor(this, R.color.grey))
        }
        else{
            btn_do_register.isEnabled = true
            btn_do_register.setBackgroundColor(ContextCompat.getColor(this, R.color.blue_900))
        }

    }


}