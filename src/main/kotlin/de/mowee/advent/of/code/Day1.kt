package de.mowee.advent.of.code

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

class Day1 {
    fun textToNumberedList(input: String): List<Int> {
        return input.trimIndent().lines().mapNotNull { it.toIntOrNull() }
    }

    fun countIncreasedMeasurements(input: List<Int>): Int {
        return (0 until input.count()).count { it != 0 && input[it] > input[it - 1] }
    }

    fun measurementWindows(input: List<Int>): List<List<Int>> {
        return (0 until input.count())
            .asSequence()
            .filter { it + 2 < input.count() }
            .mapTo(mutableListOf()) { index ->
                listOf(input[index], input[index + 1], input[index + 2])
            }
    }

    fun sumOfMeasurementWindows(input: List<List<Int>>): List<Int> {
        return input.map { it.sum() }
    }
}
