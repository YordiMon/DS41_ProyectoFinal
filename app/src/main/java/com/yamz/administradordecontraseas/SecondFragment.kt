package com.yamz.administradordecontraseas

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialog

class SecondFragment : Fragment() {

    private val REQUEST_PICK_IMAGE = 1
    private var selectedImageUri: Uri? = null

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

        val selectImageBtn = myView.findViewById<ImageView>(R.id.icono)

        selectImageBtn.setOnClickListener {
            
            openGallery()
        }

        val add = myView.findViewById<Button>(R.id.add)
        val name = myView.findViewById<EditText>(R.id.name)
        val user = myView.findViewById<EditText>(R.id.user)
        val email = myView.findViewById<EditText>(R.id.email)
        val password = myView.findViewById<EditText>(R.id.password)

        add.setOnClickListener() {
            if (user.text.isNotEmpty() and password.text.isNotEmpty()
                and name.text.isNotEmpty() and email.text.isNotEmpty()) {

                val controller: NavController = Navigation.findNavController(myView)
                controller.navigate(R.id.action_thirdFragment_to_secondFragment)

            } else {

                val error = BottomSheetDialog(myView.context)
                val layout: View = layoutInflater.inflate(R.layout.error_template, null)

                error.setContentView(layout)
                error.show()
            }

        }

        return myView
    }

        private fun openGallery() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_PICK_IMAGE)
        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data

            val imageView = view?.findViewById<ImageView>(R.id.icono)
            imageView?.setImageURI(selectedImageUri)
        }
    }
}
