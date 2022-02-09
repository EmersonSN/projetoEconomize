package com.example.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetalhesDoComodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_do_comodo)
        val nomeDoComodoTextView : TextView = findViewById(R.id.nomeDoComodo)
        val nomeDoComodo = this.intent.getStringExtra("nomeDoComodo")
        nomeDoComodoTextView.text = nomeDoComodo
    }
}