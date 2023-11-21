package com.yamz.administradordecontraseas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_AdministradorDeContraseñas)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}