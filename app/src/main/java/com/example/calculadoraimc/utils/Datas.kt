package com.example.calculadoraimc.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun converteStringToLocalDate(brazilDate: String) : LocalDate{
    val dateFormatterFromBrazil = DateTimeFormatter.ofPattern("dd/MM/yyyy")

    return LocalDate.parse(brazilDate, dateFormatterFromBrazil)
}