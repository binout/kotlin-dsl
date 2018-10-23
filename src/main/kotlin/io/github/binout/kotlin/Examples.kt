package io.github.binout.kotlin

import java.util.logging.Level
import java.util.logging.Logger

// tag::point[]
data class Point(val x: Int, val y:Int) 
// end::point[]
{
    operator fun plus(p: Point) = Point(x + p.x, y + p.y)
    operator fun minus(p: Point) = Point(x - p.x, y - p.y)
}

fun `operator overload`() {
// tag::operator[]
val p1 = Point(0, 5)
val p2 = Point(3, 10)
println(p1 + p2) // Point(x=3, y=15)
println(p1 - p2) // Point(x=-3, y=-5)
}
// end::operator[]

fun `destructuring declaration`() {
// tag::destructuring[]
val (x, y) = Point(6, 7)
println(x) //6
println(y) //7
// end::destructuring[]
}

fun `get set convention`() {
// tag::getset[]
val list = listOf("alpha", "beta", "gamma")
println(list[1]) // beta

val map = mutableMapOf(Pair("a", "alpha"), Pair("b", "beta"))
map["c"] = "gamma"
println(map["c"]) // gamma
// end::getset[]
}

fun `lambda out of parentheses`() {
// tag::parentheses[]
listOf("franz", "ferdinand").forEach( { println(it) })

listOf("franz", "ferdinand").forEach { println(it) }
// end::parentheses[]
}


fun `extension function`() {
// tag::extension[]
fun Point.moveX(offset: Int) = this.copy(x = this.x + offset )

val p = Point(0, 5)
println(p.moveX(5)) // Point(x=5, y=5)
// end::extension[]
}


fun `infix functions`() {
// tag::infix[]
infix fun Point.moveY(offset: Int) = this.copy(y = this.y + offset )

val p = Point(0, 5)
println(p.moveY(5))   // Point(x=0, y=10)
println(p moveY 5)    // Point(x=0, y=10)
// end::infix[]
}

fun `lambda with receiver`() {
// tag::receiver[]
fun Point.use(lambda: (Point) -> Unit) = lambda(this)
fun Point.useAsReceiver(lambda: Point.() -> Unit) = this.apply(lambda)

val p = Point(0, 5)
p.use { point -> println("x = $point.x, y = $point.y") }// x = 0, y = 5
p.use { println("x = $it.x, y = $it.y") }               // x = 0, y = 5

p.useAsReceiver { println("x = $this.x, y = $this.y") } // x = 0, y = 5
p.useAsReceiver { println("x = $x, y = $y") }           // x = 0, y = 5
// end::receiver[]
}

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