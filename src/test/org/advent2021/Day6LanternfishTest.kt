package org.advent2021

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.math.BigInteger

internal class Day6LanternfishTest {

    private val COMMA = ','

    private val day6Lanternfish = Day6Lanternfish()
    private val inputFileName = "Day6Input.txt"

    private fun readResourceFile(fileName: String): IntArray {
        val resourcesPath = "src/test/resources"
        return File("$resourcesPath/$fileName")
            .readText()
            .split(COMMA)
            .map { it.toInt() }
            .toIntArray()
    }

    @Test
    fun countLanternfishSpawningFor18DaysTest() {
        val initialState = intArrayOf(3, 4, 3, 1, 2)
        val n = 18
        val lanternfishCountAfterNDays = day6Lanternfish.countLanternfishSpawningForNDays(initialState, n)
        val expected = 26.toBigInteger()
        assertEquals(expected, lanternfishCountAfterNDays)
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
    fun countLanternfishSpawningFor80Days() {
        val initialState = readResourceFile(inputFileName)
        val n = 80
        val lanternfishCountAfterNDays = day6Lanternfish.countLanternfishSpawningForNDays(initialState, n)
        val expected = 362639.toBigInteger()
        assertEquals(expected, lanternfishCountAfterNDays)
    }

    @Test
    fun countLanternfishSpawningFor256DaysTest() {
        val initialState = intArrayOf(3, 4, 3, 1, 2)
        val n = 256
        val lanternfishCountAfterNDays = day6Lanternfish.countLanternfishSpawningForNDays(initialState, n)
        val expected = 26984457539.toBigInteger()
        assertEquals(lanternfishCountAfterNDays, expected)
    }

    @Test
    fun countLanternfishSpawningFor256Days() {
        val initialState = readResourceFile(inputFileName)
        val n = 256
        val lanternfishCountAfterNDays = day6Lanternfish.countLanternfishSpawningForNDays(initialState, n)
        val expected = BigInteger("1639854996917")
        assertEquals(expected, lanternfishCountAfterNDays)
    }
}