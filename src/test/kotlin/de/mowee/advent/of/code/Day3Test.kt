package de.mowee.advent.of.code

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Test {

    private val day3 = Day3()

    @Test
    fun `determine gamma rate`() {
        // given
        val data = """00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010"""

        // when
        val gammaRate = day3.getGammaRate(data)

        // then
        assertEquals("10110", gammaRate)
    }

    @Test
    fun `determine epsilon rate`() {
        // given
        val data = """00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010"""

        // when
        val gammaRate = day3.getEpsilonRate(data)

        // then
        assertEquals("01001", gammaRate)
    }

    @Test
    fun `determine OxygenGeneratorRating`() {
        // given
        val data = """00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010"""

        // when
        val oxygenGeneratorRating = day3.getOxygenGeneratorRating(data)

        // then
        assertEquals("10111", oxygenGeneratorRating)
    }

    @Test
    fun `determine co2 scrubber rating`() {
        // given
        val data = """00100
11110
10110
10111
10101
01111
00111
11100
10000
11001
00010
01010"""

        // when
        val scrubberRating = day3.getCO2ScrubberRating(data)

        // then
        assertEquals("01010", scrubberRating)

    }
}
