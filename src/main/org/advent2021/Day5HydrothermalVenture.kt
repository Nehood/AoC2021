package org.advent2021

import org.advent2021.data.Day5Line
import kotlin.math.max
import kotlin.math.min

class Day5HydrothermalVenture {

    val ARROW = "->"
    val COMMA = ','

    fun countOverlaps(input: List<String>, HV: Boolean = true): Int {
        val lines = parseLines(input, HV)

        val dimensions = determineDimensions(lines)
        val matrix = Array(dimensions.first + 1) { IntArray(dimensions.second + 1) }

        lines.forEach { drawLine(matrix, it) }
        return countIntersections(matrix)
    }

    private fun parseLines(input: List<String>, HV: Boolean): List<Day5Line> {
        return input.map {
            val coordinates = it.split(ARROW)
            val startingCoordinates = coordinates[0].trim().split(COMMA)
            val endingCoordinates = coordinates[1].trim().split(COMMA)
            Day5Line(startingCoordinates[0].toInt(), startingCoordinates[1].toInt(),
                    endingCoordinates[0].toInt(), endingCoordinates[1].toInt())
        }.filter { if (HV) it.x1 == it.x2 || it.y1 == it.y2 else true }
    }

    private fun determineDimensions(lines: List<Day5Line>): Pair<Int, Int> {
        val xDimension = lines.maxOf { maxOf(it.x1, it.x2) }
        val yDimension = lines.maxOf { maxOf(it.y1, it.y2) }
        return Pair(xDimension, yDimension)
    }

    private fun drawLine(matrix: Array<IntArray>, line: Day5Line) {
        for (x in minOf(line.x1, line.x2)..maxOf(line.x1, line.x2)) {
            for (y in minOf(line.y1, line.y2)..maxOf(line.y1, line.y2)) {
                matrix[y][x]++
            }
        }
    }

    private fun countIntersections(matrix: Array<IntArray>): Int{
        var counter = 0
        for (y in 0..matrix.lastIndex){
            for (x in 0..matrix[y].lastIndex){
                if (matrix[y][x] > 1) ++counter
            }
        }
        return counter
    }
}