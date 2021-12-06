package org.advent2021

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

internal class Day6LanternfishTest {

    private val COMMA = ','

    private val day6Lanternfish = Day6Lanternfish()
    private val inputFileName = "Day6Input.txt"

    private fun readResourceFile(fileName: String): List<Int> {
        val resourcesPath = "src/test/resources"
        return File("$resourcesPath/$fileName")
                .readText()
                .split(COMMA)
                .map { it.toInt() }
    }

    @Test
    fun countLanternfishSpawningFor18DaysTest() {
        val initialState = intArrayOf(3, 4, 3, 1, 2)
        val n = 18
        val lanternfishCountAfterNDays = day6Lanternfish.countLanternfishSpawningForNDays(initialState, n)
        val expected = 26.toBigInteger()
        assertEquals(lanternfishCountAfterNDays, expected)
    }

    @Test
    fun countLanternfishSpawningFor80DaysTest() {
        val initialState = intArrayOf(3, 4, 3, 1, 2)
        val n = 80
        val lanternfishCountAfterNDays = day6Lanternfish.countLanternfishSpawningForNDays(initialState, n)
        val expected = 5934.toBigInteger()
        assertEquals(lanternfishCountAfterNDays, expected)
    }

    @Test
    fun countLanternfishSpawningForNDaysTest() {
    }
}