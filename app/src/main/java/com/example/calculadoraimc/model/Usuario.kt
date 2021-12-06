package com.example.calculadoraimc.model

import java.time.LocalDate

data class Usuario(
    var id: Int,
    var nome:String,
    var email: String,
    var senha: String,
    var peso: String,
    var altura: Double,
    var dataRegistro: LocalDate,
    var profissao: String,
    var sexo: Char,
    var fotoPerfil: String
)