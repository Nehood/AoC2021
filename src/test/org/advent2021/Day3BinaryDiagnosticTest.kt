package org.advent2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day3BinaryDiagnosticTest {

    private val day3BinaryDiagnostic = Day3BinaryDiagnostic()
    private val inputFileName = "Day3Input.txt"

    private fun readResourceFile(fileName: String): List<String> {
        val resourcesPath = "src/test/resources"
        val list = mutableListOf<String>()
        File("$resourcesPath/$fileName").forEachLine { list.add(it.trim()) }
        return list
    }

    private fun parseInput(input: String): List<String> {
        return input.split('\n').map { it.trim() }
    }

    @Test
    fun doTestReadingPowerConsumption() {
        val input = """00100
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

        val powerConsumption = day3BinaryDiagnostic.getSubmarinePowerConsumption(parseInput(input))
        val expected = 198
        assertEquals(expected, powerConsumption)
    }

    @Test
    fun getSubmarinePowerConsumption() {
        val input = readResourceFile(inputFileName)
        val powerConsumption = day3BinaryDiagnostic.getSubmarinePowerConsumption(input)
        val expected = 2724524
        assertEquals(expected, powerConsumption)
    }

    @Test
    fun doTestReadingLifeSupportRating() {
        val input = """00100
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

        val lifeSupportRating = day3BinaryDiagnostic.getSubmarineLifeSupportRating(parseInput(input))
        val expected = 230
        assertEquals(expected, lifeSupportRating)
    }

    @Test
    fun getSubmarineLifeSupportRating() {
        val input = readResourceFile(inputFileName)
        val powerConsumption = day3BinaryDiagnostic.getSubmarineLifeSupportRating(input)
        val expected = 2775870
        assertEquals(expected, powerConsumption)
    }
}