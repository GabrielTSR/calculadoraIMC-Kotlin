package com.example.calculadoraimc

fun calcularImc(altura: Double, peso: Double):Double {
    return peso / (altura * altura)
}