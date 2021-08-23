package com.example.calculadoraimc

import android.widget.Toast

fun exibirImc(altura: Double, peso: Double): String {

    val imc = calcularImc(altura, peso).toString()
    return imc.substring(0, 4)

}