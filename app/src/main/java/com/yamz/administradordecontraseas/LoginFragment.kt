package com.yamz.administradordecontraseas

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation

class LoginFragment : Fragment() {

    private var users: List<User> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_first, container, false)

        val enter = myView.findViewById<Button>(R.id.enter)
        val cancel = myView.findViewById<Button>(R.id.cancel)
        val user = myView.findViewById<EditText>(R.id.user)
        val password = myView.findViewById<EditText>(R.id.password)
        password.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        password.setTypeface(Typeface.DEFAULT)

        cancel.setOnClickListener() {
            requireActivity().finish()
        }

        enter.setOnClickListener() {
            validUsers()

            if (user.text != null && password.text != null) {
                var user = user.text.toString()
                var psw = password.text.toString()

                if(checkUser(user, psw, users)) {

                    val i = Intent(myView.context, MainActivity::class.java)
                    startActivity(i)
                    activity?.finish()

                } else {
                    Toast.makeText(context, "Las credenciales no coinciden", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(context, "Los campos no deben estar vacíos.", Toast.LENGTH_SHORT).show()
            }
        }

        return myView
    }

    private fun checkUser(username: String, password: String,
                          users: List<User>): Boolean {
        return users.any { user ->
            username == user.user && password == user.password
        }
    }

    fun validUsers() {
        users = listOf(
            User(1, "yordi", "123"),
            User(2, "azael", "456"),
            User(2, "sergio", "789")
        )
    }
}