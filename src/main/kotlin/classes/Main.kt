package org.example.classes

import org.example.geometry.Rectangle

fun main() {
    val person = Person("Bob", true)

    println(person.name)
    println(person.isStudent)

    val retangulo = Rectangle(10,10)

}

// Propriedade somente leitura - gera um campo e um getter trivial
// Propriedade gravável - um campo, um getter e um setter
class Person(
    val name: String,
    var isStudent: Boolean
)

