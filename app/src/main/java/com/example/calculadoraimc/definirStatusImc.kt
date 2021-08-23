package com.example.calculadoraimc

fun definirStatusImc(imc: Double):String {
    return when {
            imc < 18.5 -> "Abaixo do peso"
            imc <= 24.9 -> "Peso ideal!"
            imc <= 29.9 -> "Acima do peso"
            imc <= 34.9 -> "Obesidade grau I"
            imc <= 39.9 -> "Obesidade grau II"
        else -> "Obesidade grau III"
    }
}