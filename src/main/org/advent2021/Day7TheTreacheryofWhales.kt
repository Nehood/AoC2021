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

    fun alignCrabsBruteForce(initialPositions: IntArray): Int {
        val levelCostMap = mutableMapOf<Int, Int>()
        for (level in initialPositions.minOf { it }..initialPositions.maxOf { it }) {
            var cost = 0
            for (position in initialPositions){
                cost += sumNumbers(abs(position - level))
            }
            levelCostMap[level] = cost
        }
        return levelCostMap.values.minOf { it }
    }

    private fun sumNumbers(number: Int): Int {
        var sum = 0
        for (num in 1..number){
            sum += num
        }
        return sum
    }
}

/*
1 - 1
2 - 3
3 - 6
4 - 10
5 - 15
6 - 21
 */