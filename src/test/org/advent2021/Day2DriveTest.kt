package org.advent2021

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

internal class Day2DriveTest {

    private val day2Drive = Day2Drive()
    private val inputFileName = "Day8Input.txt"

    private fun readResourceFile(fileName: String): List<String> {
        val resourcesPath = "src/test/resources"
        return File("$resourcesPath/$fileName").readText().split('\n')
    }

    private fun parseInput(input: String): List<String> {
        return input.split('\n')
    }

    @Test
    fun doTestDrive() {
        val input = """forward 5
                        down 5
                        forward 8
                        up 3
                        down 8
                        forward 2"""
        val storedValue = day2Drive.drive(parseInput(input))
        assertEquals(5, storedValue)
    }

    @Test
    fun doTestDrive() {
        val input = """forward 5
                        down 5
                        forward 8
                        up 3
                        down 8
                        forward 2"""
        val storedValue = day2Drive.drive(parseInput(input))
        assertEquals(5, storedValue)
    }
}