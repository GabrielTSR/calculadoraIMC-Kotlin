package com.example.imc.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

fun convertStringToLocalDate(brazilDate: String) : LocalDate {

    val dateFormatterFromBrazil = DateTimeFormatter
        .ofPattern("dd/MM/yyyy")

    val localDateFormat = LocalDate
        .parse(brazilDate, dateFormatterFromBrazil)

    return localDateFormat

}

fun calcularIdade(dataNascimento: String): Int {

    //Obter a data atual (hoje)
    val hoje = LocalDate.now()

    val nascimento = LocalDate.parse(dataNascimento)

    return Period.between(nascimento, hoje).years

}

fun getDataAtualBrasil():String{
    val hoje = LocalDate.now()

    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return hoje.format(formatter)
}

fun converterLocalDateEmDataBrasil(data:LocalDate):String{
    return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
    //"${data.dayOfYear}/${data.month}/${data.year}"
}

