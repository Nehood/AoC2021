package org.advent2021.data

class Day4BingoBoard {

    companion object {
        var BOARD_SIZE = 5
    }

    private val bingoBoard: Array<IntArray>
    private val numbers: Map<Int, Boolean>
    private val markedNumbers = mutableMapOf<Int, Boolean>()

    constructor(board: List<String>) {
        val currentBoard = Array(BOARD_SIZE) { IntArray(BOARD_SIZE) }
        val currentNumbers = mutableMapOf<Int, Boolean>()
        for ((y, row) in board.withIndex()) {
            row.replace("  ", " ")  // dirty hack for 1 number values
                    .split(' ')
                    .map { it.toInt() }
                    .forEachIndexed { x, i ->
                        currentBoard[y][x] = i
                        currentNumbers[i] = true
                    }
        }

        bingoBoard = currentBoard.clone()
        numbers = currentNumbers.toMap()
    }

    fun bingo(number: Int): Boolean {
        if (!numbers.containsKey(number)) return false
        markedNumbers[number] = true
        if (markedNumbers.size < 5) return false
        return checkForBingo()
    }

    private fun checkForBingo(): Boolean {
        return checkRows().or(checkColumns())
    }

    private fun checkRows(): Boolean {
        return bingoBoard.any { row ->
            row.all { markedNumbers[it] ?: false }
        }
    }

    private fun checkColumns(): Boolean {
        var bingo = true
        for (x in 0..4) {
            for (y in 0..4) {
                bingo = markedNumbers[bingoBoard[y][x]] ?: false
                if (!bingo) break
            }
            if (bingo) break
        }
        return bingo
    }

    fun getSumOfUnmarked(): Int {
        val unmarked = numbers.keys.toMutableList()
        unmarked.removeAll(markedNumbers.keys)
        return unmarked.sum()
    }
}