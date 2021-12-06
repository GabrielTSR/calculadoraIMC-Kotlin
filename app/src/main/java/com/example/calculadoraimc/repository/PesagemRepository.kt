package com.example.calculadoraimc.repository


import android.content.Context
import com.example.calculadoraimc.model.Pesagem

class PesagemRepository(var context: Context) {
    fun getListaPesagem(): List<Pesagem>{
        val listaPesagem = mutableListOf<Pesagem>()


        // Preencher a lista de pesagem
        val dados = context.getSharedPreferences("usuario",
            Context.MODE_PRIVATE)


        val pesosString = dados.getString("pesagem", "")
        val pesos = pesosString!!.split(";").toTypedArray()

        val datasString = dados.getString("data_pesagem", "")
        val datas = datasString!!.split(";").toTypedArray()

        for (i in pesos.indices){

            val pesagem = Pesagem(datas[i], pesos[i].toInt())
            listaPesagem.add(pesagem)

        }

        return listaPesagem
    }
}