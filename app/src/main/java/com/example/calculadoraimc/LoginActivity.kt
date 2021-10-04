package com.example.calculadoraimc

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val tvLinkCadastro = findViewById<TextView>(R.id.tv_linkParaCadastro)
        tvLinkCadastro.setOnClickListener {
            val abrirDatePickerActivity = Intent(this, DatePickerDialog::class.java)

            startActivity(abrirDatePickerActivity)
        }
    }
}