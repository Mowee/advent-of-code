package de.mowee.advent.of.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    private val day3 = Day3()

    @Test
    fun `determine gamma rate`() {
        // given
        val data = getResourceAsText("day3TestData.txt")

        // when
        val gammaRate = day3.getGammaRate(data)

        // then
        assertEquals("10110", gammaRate)
    }

    @Test
    fun `determine epsilon rate`() {
        // given
        val data = getResourceAsText("day3TestData.txt")

        // when
        val gammaRate = day3.getEpsilonRate(data)

        // then
        assertEquals("01001", gammaRate)
    }

    @Test
    fun `determine OxygenGeneratorRating`() {
        // given
        val data = getResourceAsText("day3TestData.txt")

        // when
        val oxygenGeneratorRating = day3.getOxygenGeneratorRating(data)

        // then
        assertEquals("10111", oxygenGeneratorRating)
    }

    @Test
    fun `determine co2 scrubber rating`() {
        // given
        val data = getResourceAsText("day3TestData.txt")

        // when
        val scrubberRating = day3.getCO2ScrubberRating(data)

        // then
        assertEquals("01010", scrubberRating)

    }
}
