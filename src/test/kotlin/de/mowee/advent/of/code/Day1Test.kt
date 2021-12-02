package de.mowee.advent.of.code

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day1Test {

    private val day1 = Day1()

    @Test
    fun `expects text as numbered list`() {
        // given
        val measurements = """
            199
            200
            208
            210
            200
            207
            240
            269
            260
            263
            """

        // when
        val result = day1.textToNumberedList(measurements)

        // then
        val expected = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        assertEquals(expected, result)
    }

    @Test
    fun `count increased measurements`() {
        // given
        val measurements = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

        // when
        val comparison = day1.countIncreasedMeasurements(measurements)

        // then
        assertEquals(7, comparison)
    }

    @Test
    fun `expect correct sum of each measurement window`() {
        // given
        val measurements = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
        val measurementWindows = day1.measurementWindows(measurements)

        // when
        val sumOfWindows = day1.sumOfMeasurementWindows(measurementWindows)
        val result = day1.countIncreasedMeasurements(sumOfWindows)

        // then
        assertEquals(5, result)
    }

    @Test
    fun `expect measurement windows`() {
        // given
        val measurements = listOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)

        // when
        val measurementWindows = day1.measurementWindows(measurements)

        // then
        assertEquals(listOf(
            listOf(199, 200, 208),
            listOf(200, 208, 210),
            listOf(208, 210, 200),
            listOf(210, 200, 207),
            listOf(200, 207, 240),
            listOf(207, 240, 269),
            listOf(240, 269, 260),
            listOf(269, 260, 263),
        ), measurementWindows)
    }

}
