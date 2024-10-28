package org.example.geometry

class shapes {
}

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get(){
            return height == width
        }
}
