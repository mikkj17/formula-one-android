package com.example.formulaone.constructor.data

import com.example.formulaone.R

data class Constructor(
    val constructorId: String,
    val url: String,
    val name: String,
    val nationality: String,
) {
    fun getImage() = when (constructorId) {
        "alpine" -> R.drawable.alpine
        "aston_martin" -> R.drawable.aston_martin
        "ferrari" -> R.drawable.ferrari
        "haas" -> R.drawable.haas
        "mclaren" -> R.drawable.mclaren
        "mercedes" -> R.drawable.mercedes
        "rb" -> R.drawable.rb
        "red_bull" -> R.drawable.red_bull
        "sauber" -> R.drawable.sauber
        "williams" -> R.drawable.williams
        else -> R.drawable.f1_logo
    }
}
