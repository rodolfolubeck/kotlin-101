package org.example.functions

import java.math.RoundingMode.DOWN
import java.math.RoundingMode.UP

fun main() {
//    fun max (a: Int, b: Int ): Int {
//        return if ( a > b) a else b
//    }
    //println(max(10,20))

    val myBoolean = false
    val x = if (myBoolean) 3 else 5
    val UNKNOWN = null
    val inputString = "inputString"

    val direction = when (inputString) {
        "u" -> UP
        "D" -> DOWN
        else -> UNKNOWN
    }

    var number = try {
        inputString.toInt()
    } catch (nfe: NumberFormatException){
        -1
    }

    //usando a expressão como corpo inteiro da função
    //fun max(a:Int, b: Int): Int = if (a > b) a else b
    //Também é possível omitir o tipo de retorno
    //Só é possível omitir o tipo de retorno para expressões com o corpo de retorno
    fun max(a:Int, b: Int) = if (a > b) a else b

}