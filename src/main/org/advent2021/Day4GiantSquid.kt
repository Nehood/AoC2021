package org.advent2021

import org.advent2021.data.Day4BingoBoard

class Day4GiantSquid {

    fun playBingo(input: List<String>): Int {
        val numbers = input[0].split(',').map { it.toInt() }

        val bingos = input
                .drop(1)
                .filter { it.isNotEmpty() }
                .chunked(Day4BingoBoard.BOARD_SIZE)
                .map { Day4BingoBoard(it) }

        for (number in numbers) {
            for (board in bingos) {
                if (board.bingo(number)) {
                    return board.getSumOfUnmarked() * number
                }
            }
        }
        return -1
    }

    fun playBingoLetSquidWin(input: List<String>): Int {
        val numbers = input[0].split(',').map { it.toInt() }

        val bingos = input
                .drop(1)
                .filter { it.isNotEmpty() }
                .chunked(Day4BingoBoard.BOARD_SIZE)
                .map { Day4BingoBoard(it) }
                .toMutableList()

        for (number in numbers) {
            val wonBingos = mutableListOf<Day4BingoBoard>()
            if (bingos.size > 1) {
                for (board in bingos) {
                    if (board.bingo(number)) {
                        wonBingos.add(board)
                    }
                }
            } else {
                if (bingos[0].bingo(number)) {
                    return bingos[0].getSumOfUnmarked() * number
                }

            }
            bingos.removeAll(wonBingos)
        }
        return -1
    }
}