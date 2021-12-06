package de.mowee.advent.of.code

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day4Test {

    private val day4 = Day4()

    @Test
    fun `find first board that wins`() {
        // given
        val data = getResourceAsText("day4TestData.txt")

        // when
        val winningScore = day4.findFirstBoard(data)

        // then
        assertEquals(4512, winningScore)
    }

    @Test
    fun `find last board that wins`() {
        // given
        val data = getResourceAsText("day4TestData.txt")

        // when
        val winningScore = day4.findLastBoard(data)

        // then
        assertEquals(1924, winningScore)
    }
}
