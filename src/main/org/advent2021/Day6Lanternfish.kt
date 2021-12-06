package org.advent2021

import java.math.BigInteger

class Day6Lanternfish {

    fun countLanternfishSpawningForNDays(initialState: IntArray, days: Int): BigInteger {
        val currentState = initialState.toMutableList()
        for (i in 0 until days){
            var newCount = 0
            for (j in 0..currentState.lastIndex){
                --currentState[j]
                if (0 == currentState[j]) {
                    ++newCount
                }
            }
        }
        return 0.toBigInteger()
    }
}