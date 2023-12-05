package com.yamz.administradordecontraseas

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_second, container, false)

        val add = myView.findViewById<Button>(R.id.add_website)
        val gen = myView.findViewById<Button>(R.id.gen_password)

        add.setOnClickListener() {

            val controller: NavController = Navigation.findNavController(myView)
            controller.navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        gen.setOnClickListener() {

            val controller: NavController = Navigation.findNavController(myView)
            controller.navigate(R.id.action_secondFragment_to_fourthFragment)
        }

        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.isFocusableInTouchMode = true
        view.requestFocus()
        view.setOnKeyListener { _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_BACK && event.action == KeyEvent.ACTION_UP) {

                requireActivity().finishAffinity()
                return@setOnKeyListener true
            }
            false
        }
    }
}