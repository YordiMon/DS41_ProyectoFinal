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
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.yamz.administradordecontraseas.FirstFragment

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
        val url = myView.findViewById<EditText>(R.id.url)
        val icono = myView.findViewById<ImageView>(R.id.icono)

        add.setOnClickListener() {
            if (user.text.isNotEmpty() and password.text.isNotEmpty()
                and name.text.isNotEmpty() and email.text.isNotEmpty()
                and url.text.isNotEmpty()) {

                val newNote = Note(
                    2, "y", "o", "i", "123", "op", "https://th.bing.com/th/id/R.9d13eaaf6566b8bdf715bd38c110aec0?rik=rY2INEiHKMVz2w&riu=http%3a%2f%2f3.bp.blogspot.com%2f-KNqO9JuXUN8%2fTi2b1LHRquI%2fAAAAAAAAAIU%2fL6k8Wlzxj9k%2fs1600%2flogo_facebook.png&ehk=ziMr2C3oUEw31MWuloKmoKqzMBzkqgUnFMR%2bsHqWeHM%3d&risl=&pid=ImgRaw&r=0"
                    /*
                    name.text.toString(),
                    user.text.toString(),
                    email.text.toString(),
                    password.text.toString(),
                    url.text.toString(),
                    selectedImageUri.toString()
                    */
                )

                val firstFragment = activity?.supportFragmentManager?.findFragmentById(R.id.firstFragment) as? FirstFragment
                if (firstFragment != null) {
                    firstFragment.addNote(newNote)
                }

                val controller: NavController = Navigation.findNavController(myView)
                controller.navigate(R.id.action_thirdFragment_to_secondFragment)

            } else {
                val error = BottomSheetDialog(myView.context)
                val layout: View = layoutInflater.inflate(R.layout.error_template, null)

                error.setContentView(layout)
                error.show()
            }
        }

        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), R.color.almost_dark_blue)

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
