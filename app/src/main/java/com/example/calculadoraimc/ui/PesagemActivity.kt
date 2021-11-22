package com.example.calculadoraimc.ui
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.R

class PesagemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)

        val editPeso = findViewById<EditText>(R.id.et_peso)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)

        btnSalvar.setOnClickListener {

        }
    }
}