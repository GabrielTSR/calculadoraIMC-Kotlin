package com.example.calculadoraimc.utils

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun convertBitmapToBase64(bitmap: Bitmap): String {
    val bitMapArray = ByteArrayOutputStream()

    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bitMapArray)

    return Base64.encodeToString(bitMapArray.toByteArray(), Base64.DEFAULT)

}