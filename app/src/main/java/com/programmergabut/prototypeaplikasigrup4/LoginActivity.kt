package com.programmergabut.prototypeaplikasigrup4

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

const val ID_PASSWORD = "admin"

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setListener()
    }

    private fun setListener() {
        btn_login.setOnClickListener {

            if(et_username.text.toString().toLowerCase(Locale.ROOT).trim() == ID_PASSWORD.toLowerCase(Locale.ROOT) &&
                et_password.text.toString().toLowerCase(Locale.ROOT).trim() == ID_PASSWORD.toLowerCase(Locale.ROOT)){
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }
            else if(et_username.text.toString().isEmpty() || et_password.text.toString().isEmpty()){
                showBottomSheet("Error", "username or password cannot be empty")
            }
            else
                showBottomSheet("User not found", "username or password is incorrect")

        }
        btn_register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }


}