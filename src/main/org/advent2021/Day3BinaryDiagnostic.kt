package org.advent2021

class Day3BinaryDiagnostic {

    enum class RatingType {
        OXYGEN, CO2
    }

    val ONE = '1'
    val ZERO = '0'

    fun getSubmarinePowerConsumption(diagnosticReport: List<String>): Int {
        val readingsCount = diagnosticReport.size
        val ones = IntArray(diagnosticReport[0].length)
        diagnosticReport.forEach { reading ->
            for ((index, bit) in reading.withIndex()) {
                if (ONE == bit) ++ones[index]
            }
        }
        var gammaRate = ""
        var epsilonRate = ""
        ones.forEach { onesCount ->
            if (onesCount > readingsCount - onesCount) {
                gammaRate += ONE
                epsilonRate += ZERO
            } else {
                gammaRate += ZERO
                epsilonRate += ONE
            }
        }

        return gammaRate.toInt(2) * epsilonRate.toInt(2)
    }

    fun getSubmarineLifeSupportRating(diagnosticReport: List<String>): Int {
        val oxygenGeneratorRating = determineLifeSupportRating(diagnosticReport, RatingType.OXYGEN)
        var co2RubberRating = determineLifeSupportRating(diagnosticReport, RatingType.CO2)

        return oxygenGeneratorRating.toInt(2) * co2RubberRating.toInt(2)
    }

    private fun determineLifeSupportRating(diagnosticReport: List<String>, ratingType: RatingType): String {
        val maxPosition = diagnosticReport[0].lastIndex
        var possibleRatings = diagnosticReport.toMutableList()
        while (possibleRatings.size > 1) {
            for (curPos in 0..maxPosition) {
                val determinedValue = determineValueOnGivenPosition(curPos, possibleRatings, ratingType)
                possibleRatings = possibleRatings.filter { rating -> rating[curPos] == determinedValue }.toMutableList()
                if (possibleRatings.size == 1) break
            }
        }
        return possibleRatings[0]
    }

    private fun determineValueOnGivenPosition(position: Int, ratings: MutableList<String>, ratingType: RatingType): Char {
        var countZeroes = 0L
        var countOnes = 0
        ratings.forEach { rating ->
            if (ONE == rating[position]) ++countOnes
            else ++countZeroes
        }
        return when (ratingType) {
            RatingType.OXYGEN -> {
                if (countOnes >= countZeroes) ONE
                else ZERO
            }
            RatingType.CO2 -> {
                if (countZeroes <= countOnes) ZERO
                else ONE
            }
        }
    }
}