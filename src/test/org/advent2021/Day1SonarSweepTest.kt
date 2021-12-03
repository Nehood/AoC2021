package org.advent2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day1SonarSweepTest {
    private val day1SonarSweep = Day1SonarSweep()

    private val inputFileName = "Day1Input.txt"

    private fun readResourceFile(fileName: String): List<Int> {
        val resourcesPath = "src/test/resources"
        val list = mutableListOf<Int>()
        File("$resourcesPath/$fileName").forEachLine { list.add(it.trim().toInt()) }
        return list
    }

    @Test
    fun countIncreasingMeasurementsBaseCase() {
        val input = readResourceFile(inputFileName)
        val increasingMeasurementsCounter = day1SonarSweep.countIncreasingMeasurements(input)
        val expected = 1162

        assertEquals(expected, increasingMeasurementsCounter)
    }

    @Test
    fun countIncreasingMeasurementsExtendedCase() {
        val input = readResourceFile(inputFileName)
        val increasingMeasurementsCounter = day1SonarSweep.countIncreasingMeasurements(input, 3)
        val expected = 1190

        assertEquals(expected, increasingMeasurementsCounter)
    }
}