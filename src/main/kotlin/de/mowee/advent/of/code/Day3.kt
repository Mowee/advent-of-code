package de.mowee.advent.of.code

fun main() {
    val inputData = getResourceAsText("day3InputData.txt")
    val day3 = Day3()
    val epsilonRate = day3.getEpsilonRate(inputData).toLong(2)
    val gammaRate = day3.getGammaRate(inputData).toLong(2)

    val oxygenGeneratorRating = day3.getOxygenGeneratorRating(inputData).toLong(2)
    val cO2ScrubberRating = day3.getCO2ScrubberRating(inputData).toLong(2)

    val powerConsumption = epsilonRate * gammaRate
    val lifeSupportRating = oxygenGeneratorRating * cO2ScrubberRating

    println("EpsilonRate: $epsilonRate")
    println("GammaRate: $gammaRate")
    println("PowerConsumption: $powerConsumption")

    println("OxygenGeneratorRating: $oxygenGeneratorRating")
    println("CO2 Scrubber Rating: $cO2ScrubberRating")
    println("LifeSupportRating: $lifeSupportRating")
}

class Day3 {

    fun getCO2ScrubberRating(data: String): String {
        return filterByCommonValue(data) {
            it.getLeastCommon()
        }
    }

    fun getOxygenGeneratorRating(data: String): String {
        return filterByCommonValue(data) {
            it.getMostCommon()
        }
    }

    fun getGammaRate(data: String): String {
        return mapCommonValueByColumn(data) {
            it.getMostCommon()
        }
    }

    fun getEpsilonRate(data: String): String {
        return mapCommonValueByColumn(data) {
            it.getLeastCommon()
        }
    }

    private fun mapCommonValueByColumn(data: String, getCommonValue: (map: List<Char>) -> Char): String {
        val lines = data.trimIndent().lines()
        val matrix = lines.convertDataToMatrix()
        return (0 until lines.getRowLength()).joinToString("") { index ->
            getCommonValue(matrix.map { it[index] }).toString()
        }
    }

    private fun filterByCommonValue(data: String, getCommonValue: (map: List<Char>) -> Char): String {
        val lines = data.trimIndent().lines()
        val matrix = lines.convertDataToMatrix()
        var result = matrix

        loop@ for (column in 0 until lines.getRowLength()) {
            val commonValue = getCommonValue(result.map { row -> row[column] })
            val filteredResult = result.mapNotNull { it.takeIf { it[column] == commonValue } }.toMutableList()

            result = filteredResult

            if (filteredResult.count() == 1)
                break@loop
        }

        if (result.count() > 1)
            throw IllegalStateException("Expected only 1 result but received ${result.count()}")

        return result[0].joinToString("")
    }

    private fun List<Char>.getMostCommon(): Char {
        return when {
            count { it == '1' } >= count { it == '0' } -> '1'
            else -> '0'
        }
    }

    private fun List<Char>.getLeastCommon(): Char {
        return when {
            count { it == '0' } <= count { it == '1' } -> '0'
            else -> '1'
        }
    }

    private fun List<String>.convertDataToMatrix(): List<CharArray> {
        return this.map { it.toCharArray() }
    }

    private fun List<String>.getRowLength() = maxOf { it.count() }
}
