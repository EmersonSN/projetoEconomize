package com.example.primeiroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListaDeItensAdapter.ExecutadorDeAcao,AdapterView.OnItemSelectedListener {
    private val ListaDeComodos = mutableListOf<Comodo>(Comodo("Cozinha", mutableListOf()), Comodo("Sala",
        mutableListOf(Eletrodomestico("tv", 134), Eletrodomestico("Lampada", 34)
        ))
    );
    private lateinit var dialog: MaterialAlertDialogBuilder
    private val adapter = ListaDeItensAdapter(ListaDeComodos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoCriarItem = findViewById<FloatingActionButton>(R.id.botaoCriar)
        botaoCriarItem.setOnClickListener {
            abrirDialogParaCriarItem()
        }
        dialog = MaterialAlertDialogBuilder(this);

        val listaDeItens  = findViewById<RecyclerView>(R.id.lista_de_itens)
        listaDeItens.adapter = adapter
        listaDeItens.layoutManager = LinearLayoutManager(this@MainActivity)
        DropDown()
    }

    override fun executaEventoDeClique(comodo: Comodo){
            val intent = Intent(this@MainActivity, DetalhesDoComodoActivity::class.java)
            intent.putExtra("nomeDoComodo", comodo.nome)
            startActivity(intent)
    }

    private fun abrirDialogParaCriarItem() {
        val adicionarDialogView = LayoutInflater.from(this).inflate(R.layout.create_item_dialog, null, false)
//        dialog.setView(adicionarDialogView).setPositiveButton("confirmar") { _ , _ ->
//            val input = adicionarDialogView.findViewById<EditText>(R.id.criar_item_input)
//            val novoItem = input.text.toString()
//            ListaDeItens.add(novoItem)
//        }.show()
    }
    private fun DropDown(){
        val spin = findViewById<Spinner>(R.id.dropDown)
        val adapter = ArrayAdapter.createFromResource(this,R.array.Comodos,android.R.layout.simple_spinner_item)
        spin.adapter = adapter
        spin.onItemSelectedListener = this
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}