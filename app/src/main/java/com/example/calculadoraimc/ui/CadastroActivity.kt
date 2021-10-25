package com.example.calculadoraimc.ui

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.example.calculadoraimc.R
import com.example.calculadoraimc.model.Usuario
import com.example.calculadoraimc.utils.converteStringToLocalDate
import java.time.LocalDate
import java.util.*

class CadastroActivity : AppCompatActivity() {

    lateinit var etEmail : EditText
    lateinit var etSenha : EditText
    lateinit var etNome : EditText
    lateinit var etProfissao : EditText
    lateinit var etAltura : EditText
    lateinit var etDataNascimento : EditText
    lateinit var rgGenero : RadioGroup
    lateinit var rbMasculino : RadioButton
    lateinit var rbFeminino : RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        etEmail = findViewById(R.id.edit_email)
        etSenha = findViewById(R.id.edit_senha)
        etNome = findViewById(R.id.edit_nome)
        etProfissao = findViewById(R.id.edit_profissao)
        etAltura = findViewById(R.id.edit_altura)
        etDataNascimento = findViewById(R.id.et_data_nascimento)
        rgGenero = findViewById(R.id.radioGroupGenero)
        rbMasculino = findViewById(R.id.radioButtonMasculino)
        rbFeminino = findViewById(R.id.radioButtonFeminino)

        //Menu da atividade
        supportActionBar!!.title = "Novo usuário"

        //calendario
        //Criar um calendário
        val calendario = Calendar.getInstance()

        // Determinar os dados (dia, mês, e ano) do calendário
        val ano = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        // Abrir o componente DatePicker

        etDataNascimento.setOnClickListener {
            val dp = DatePickerDialog(this,
                DatePickerDialog.OnDateSetListener{ view, _ano, _mes, _dia ->
                    etDataNascimento.setText("$_dia/${_mes + 1}/$_ano")
                }, ano, mes, dia)
            dp.show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (validarCampos()){
            //Criar o objeto usuário
                val nascimento = converteStringToLocalDate(etDataNascimento.text.toString())

                val usuario = Usuario(
                    1,
                    etNome.text.toString(),
                    etEmail.text.toString(),
                    etSenha.text.toString(),
                    0,
                    etAltura.text.toString().toDouble(),
                    LocalDate.of(
                        nascimento.year,
                        nascimento.month,
                        nascimento.dayOfMonth
                    ),
                    etProfissao.text.toString(),
                    if (rbFeminino.isChecked) 'F' else 'M'
                )

            /*Salvar o registro
            Em um SharedPreferences

            A instrução abaixo irá criar um
            arquivo SharedPreferences se não existir
            Se existir, ele será aberto para edição*/
            val dados = getSharedPreferences("usuario", Context.MODE_PRIVATE)

            //Vamos criar o objeto que permitirá a
            //edição dos dados do arquivo SharedPreferences
            val editor = dados.edit()
            editor.putInt("id", usuario.id)
            editor.putString("nome", usuario.nome)
            editor.putString("email", usuario.email)
            editor.putString("senha", usuario.senha)
            editor.putInt("peso", usuario.peso)
            editor.putFloat("altura", usuario.altura.toFloat())
            editor.putString("dataNascimento", usuario.dataNascimento.toString())
            editor.putString("profissao", usuario.profissao)
            editor.putString("sexo", usuario.sexo.toString())
            editor.apply()
        }

        Toast.makeText(this, "Usuário cadastrado!", Toast.LENGTH_SHORT).show()

        return true
    }

    fun validarCampos():Boolean{
        var eValido = true

        if(etEmail.text.isEmpty()){
            etEmail.error = "O e-mail é obrigatório!"
            eValido = false
        }

        if(etSenha.text.isEmpty()){
            etSenha.error = "A senha é obrigatória!"
            eValido = false
        }

        if(etNome.text.isEmpty()){
            etNome.error = "O nome é obrigatório!"
            eValido = false
        }

        if(etProfissao.text.isEmpty()){
            etProfissao.error = "A profissão é obrigatória!"
            eValido = false
        }

        if(etAltura.text.isEmpty()){
            etAltura.error = "A altura é obrigatória!"
            eValido = false
        }

        if(etDataNascimento.text.isEmpty()){
            etDataNascimento.error = "A data de nascimento é obrigatória!"
            eValido = false
        }

        if(!rbMasculino.isChecked && !rbFeminino.isChecked){
            rbMasculino.error = "O gênero é obrigatório!"
            eValido = false
        }

        return eValido
    }
}