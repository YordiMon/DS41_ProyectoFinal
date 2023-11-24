package com.yamz.administradordecontraseas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FourthFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_fourth, container, false)

        val cancel = myView.findViewById<Button>(R.id.cancel)

        cancel.setOnClickListener() {

            val controller: NavController = Navigation.findNavController(myView)
            controller.navigate(R.id.action_fourthFragment_to_secondFragment)
        }


        return myView
    }
}