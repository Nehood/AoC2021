package org.advent2021

import kotlin.math.abs

class Day7TheTreacheryOfWhales {

    fun alignCrabs(initialPositions: IntArray): Int {
        val positionsSorted = initialPositions.sorted()
        var fuelCostOfAligning = 0
        when (initialPositions.size % 2) {
            0 -> {
                val middleValues = Pair(positionsSorted[positionsSorted.lastIndex / 2], positionsSorted[positionsSorted.lastIndex / 2 - 1])
                fuelCostOfAligning = minOf(alignCrabsToLevel(positionsSorted, middleValues.first), alignCrabsToLevel(positionsSorted, middleValues.second))
            }
            1 -> {
                val middleValue = positionsSorted[positionsSorted.lastIndex / 2]
                fuelCostOfAligning = alignCrabsToLevel(positionsSorted, middleValue)
            }
        }
        return fuelCostOfAligning
    }

    private fun alignCrabsToLevel(positions: List<Int>, level: Int): Int {
        return positions.sumOf { abs(it - level) }
    }

}