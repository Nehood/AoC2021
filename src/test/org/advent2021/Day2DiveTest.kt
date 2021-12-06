package org.advent2021

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2DiveTest {

    private val NEWLINE = '\n'

    private val day2Dive = Day2Dive()
    private val inputFileName = "Day2Input.txt"

    private fun readResourceFile(fileName: String): List<String> {
        val resourcesPath = "src/test/resources"
        return File("$resourcesPath/$fileName").readText().split("\n").map { it.trim() }
    }

    private fun parseInput(input: String): List<String> {
        return input.split(NEWLINE).map { it.trim() }
    }

    @Test
    fun doTestDive() {
        val input = """forward 5
                        down 5
                        forward 8
                        up 3
                        down 8
                        forward 2"""
        val storedValue = day2Dive.dive(parseInput(input))
        assertEquals(150, storedValue)
    }

    @Test
    fun calculatePosition() {
        val input = readResourceFile(inputFileName)
        val storedValue = day2Dive.dive(input)

        assertEquals(2150351, storedValue)
    }

    @Test
    fun doTestDiveWithAimCorrection() {
        val input = """forward 5
                        down 5
                        forward 8
                        up 3
                        down 8
                        forward 2"""
        val storedValue = day2Dive.dive(parseInput(input), true)
        assertEquals(900, storedValue)
    }

    @Test
    fun calculatePositionWithAimCorrection() {
        val input = readResourceFile(inputFileName)
        val storedValue = day2Dive.dive(input, true)

        assertEquals(1842742223, storedValue)
    }
}