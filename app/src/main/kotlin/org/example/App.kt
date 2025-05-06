
package org.example

class App {
    val greeting: String
        get() = "Hello World!"
}

fun calcularFuncionCuadratica(a: Int, b: Int, c: Int, x: Double): Double {
    return a * x * x + b * x + c
}

fun generarTablaValores(a: Int, b: Int, c: Int, inicio: Int, fin: Int, paso: Int = 1): List<Pair<Double, Double>> {
    val valores = mutableListOf<Pair<Double, Double>>()
    var x = inicio.toDouble()
    while (x <= fin) {
        val y = calcularFuncionCuadratica(a, b, c, x)
        valores.add(Pair(x, y))
        x += paso
    }
    return valores
}

fun mostrarTabla(valores: List<Pair<Double, Double>>) {
    println("╔════════╦════════════╗")
    println("║   x    ║   f(x)     ║")
    println("╠════════╬════════════╣")
    for ((x, y) in valores) {
        println("║ %6.2f ║ %10.2f ║".format(x, y))
    }
    println("╚════════╩════════════╝")
}

fun main() {
    val a = 4
    val b = 6
    val c = -9

    if (a == 0) {
        println("El coeficiente 'a' no puede ser cero.")
        return
    }

    val funcion = buildString {
        append("${a}x² ")
        append(if (b >= 0) "+ $b" else "- ${-b}")
        append("x ")
        append(if (c >= 0) "+ $c" else "- ${-c}")
    }

    println(App().greeting)
    println("Función cuadrática: f(x) = $funcion")

    val inicio = -5
    val fin = 5
    val paso = 1

    val tablaValores = generarTablaValores(a, b, c, inicio, fin, paso)
    mostrarTabla(tablaValores)
}

