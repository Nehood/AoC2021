package org.advent2021

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Day7TheTreacheryOfWhalesTest {

    private val COMMA = ','

    private val day7TheTreacheryOfWhales = Day7TheTreacheryOfWhales()
    private val inputFileName = "Day7Input.txt"

    private fun readResourceFile(fileName: String): IntArray {
        val resourcesPath = "src/test/resources"
        return File("$resourcesPath/$fileName")
                .readText()
                .split(COMMA)
                .map { it.toInt() }
                .toIntArray()
    }

    @Test
    fun alignCrabsTest() {
        val input = intArrayOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)
        val fuelCostOfAligning = day7TheTreacheryOfWhales.alignCrabs(input)
        val expected = 37
        assertEquals(expected, fuelCostOfAligning)
    }

    @Test
    fun alignCrabs() {
        val input = readResourceFile(inputFileName)
        val fuelCostOfAligning = day7TheTreacheryOfWhales.alignCrabs(input)
        val expected = 347449
        assertEquals(expected, fuelCostOfAligning)
    }

    @Test
    fun alignCrabsWithCrabEngineeringTest() {
        val input = intArrayOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)
        val fuelCostOfAligning = day7TheTreacheryOfWhales.alignCrabsBruteForce(input)
        val expected = 168
        assertEquals(expected, fuelCostOfAligning)
    }

    @Test
    fun alignCrabsWithCrabEngineering() {
        val input = readResourceFile(inputFileName)
        val fuelCostOfAligning = day7TheTreacheryOfWhales.alignCrabsBruteForce(input)
        val expected = 98039527
        assertEquals(expected, fuelCostOfAligning)
    }
}