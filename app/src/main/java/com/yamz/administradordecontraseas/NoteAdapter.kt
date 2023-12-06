package com.yamz.administradordecontraseas

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class NoteAdapter(private var notes: List<Note>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.render(note)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class NoteViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val title: TextView = view.findViewById(R.id.title_note)
        val email: TextView = view.findViewById(R.id.email_label)
        val name: TextView = view.findViewById(R.id.name_label)
        val icon: ImageView = view.findViewById(R.id.icon_list)

        fun render(note: Note) {
            title.text = note.name
            name.text = ": " + note.user
            email.text = ": " + note.email
            Picasso.get().load(note.icon).into(icon)
        }
    }
}