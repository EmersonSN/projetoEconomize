package com.example.primeiroapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class ListaDeItensAdapter(private var dataSet: MutableList<Comodo>, val executadorDeAcao:ExecutadorDeAcao) :
    Adapter<ListaDeItensAdapter.ViewHolder>() {

    interface ExecutadorDeAcao{
        fun executaEventoDeClique(comodo: Comodo)
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //        val item: CheckBox = view.findViewById(R.id.item_da_lista)
        val nomeDoComodo: TextView = view.findViewById(R.id.nomeDoComodo)
        var consumoTotalDoComodo: TextView = view.findViewById(R.id.consumoDoComodo)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_da_lista, viewGroup, false)

        return ViewHolder(view)
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comodo = dataSet[position]
        holder.nomeDoComodo.text = comodo.nome
        holder.consumoTotalDoComodo.text = comodo.pegarConsumoTotal().toString()
        holder.itemView.setOnClickListener{
            executadorDeAcao.executaEventoDeClique(comodo)
        }
    }
}