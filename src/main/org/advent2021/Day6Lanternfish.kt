package org.advent2021

import java.math.BigInteger

class Day6Lanternfish {

    fun countLanternfishSpawningForNDays(initialState: IntArray, days: Int): BigInteger {
        var currentState = initialState
            .toList()
            .groupingBy { it }
            .eachCount()
            .mapValues { it.value.toBigInteger() }
            .toMutableMap()

        for (i in 0..8) {
            currentState.computeIfAbsent(i) { 0.toBigInteger() }
        }

        for (i in 0 until days) {
            var newCount = 0
            val newGeneration = mutableMapOf<Int, BigInteger>()
            for (j in 8 downTo 1) {
                newGeneration[j - 1] = currentState[j]!!
            }
            newGeneration[8] = currentState[0]!!
            newGeneration[6] = currentState[0]!! + newGeneration[6]!!
            currentState = newGeneration.toMutableMap()
        }
        return currentState.map { it.value }.sumOf { it }
    }
}