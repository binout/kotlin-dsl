package io.github.binout.kotlin.xchart

import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChart
import org.knowm.xchart.XYChartBuilder
import org.knowm.xchart.XYSeries
import org.knowm.xchart.style.MatlabTheme
import org.knowm.xchart.style.Styler
import org.knowm.xchart.style.XYStyler
import java.awt.Font

fun main(args: Array<String>) {

    createXYChart {
        width = 600
        height = 400
        title = "Area Chart"
        xAxisTitle("X")
        yAxisTitle("Y")

        draw {
            style {
                legendPosition = Styler.LegendPosition.InsideNE
                defaultSeriesRenderStyle = XYSeries.XYSeriesRenderStyle.Area
                theme = MatlabTheme()
            }

            serie("a") {
                x = doubleArrayOf(0.0, 3.0, 5.0, 7.0, 9.0)
                y = doubleArrayOf(-3.0, 5.0, 9.0, 6.0, 5.0)
            }

            serie("b") {
                x = doubleArrayOf(0.0, 2.0, 4.0, 6.0, 9.0)
                y = doubleArrayOf(-1.0, 6.0, 4.0, 0.0, 4.0)
            }

            serie("c") {
                x = doubleArrayOf(0.0, 1.0, 3.0, 8.0, 9.0)
                y = doubleArrayOf(-2.0, -1.0, 1.0, 0.0, 1.0)
            }
        }.display()
    }

}

private fun XYChart.display() {
    SwingWrapper(this).displayChart()
}

private fun XYChart.serie(name: String, lambda: Serie.() -> Unit) {
    val serie = Serie()
    serie.apply(lambda)
    this.addSeries(name, serie.x, serie.y)
}

class Serie(var x: DoubleArray = doubleArrayOf(),
            var y: DoubleArray = doubleArrayOf())

fun XYChart.style(lambda: XYStyler.() -> Unit) {
    this.styler.apply(lambda)
}


fun createXYChart(lambda: XYChartBuilder.() -> Unit)  {
    val chartBuilder = XYChartBuilder()
    chartBuilder.apply(lambda)
}

fun XYChartBuilder.draw(lambda: XYChart.() -> Unit): XYChart {
    val chart = this.build()
    chart.apply(lambda)
    return chart
}

