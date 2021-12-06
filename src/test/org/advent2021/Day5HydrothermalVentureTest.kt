package org.advent2021

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File
import kotlin.test.assertFailsWith

internal class Day5HydrothermalVentureTest {

    private val NEWLINE = '\n'

    private val day5HydrothermalVenture = Day5HydrothermalVenture()
    private val inputFileName = "Day5Input.txt"

    private fun readResourceFile(fileName: String): List<String> {
        val resourcesPath = "src/test/resources"
        val list = mutableListOf<String>()
        File("$resourcesPath/$fileName").forEachLine { list.add(it.trim()) }
        return list
    }

    private fun parseInput(input: String): List<String> {
        return input.split(NEWLINE).map { it.trim() }
    }

    @Test
    fun countOverlapsWithDiagonalsShouldThrowNoSuchElementTest() {
        val input = """0,9 -> 3,8"""
        assertFailsWith<NoSuchElementException>(
                block = { day5HydrothermalVenture.countOverlaps(parseInput(input), true) }
        )
    }

    @Test
    fun countOverlapsTest() {
        val input = """0,9 -> 5,9
                        8,0 -> 0,8
                        9,4 -> 3,4
                        2,2 -> 2,1
                        7,0 -> 7,4
                        6,4 -> 2,0
                        0,9 -> 2,9
                        3,4 -> 1,4
                        0,0 -> 8,8
                        5,5 -> 8,2"""
        val overlapsCount = day5HydrothermalVenture.countOverlaps(parseInput(input))
        val expected = 5
        assertEquals(expected, overlapsCount)
    }

    @Test
    fun countOverlaps() {
        val input = readResourceFile(inputFileName)
        val overlapsCount = day5HydrothermalVenture.countOverlaps(input)
        val expected = 6548
        assertEquals(expected, overlapsCount)
    }

    @Test
    fun countOverlapsWithDiagonalsTest() {
        val input = """0,9 -> 5,9
                        8,0 -> 0,8
                        9,4 -> 3,4
                        2,2 -> 2,1
                        7,0 -> 7,4
                        6,4 -> 2,0
                        0,9 -> 2,9
                        3,4 -> 1,4
                        0,0 -> 8,8
                        5,5 -> 8,2"""
        val overlapsCount = day5HydrothermalVenture.countOverlaps(parseInput(input), true)
        val expected = 12
        assertEquals(expected, overlapsCount)
    }

    @Test
    fun countOverlapsWithDiagonals() {
        val input = readResourceFile(inputFileName)
        val overlapsCount = day5HydrothermalVenture.countOverlaps(input, true)
        val expected = 19663
        assertEquals(expected, overlapsCount)
    }
}