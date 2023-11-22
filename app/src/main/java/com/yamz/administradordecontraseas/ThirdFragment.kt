package com.yamz.administradordecontraseas

import android.graphics.Typeface
import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialog

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_third, container, false)

        val cancel = myView.findViewById<Button>(R.id.cancel)

        cancel.setOnClickListener() {

                val controller: NavController = Navigation.findNavController(myView)
                controller.navigate(R.id.action_thirdFragment_to_secondFragment)
            }

        return myView
    }
}
