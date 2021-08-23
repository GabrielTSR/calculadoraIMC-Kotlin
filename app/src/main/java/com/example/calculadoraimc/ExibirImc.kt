package com.example.calculadoraimc

import android.widget.Toast

fun exibirImc(altura: Double, peso: Double): String {


//forma utilizada antes
//    val imc = calcularImc(altura, peso).toString()
//    return imc.substring(0, 4)

    val imc = calcularImc(altura, peso)
    return String.format("%.1f", imc)

}