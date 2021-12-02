package de.mowee.advent.of.code

import java.io.File

fun main() {
    val dataText = getResourceAsText("day1InputData.txt")

    // Day 1
    val day1 = Day1()
    val dataNumbered = day1.textToNumberedList(dataText)
    val countIncreasedMeasurements = day1.countIncreasedMeasurements(dataNumbered)
    val measurementWindows = day1.measurementWindows(dataNumbered)
    val sumOfMeasurementWindows = day1.sumOfMeasurementWindows(measurementWindows)
    val countIncreasedMeasurementWindows = day1.countIncreasedMeasurements(sumOfMeasurementWindows)

    println("Day 1 - first step: $countIncreasedMeasurements")
    println("Day 1 - second step: $countIncreasedMeasurementWindows")
}

fun getResourceAsText(path: String): String {
    return File(ClassLoader.getSystemResource(path).file).readText()
}
