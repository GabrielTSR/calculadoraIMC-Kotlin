package com.example.calculadoraimc.ui
import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadoraimc.R
import com.example.imc.utils.getDataAtualBrasil
import java.time.LocalDate

class PesagemActivity : AppCompatActivity() {

    lateinit var tvDataPesagem: TextView
    lateinit var etNovoPeso: EditText
    lateinit var spinnerNivel: Spinner
    lateinit var btnRegistrarPeso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesagem)
        supportActionBar!!.hide()

        tvDataPesagem = findViewById(R.id.tv_data_pesagem)
        etNovoPeso = findViewById(R .id.etNovoPeso)
        spinnerNivel = findViewById(R .id.spinner_niveis)
        btnRegistrarPeso = findViewById(R .id.btn_salvar)

        tvDataPesagem.text = getDataAtualBrasil()

        btnRegistrarPeso.setOnClickListener {
           val arquivo = getSharedPreferences("usuario", MODE_PRIVATE)
            val pesagem = arquivo.getString("peso", "")
            val dataPesagem = arquivo.getString("data_registro", "")
            val nivel = arquivo.getString("nivel", "")

            val editor = arquivo.edit()
            editor.putString("peso", "$pesagem;${etNovoPeso.text.toString()}")
            editor.putString("data_registro", "$dataPesagem;${LocalDate.now().toString()}")
            editor.putString("nivel", "$nivel;${spinnerNivel.selectedItemPosition.toString()}")
            editor.apply()
            Toast.makeText(this, "Peso registrado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}