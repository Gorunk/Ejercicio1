package com.pjurado.ejercicio1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pjurado.ejercicio1.databinding.ItemPersonaBinding

class AdapterPersona(private val lista: List<Persona>, val listener: (Persona) -> Unit): RecyclerView.Adapter<AdapterPersona.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
        holder.itemView.setOnClickListener {
            listener(lista[position])
        }
    }

    override fun getItemCount() = lista.size

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val binding = ItemPersonaBinding.bind(view)

        fun bind(persona: Persona){
            binding.apply {
                imagePersona.glide(persona.urlFoto)
                tvNombre.text = persona.nombre
                tvTelefono.text = persona.telefono
                tvEmail.text = persona.email


            }
        }
    }

}

