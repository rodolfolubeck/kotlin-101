package org.example.stringsFormats

fun main () {
    val input = readln()
    val name = if (input.isNotBlank()) input else "Kotlin"
    println("Olá, ${if (name.isBlank()) "alguém" else name}!")
}

