package com.example.primeiroapp
interface Veiculo{
    fun pegarVelocidade(): Int
}
class Carro():Veiculo{
    override fun pegarVelocidade(): Int {
        return 10
    }

}
open class Aviao():Veiculo{
    override fun pegarVelocidade(): Int {
        return 100
    }
    open fun pegarAltitude():Int{
        return 120
    }
}
class Jato():Aviao(){
    override fun pegarAltitude():Int{
        return 200
    }
    fun exempo():Int{
        return pegarAltitude()
    }
}




class Main {
    val veiculo:Veiculo = Carro()
    fun Foobar(){
        veiculo.pegarVelocidade()
    }
}