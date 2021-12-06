package de.mowee.advent.of.code

fun main() {
    val inputData = getResourceAsText("day4InputData.txt")

    val day4 = Day4()
    val score = day4.findLastBoard(inputData)

    println("The final score is: $score")
}

class Day4 {
    fun findFirstBoard(data: String): Int {
        return playBingo(data).first()
    }

    fun findLastBoard(data: String): Int {
        return playBingo(data).last()
    }

    private fun playBingo(data: String): List<Int> {
        val (randomNumbers, boards) = data.split("\n\n").let { gameData ->
            getRandomNumbers(gameData) to getBoards(gameData)
        }

        val bingoFinalScores = mutableListOf<Int>()
        val winnerBoards = mutableSetOf<Int>()

        randomNumbers.forEach { number ->
            boards.forEachIndexed { index, board ->
                board.newNumber(number)
                if (board.bingo() && !winnerBoards.contains(index)) {
                    bingoFinalScores.add(board.sumOfUnmarkedNumbers() * number)
                    winnerBoards.add(index)
                }
            }
        }

        return bingoFinalScores
    }

    private fun getRandomNumbers(gameData: List<String>) =
        gameData[0].split(",").map { it.toInt() }

    private fun getBoards(gameData: List<String>) = gameData
        .drop(1)
        .map { boards ->
            boards.lines()
                .filter { row -> row.isNotBlank() }
                .map { rows ->
                    rows.split(" ")
                        .filter { it.isNotBlank() }
                        .map { it.toInt() }
                }
        }.map { Board(it) }

    class Board(
        private val boardNumbers: List<List<Int>>
    ) {

        private val pickedNumbers = mutableListOf<Int>()

        fun newNumber(number: Int) {
            pickedNumbers.add(number)
        }

        fun bingo(): Boolean {
            return checkHorizontally() || checkVertically()
        }

        fun sumOfUnmarkedNumbers(): Int {
            return boardNumbers.flatten().filter { !pickedNumbers.contains(it) }.sum()
        }

        private fun checkHorizontally(): Boolean {
            return boardNumbers.any { pickedNumbers.containsAll(it) }
        }

        private fun checkVertically(): Boolean {
            return (0 until 5).map { y ->
                (0 until 5).map { x ->
                    boardNumbers[x][y]
                }
            }.any { pickedNumbers.containsAll(it) }
        }

    }
}
