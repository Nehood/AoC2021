package org.advent2021.data

class Day4BingoBoard {

    private val bingoBoard: Array<IntArray>
    private val numbers: Map<Int, Boolean>

    constructor(board: List<String>) {
        val currentBoard = Array(5) { IntArray(5) }
        val currentNumbers = mutableMapOf<Int, Boolean>()
        for ((y, row) in board.withIndex()) {
            row.map { it.toInt() }.forEachIndexed { x, i ->
                currentBoard[y][x] = i
                currentNumbers[i] = true
            }
        }

        bingoBoard = currentBoard.clone()
        numbers = currentNumbers.toMap()
    }
}