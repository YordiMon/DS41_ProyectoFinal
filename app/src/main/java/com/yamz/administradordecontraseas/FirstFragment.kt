package com.yamz.administradordecontraseas

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FirstFragment : Fragment() {

    private var notes : List<Note> = emptyList()
    private lateinit var adapter: NoteAdapter
    private var notess: MutableList<Note> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val myView = inflater.inflate(R.layout.fragment_second, container, false)

        initData()
        val recyclerView =
            myView.findViewById<RecyclerView>(
                R.id.notesRecycler
            )

        adapter = NoteAdapter(notes)
        val layoutManager = LinearLayoutManager(container?.context)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        // aparte
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

        requireActivity().window.navigationBarColor = ContextCompat.getColor(requireContext(), R.color.semi_dark_blue)

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

    private fun initData() {

        notes = listOf(
            Note(1, "Facebook", "Yordi", "yordi@gmail.com", "123", "google.com", "https://th.bing.com/th/id/R.9d13eaaf6566b8bdf715bd38c110aec0?rik=rY2INEiHKMVz2w&riu=http%3a%2f%2f3.bp.blogspot.com%2f-KNqO9JuXUN8%2fTi2b1LHRquI%2fAAAAAAAAAIU%2fL6k8Wlzxj9k%2fs1600%2flogo_facebook.png&ehk=ziMr2C3oUEw31MWuloKmoKqzMBzkqgUnFMR%2bsHqWeHM%3d&risl=&pid=ImgRaw&r=0"),
            Note(2, "Instagram", "Azael", "azael@gmail.com", "123", "google.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Instagram_icon.png/2048px-Instagram_icon.png"),
            Note(3, "Facebook", "Yordi", "yordi@gmail.com", "123", "google.com", "https://th.bing.com/th/id/R.9d13eaaf6566b8bdf715bd38c110aec0?rik=rY2INEiHKMVz2w&riu=http%3a%2f%2f3.bp.blogspot.com%2f-KNqO9JuXUN8%2fTi2b1LHRquI%2fAAAAAAAAAIU%2fL6k8Wlzxj9k%2fs1600%2flogo_facebook.png&ehk=ziMr2C3oUEw31MWuloKmoKqzMBzkqgUnFMR%2bsHqWeHM%3d&risl=&pid=ImgRaw&r=0"),
            Note(4, "Instagram", "Azael", "azael@gmail.com", "123", "google.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Instagram_icon.png/2048px-Instagram_icon.png"),
            Note(5, "Facebook", "Yordi", "yordi@gmail.com", "123", "google.com", "https://th.bing.com/th/id/R.9d13eaaf6566b8bdf715bd38c110aec0?rik=rY2INEiHKMVz2w&riu=http%3a%2f%2f3.bp.blogspot.com%2f-KNqO9JuXUN8%2fTi2b1LHRquI%2fAAAAAAAAAIU%2fL6k8Wlzxj9k%2fs1600%2flogo_facebook.png&ehk=ziMr2C3oUEw31MWuloKmoKqzMBzkqgUnFMR%2bsHqWeHM%3d&risl=&pid=ImgRaw&r=0"),
            Note(6, "Instagram", "Azael", "azael@gmail.com", "123", "google.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Instagram_icon.png/2048px-Instagram_icon.png"),
            Note(7, "Facebook", "Yordi", "yordi@gmail.com", "123", "google.com", "https://th.bing.com/th/id/R.9d13eaaf6566b8bdf715bd38c110aec0?rik=rY2INEiHKMVz2w&riu=http%3a%2f%2f3.bp.blogspot.com%2f-KNqO9JuXUN8%2fTi2b1LHRquI%2fAAAAAAAAAIU%2fL6k8Wlzxj9k%2fs1600%2flogo_facebook.png&ehk=ziMr2C3oUEw31MWuloKmoKqzMBzkqgUnFMR%2bsHqWeHM%3d&risl=&pid=ImgRaw&r=0"),
            Note(8, "Instagram", "Azael", "azael@gmail.com", "123", "google.com", "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Instagram_icon.png/2048px-Instagram_icon.png"),
            )
    }

    fun addNote(note: Note) {
        notess.add(note)
        adapter.notifyItemInserted(notess.size - 1)
    }
}