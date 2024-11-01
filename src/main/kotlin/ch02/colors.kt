package org.example.ch02

enum class Color(
    val r: Int,
    val g: Int,
    val b: Int
) {
    RED(255,0,0),
    ORANGE(255, 165,0),
    YELLOW(255,255,0),
    GREEN(0,255,0),
    BLUE(0,0,255),
    INDIGO(75,0,130),
    VIOLET(238,130,238);

    //se você definir quaisquer métodos na classe enum, o ponto e vírgula se torna obrigatório e separa a lista de
    // constantes enum das definições de méthodo.

    val rgb = (r * 256+ g) * 256 + b
    fun printColor() = println("$this is $rgb")

    fun mnemonic(color: Color) =
        when(color){
            Color.RED -> "RICHARD"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }
}

fun measureColor() = Color.ORANGE

fun getWarmthFromSensor(): String {
    val color = measureColor()
    return when(color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "Warm (red = ${color.r})"
        Color.GREEN -> "neutral (green = ${color.g})"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue = ${color.b})"
    }
}

fun main(){
    println(Color.BLUE.rgb)
    //255
    Color.GREEN.printColor()
    // Green is 65280

    println(getWarmthFromSensor())
    //warm (red = 255)
}