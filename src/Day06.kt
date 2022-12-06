import java.util.*
import kotlin.streams.asSequence

fun main() {

    fun part1(input: String): Int {
        val windowSize = 4
        return input.chars().asSequence().windowed(windowSize, 1).map { it.toSet() }.indexOfFirst { it.size == windowSize } + windowSize
    }

    fun part2(input: String): Int {
        val windowSize = 14
        return input.chars().asSequence().windowed(windowSize, 1).map { it.toSet() }.indexOfFirst { it.size == windowSize } + windowSize
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput[0]) == 11)

    val input = readText("Day06")
    println(part1(input))
    println(part2(input))
}
