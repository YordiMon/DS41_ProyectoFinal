package com.yamz.administradordecontraseas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val myView = inflater.inflate(R.layout.fragment_detail, container, false)

        val cancel = myView.findViewById<Button>(R.id.back)

        cancel.setOnClickListener() {

            val controller: NavController = Navigation.findNavController(myView)
            controller.navigate(R.id.action_detailFragment_to_secondFragment)
        }

        return myView
    }
}