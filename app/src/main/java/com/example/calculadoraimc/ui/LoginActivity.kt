package com.example.calculadoraimc.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.calculadoraimc.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar!!.hide()

        val tvLinkCadastro = findViewById<TextView>(R.id.tv_linkParaCadastro)

        tvLinkCadastro.setOnClickListener {
            val abrirCadastroActivity = Intent(this, CadastroActivity::class.java)

            startActivity(abrirCadastroActivity)
        }
    }
}