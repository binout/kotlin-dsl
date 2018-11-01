package io.github.binout.kotlin.xchart

import org.knowm.xchart.SwingWrapper
import org.knowm.xchart.XYChart
import org.knowm.xchart.XYChartBuilder
import org.knowm.xchart.XYSeries
import org.knowm.xchart.style.MatlabTheme
import org.knowm.xchart.style.Styler
import org.knowm.xchart.style.XYStyler

fun main(args: Array<String>) {


    val chart = `create char`{
        styler.legendPosition = Styler.LegendPosition.InsideNE
        styler.defaultSeriesRenderStyle = XYSeries.XYSeriesRenderStyle.Area
        styler.theme = MatlabTheme()
        // Series
        addSeries("a", doubleArrayOf(0.0, 3.0, 5.0, 7.0, 9.0), doubleArrayOf(-3.0, 5.0, 9.0, 6.0, 5.0))
        addSeries("b", doubleArrayOf(0.0, 2.0, 4.0, 6.0, 9.0), doubleArrayOf(-1.0, 6.0, 4.0, 0.0, 4.0))
        addSeries("c", doubleArrayOf(0.0, 1.0, 3.0, 8.0, 9.0), doubleArrayOf(-2.0, -1.0, 1.0, 0.0, 1.0))
    }
    SwingWrapper(chart).displayChart()
}

fun `create char`(f: XYChart.() -> Unit) : XYChart {

    val chart = XYChartBuilder()
            .width(600)
            .height(400)
            .title("Area Chart")
            .xAxisTitle("X")
            .yAxisTitle("Y").build()
    f(chart)
    return chart
}