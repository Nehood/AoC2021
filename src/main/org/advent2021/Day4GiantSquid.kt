package org.advent2021

class Day4GiantSquid {

    val BOARD_SIZE = 5

    fun playBingo(input: List<String>): Int{
        //input.forEach { println(it) }
        val numbers = input[0].split(',').map { it.toInt() }

        val bingos = input
                .drop(1)    // skip first element (numbers)
                .filter { it.isNotEmpty() }
                .chunked(BOARD_SIZE)    // size +1  because we are also reading emptyline
        bingos.forEach {
            it.forEach {
                print("$it ")
            }
            println("next")
        }
        return 0
    }
}