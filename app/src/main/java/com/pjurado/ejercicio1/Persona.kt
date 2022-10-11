package com.pjurado.ejercicio1

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Persona(
    val nombre: String,
    val telefono: String,
    val email: String,
    val urlFoto: String
): Parcelable
