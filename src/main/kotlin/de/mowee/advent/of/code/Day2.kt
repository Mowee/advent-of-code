package de.mowee.advent.of.code

fun main() {
    val inputData = getResourceAsText("day2InputData.txt")
    val submarine = Day2()
    submarine.parseCommands(inputData)

    val horizontal = submarine.getHorizontalPosition()
    val depth = submarine.getDepth()

    val result = horizontal * depth

    println("Horizontal position: $horizontal")
    println("Depth: $depth")
    println("Multiplied: $result")
}

class Day2 {
    private var horizontalPosition = 0
    private var depth = 0
    private var aim = 0

    fun moveForward(units: Int): Day2 {
        horizontalPosition += units
        depth += (aim * units)
        return this
    }

    fun moveDown(units: Int): Day2 {
        aim += units
        return this
    }

    fun moveUp(units: Int): Day2 {
        aim -= units
        return this
    }

    fun getHorizontalPosition(): Int {
        return horizontalPosition
    }

    fun getDepth(): Int {
        return depth
    }

    fun parseCommands(commands: String) {
        commands.toLines().forEach {
            val split = it.split(" ")
            val command = split.first()
            val units = split.last().toInt()
            when(command) {
                "forward" -> moveForward(units)
                "down" -> moveDown(units)
                "up" -> moveUp(units)
            }
        }
    }
}
