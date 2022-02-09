package com.example.primeiroapp

data class Comodo(val nome:String, val eletrodomesticos: MutableList<Eletrodomestico>, val tipoComodo:TiposComodos) {
    fun pegarConsumoTotal():Int{
        return eletrodomesticos.fold(0){consumoTotalParcial, eletrodomestico ->
            consumoTotalParcial + eletrodomestico.consumo
        }
        var imagem = when(tipoComodo) {
            TiposComodos.COZINHA -> R.drawable.abc_vector_test
            TiposComodos.SALA -> R.drawable.ic_launcher_background
            TiposComodos.QUARTO -> R.drawable.ic_launcher_foreground
            TiposComodos.BANHEIRO -> R.drawable.abc_vector_test
        }
    }
    enum class TiposComodos{
        SALA,
        COZINHA,
        QUARTO,
        BANHEIRO
    }
}