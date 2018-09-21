package io.github.binout.kotlin.point

data class Point(val x: Int = 0, val y: Int = 0) {

    operator fun plus(otherPoint: Point): Point
            = Point(x + otherPoint.x, y + otherPoint.y)

    operator fun unaryMinus() = Point(-x, -y)

}

data class Line(val a: Point, val b: Point)


object draw {

    operator fun invoke(init: DrawContext.() -> Unit) : Line {
        val drawContext = DrawContext()
        drawContext.init()
        return drawContext.line
    }

    class DrawContext {
        var line: Line = Line(Point(), Point())

        infix fun from(pair: Pair<Int, Int>): DrawContext {
            line = line.copy(a = Point(pair.first, pair.second))
            return this
        }

        infix fun until(pair: Pair<Int, Int>): DrawContext {
            line = line.copy(b = Point(pair.first, pair.second))
            return this
        }
    }

}

fun main(args: Array<String>) {
    val p1 = Point(5, 5)
    val p2 = Point(0, 5)

    println(p1 + p2)
    println(-p1)

    println(Line(Point(5, 5), Point(0, 5)))

    val lineDsl = draw {
        from (5 to 5) until (0 to 5)
    }
    println(lineDsl)

}