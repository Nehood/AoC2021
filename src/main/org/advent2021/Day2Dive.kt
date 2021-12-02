package org.advent2021

class Day2Dive {
    val FORWARD = "forward"
    val DOWN = "down"
    val UP = "up"

    fun dive(instructions: List<String>, aimCorrection: Boolean = false): Long {
        var position = 0L
        var depth = 0L
        var aim = 0L

        instructions.forEach { instruction ->
            val elements = instruction.split(' ')
            val command = elements[0]
            val value = elements[1].toInt()
            when (command) {
                FORWARD -> {
                    position += value
                    if (aimCorrection) depth -= (aim * value)
                }
                DOWN -> {
                    if (aimCorrection) aim -= value
                    else depth += value
                }
                UP -> {
                    if (aimCorrection) aim += value
                    else depth -= value
                }
            }
        }

        return position * depth
    }
}