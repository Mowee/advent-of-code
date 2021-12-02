package de.mowee.advent.of.code

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test {

    @Test
    fun `implement commands as text`() {
        // given
        val submarine = Day2()
        val commands = """forward 5
down 5
forward 8
up 3
down 8
forward 2"""

        // when
        submarine.parseCommands(commands)
        val horizontalPosition = submarine.getHorizontalPosition()
        val depth = submarine.getDepth()

        // then
        assertEquals(15, horizontalPosition)
        assertEquals(60, depth)
    }

    @Test
    fun `implement example`() {
        // given
        val submarine = Day2()
            .moveForward(5)
            .moveDown(5)
            .moveForward(8)
            .moveUp(3)
            .moveDown(8)
            .moveForward(2)

        // when
        val horizontalPosition = submarine.getHorizontalPosition()
        val depth = submarine.getDepth()

        // then
        assertEquals(15, horizontalPosition)
        assertEquals(60, depth)
    }
}
