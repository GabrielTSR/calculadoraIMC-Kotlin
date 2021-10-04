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

        supportActionBar!!.hide()

        val etAltura = findViewById<EditText>(R.id.edit_text_altura)
        val etPeso = findViewById<EditText>(R.id.edit_text_peso)
        val btnCalcularImc = findViewById<Button>(R.id.btnCalcular)
        var tvImc = findViewById<TextView>(R.id.text_view_numeroImc)
        var tvStatusImc = findViewById<TextView>(R.id.text_view_statusImc)

        btnCalcularImc.setOnClickListener {

            if ( etAltura.text.isEmpty() || etPeso.text.isEmpty()) {
                Toast.makeText(this, "ATENÇÃO. OS CAMPOS NÃO FORAM PREENCHIDOS CORRETAMENTE!", Toast.LENGTH_SHORT).show()
            } else {

                tvImc.text = exibirImc(etAltura.text.toString().toDouble(), etPeso.text.toString().toDouble())
                tvStatusImc.text = definirStatusImc(tvImc.text.toString().replace(",", ".").toDouble())
            }
        }
    }
}
