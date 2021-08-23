package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener {
            val altura = findViewById<EditText>(R.id.altura).text.toString().replace(",", ".").toDouble()
            val peso = findViewById<EditText>(R.id.peso).text.toString().replace(",", ".").toDouble()
            val buttonCalcular = findViewById<Button>(R.id.buttonCalcular)
            var numeroImc = findViewById<TextView>(R.id.numeroImc)
            var statusImc = findViewById<TextView>(R.id.statusImc)

            numeroImc.text = exibirImc(altura, peso)
            statusImc.text = definirStatusImc(numeroImc.text.toString().toDouble())
        }
    }
}
