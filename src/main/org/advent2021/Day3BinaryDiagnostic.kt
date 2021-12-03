package org.advent2021

class Day3BinaryDiagnostic {

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
        val gammaRateValue = gammaRate.toInt(2)
        val epsilonRateValue = epsilonRate.toInt(2)
        return gammaRateValue * epsilonRateValue
    }
}