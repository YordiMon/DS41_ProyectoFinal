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

class FirstFragment : Fragment() {

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

        enter.setOnClickListener() {

            if (user.text.isNotEmpty() and password.text.isNotEmpty()) {

                val controller: NavController = Navigation.findNavController(myView)
                controller.navigate(R.id.action_firstFragment_to_secondFragment)


            } else {

                val error = BottomSheetDialog(myView.context)
                val layout: View = layoutInflater.inflate(R.layout.error_template, null)

                error.setContentView(layout)
                error.show()
            }
        }

        cancel.setOnClickListener() {
            requireActivity().finish()
        }

        return myView
    }
}