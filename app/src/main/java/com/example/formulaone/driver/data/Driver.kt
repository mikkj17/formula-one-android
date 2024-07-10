package com.example.formulaone.driver.data

import com.example.formulaone.R
import java.time.LocalDate

data class Driver(
    val driverId: String,
    val permanentNumber: Int,
    val code: String,
    val url: String,
    val givenName: String,
    val familyName: String,
    val dateOfBirth: String,
    val nationality: String,
) {
    fun getDateOfBirth() = LocalDate.parse(dateOfBirth)

    fun getImage(): Int = when (driverId) {
        "albon" -> R.drawable.albon
        "alonso" -> R.drawable.alonso
        "bearman" -> R.drawable.bearman
        "bottas" -> R.drawable.bottas
        "gasly" -> R.drawable.gasly
        "hamilton" -> R.drawable.hamilton
        "hulkenberg" -> R.drawable.hulkenberg
        "kevin_magnussen" -> R.drawable.magnussen
        "leclerc" -> R.drawable.leclerc
        "max_verstappen" -> R.drawable.verstappen
        "norris" -> R.drawable.norris
        "ocon" -> R.drawable.ocon
        "perez" -> R.drawable.perez
        "piastri" -> R.drawable.piastri
        "ricciardo" -> R.drawable.ricciardo
        "russell" -> R.drawable.russell
        "sainz" -> R.drawable.sainz
        "sargeant" -> R.drawable.sargeant
        "stroll" -> R.drawable.stroll
        "tsunoda" -> R.drawable.tsunoda
        "zhou" -> R.drawable.zhou
        else -> R.drawable.f1_logo
    }
}
