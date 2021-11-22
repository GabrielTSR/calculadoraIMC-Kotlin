package com.example.calculadoraimc.ui
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.calculadoraimc.R
import com.example.imc.utils.autenticar
import com.example.imc.utils.calcularIdade
import com.example.imc.utils.convertBase64ToBitmap

class DashBoardActivity : AppCompatActivity() {

    lateinit var tvNome : TextView
    lateinit var tvProfissao : TextView
    lateinit var tvImc : TextView
    lateinit var tvNcd : TextView
    lateinit var tvPeso : TextView
    lateinit var tvIdade : TextView
    lateinit var tvAltura : TextView
    lateinit var tvPerfil : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        tvNome = findViewById(R.id.tv_nome)
        tvProfissao = findViewById(R.id.tv_profissao)
        tvImc = findViewById(R.id.tv_dadoImc)
        tvNcd = findViewById(R.id.tv_dadoNCD)
        tvPeso = findViewById(R.id.tv_peso)
        tvIdade = findViewById(R.id.tv_idade)
        tvAltura = findViewById(R.id.tv_altura)
        tvPerfil = findViewById(R.id.iv_foto_perfil)
        val llPesarAgora = findViewById<LinearLayout>(R.id.ll_pesar_agora)

        llPesarAgora.setOnClickListener {
            val pesagem = Intent(this, PesagemActivity::class.java)
            startActivity(pesagem)
        }

        carregarDashboard()

    }

    private fun  carregarDashboard() {

        val arquivo = getSharedPreferences("usuario", Context.MODE_PRIVATE)

        tvNome.text = arquivo.getString("nome", "")
        tvProfissao.text = arquivo.getString("profissao", "")
        tvAltura.text = arquivo.getFloat("altura", 0.0f).toString()

        tvIdade.text = calcularIdade(arquivo.getString("dataNascimento", "").toString()).toString()

        val bitmap = convertBase64ToBitmap(arquivo.getString("fotoPerfil","")!!)
        tvPerfil.setImageBitmap(bitmap)


    }

}