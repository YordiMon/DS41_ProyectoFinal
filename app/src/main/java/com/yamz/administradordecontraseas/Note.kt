package com.yamz.administradordecontraseas

import android.os.Parcelable

data class Note(
    val id: Int,
    val name: String,
    val user: String,
    val email: String,
    val password: String,
    val url: String,
    val icon: String
)
