fun main() {

    fun getIndex(input: String, windowSize: Int): Int {
        return input
            .windowed(windowSize, 1)
            .map { it.toSet() }
            .indexOfFirst { it.size == windowSize } + windowSize
    }

    fun part1(input: String): Int {
        return getIndex(input, 4)

    }

    fun part2(input: String): Int {
        return getIndex(input, 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput[0]) == 11)

    val input = readText("Day06")
    println(part1(input))
    println(part2(input))
}
