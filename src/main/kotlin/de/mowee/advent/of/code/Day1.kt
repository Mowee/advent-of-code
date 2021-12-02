package de.mowee.advent.of.code

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
