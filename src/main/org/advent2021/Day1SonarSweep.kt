package org.advent2021

class Day1SonarSweep {
    fun countIncreasingMeasurements(measurements: List<Int>, portionSize: Int = 1): Int {
        return measurements.mapIndexed { index, i ->
            measurements.subList(
                index,
                if (index + portionSize < measurements.size) index + portionSize else measurements.size
            ).sum()
        }.zipWithNext { a, b -> b - a }
            .filter { it > 0 }
            .count()
    }
}