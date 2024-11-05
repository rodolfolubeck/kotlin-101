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
//    val color = measureColor()
//    return when(color) {
//        Color.RED, Color.ORANGE, Color.YELLOW -> "Warm (red = ${color.r})"
//        Color.GREEN -> "neutral (green = ${color.g})"
//        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue = ${color.b})"
//    }
    //quando when é usado como uma expressão (o que significa que seu resultado é usado em uma atribuição ou
    // como um valor de retorno), o compilador força a construção a ser exhaustive . Isso significa que todos os
    // caminhos possíveis devem retornar um valor.

    return when(val color = measureColor()) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "Warm (red = ${color.r})"
        Color.GREEN -> "neutral (green = ${color.g})"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold (blue = ${color.b})"
    }
}

//você pode usar qualquer tipo de objeto como uma condição de ramificação.
fun mix(c1: Color, c2: Color) =
    when(setOf(c1,c2)){
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty Color")
    }

//e a função for chamada com frequência, vale a pena reescrever o código de uma maneira diferente para evitar a criação
// de muitos objetos de curta duração, que precisam ser limpos pelo garbage collector.
fun mixOptimized(c1: Color, c2: Color) =
    when{
        (c1 == Color.RED && c2 == Color.YELLOW) ||
        (c1 == Color.YELLOW && c2 == Color.RED)
            -> Color.ORANGE
        (c1 == Color.YELLOW && c2 == Color.BLUE) ||
        (c1 == Color.BLUE && c2 == Color.YELLOW)
            -> Color.GREEN
        (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                (c1 == Color.VIOLET && c2 == Color.BLUE)
            -> Color.INDIGO
        else -> throw Exception("Dirty Color")
    }


fun main(){
    println(Color.BLUE.rgb)
    //255
    Color.GREEN.printColor()
    // Green is 65280

    println(getWarmthFromSensor())
    //warm (red = 255)

    println(mix(Color.BLUE,Color.YELLOW))

    println(mixOptimized(Color.BLUE, Color.YELLOW))
}