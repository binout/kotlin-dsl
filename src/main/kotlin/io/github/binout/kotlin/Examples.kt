package io.github.binout.kotlin

import java.util.logging.Level
import java.util.logging.Logger

// tag::operator[]
data class Point(val x: Int, val y:Int) {
    operator fun plus(p: Point) = Point(x + p.x, y + p.y)
    operator fun minus(p: Point) = Point(x - p.x, y - p.y)
}

fun `operator overload`() {

    val p1 = Point(0, 5)
    val p2 = Point(3, 10)
    println(p1 + p2) // Point(x=3, y=15)
    println(p1 - p2) // Point(x=-3, y=-5)
}
// end::operator[]

// tag::destructuring[]
fun `destructuring declaration`() {

    val (x, y) = Point(6, 7)
    println(x) //6
    println(y) //7
}
// end::destructuring[]

// tag::getset[]
fun `get set convention`() {

    val list = listOf("alpha", "beta", "gamma")
    println(list[1]) // beta

    val map = mutableMapOf(Pair("a", "alpha"), Pair("b", "beta"))
    map["c"] = "gamma"
    println(map["c"]) // gamma
}
// end::getset[]

// tag::parentheses[]
fun `lambda out of parentheses`() {

    listOf("john", "paul", "ringo", "georges").forEach( { println(it) })

    listOf("john", "paul", "ringo", "georges").forEach { println(it) }
}
// end::parentheses[]


// tag::extension[]
fun `extension function`() {

    fun Point.moveX(offset: Int) = this.copy(x = this.x + offset )

    val p = Point(0, 5)
    println(p.moveX(5)) // Point(x=5, y=5)
}
// end::extension[]


// tag::infix[]
fun `infix functions`() {

    infix fun Point.moveY(offset: Int) = this.copy(y = this.y + offset )

    val p = Point(0, 5)
    println(p.moveY(5)) // Point(x=0, y=10)
    println(p moveY 5) // Point(x=0, y=10)
}
// end::infix[]

// tag::receiver[]
fun `lambda with receiver`() {

    fun Point.print(move: Point.() -> Unit) = this.apply(move)

    val p = Point(0, 5)
    p.print { println("x = $x, y = $y") }   // x = 0, y = 5
    p.print { log("x = $x, y = $y") } // INFOS: x = 0, y = 5

}
// end::receiver[]

fun log(msg: String) = Logger.getGlobal().log(Level.INFO, msg)

fun main(args: Array<String>) {
    `operator overload`()
    `destructuring declaration`()
    `get set convention`()
    `lambda out of parentheses`()
    `extension function`()
    `infix functions`()
    `lambda with receiver`()
}