package com.yamz.administradordecontraseas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.switchmaterial.SwitchMaterial
import kotlin.random.Random

class ThirdFragment : Fragment() {

    private lateinit var passwordEditText: EditText
    private lateinit var lengthEditText: EditText
    private lateinit var lowercaseSwitch: SwitchMaterial
    private lateinit var uppercaseSwitch: SwitchMaterial
    private lateinit var digitsSwitch: SwitchMaterial
    private lateinit var specialCharSwitch: SwitchMaterial
    private lateinit var excludeSwitch: SwitchMaterial

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_fourth, container, false)

        passwordEditText = myView.findViewById(R.id.password)
        lengthEditText = myView.findViewById(R.id.et_lenght)
        lowercaseSwitch = myView.findViewById(R.id.a_z)
        uppercaseSwitch = myView.findViewById(R.id.A_Z)
        digitsSwitch = myView.findViewById(R.id.zero_nine)
        specialCharSwitch = myView.findViewById(R.id.special_char)
        excludeSwitch = myView.findViewById(R.id.exclude)

        val generateButton = myView.findViewById<Button>(R.id.gen_password)

        generateButton.setOnClickListener {
            generatePassword()
        }

        val cancelButton = myView.findViewById<Button>(R.id.cancel)

        cancelButton.setOnClickListener() {

            val controller: NavController = Navigation.findNavController(myView)
            controller.navigate(R.id.action_fourthFragment_to_secondFragment)
        }

        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), R.color.almost_dark_blue)

        return myView
    }

    private fun generatePassword() {
        val lengthInput = lengthEditText.text.toString()

        val length = lengthInput.toIntOrNull()

        if (lengthInput.isBlank() || length == null || length !in 8..20) {
            lengthEditText.error = "Ingrese una longitud válida (8-20)"
            return
        }

        val includeLowercase = lowercaseSwitch.isChecked
        val includeUppercase = uppercaseSwitch.isChecked
        val includeDigits = digitsSwitch.isChecked
        val includeSpecialChar = specialCharSwitch.isChecked
        val excludeRepeatedChars = excludeSwitch.isChecked

        if (!includeLowercase && !includeUppercase && !includeDigits && !includeSpecialChar) {
            Toast.makeText(requireContext(), "Seleccione al menos una opción (diferente a excluir iguales)", Toast.LENGTH_SHORT).show()
            return
        }

        val password = generateRandomPassword(length, includeLowercase, includeUppercase, includeDigits, includeSpecialChar, excludeRepeatedChars)
        passwordEditText.setText(password)
    }


    private fun generateRandomPassword(
        length: Int,
        includeLowercase: Boolean,
        includeUppercase: Boolean,
        includeDigits: Boolean,
        includeSpecialChar: Boolean,
        excludeRepeatedChars: Boolean
    ): String {
        val lowercaseChars = "abcdefghijklmnopqrstuvwxyz"
        val uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val digits = "0123456789"
        val specialChars = "!@#$%^&*()_+-=[]{}|;':,.<>?/`~"
        val allChars = buildString {
            if (includeLowercase) append(lowercaseChars)
            if (includeUppercase) append(uppercaseChars)
            if (includeDigits) append(digits)
            if (includeSpecialChar) append(specialChars)
        }

        var password = buildString {
            for (i in 1..length) {
                val randomChar = allChars.random()
                if (excludeRepeatedChars && this@buildString.contains(randomChar)) {
                    // Evitar caracteres repetidos si es necesario
                    continue
                }
                append(randomChar)
            }
        }

        // Asegurarse de que se incluyan al menos un tipo de cada carácter seleccionado
        if (includeLowercase && password.none { it in lowercaseChars }) {
            password = password.replaceFirstChar { lowercaseChars.random() }
        }
        if (includeUppercase && password.none { it in uppercaseChars }) {
            password = password.replaceFirstChar { uppercaseChars.random() }
        }
        if (includeDigits && password.none { it in digits }) {
            password = password.replaceFirstChar { digits.random() }
        }
        if (includeSpecialChar && password.none { it in specialChars }) {
            password = password.replaceFirstChar { specialChars.random() }
        }

        return password
    }
}