package com.example.calculadoraimc.utils

import android.content.Context

fun calcularImc(context : Context):Double {

    val arquivo = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    val pesoAtual = arquivo.getString("pesagem", "").split(";").toTypedArray().last().toInt()

    val altura = arquivo.getFloat("altura", 0.0f)

    return pesoAtual / (altura * altura).toDouble()
}