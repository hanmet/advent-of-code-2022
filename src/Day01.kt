import java.util.regex.Pattern

fun main() {
    fun part1(input: String): Int {
        return input.split(Pattern.compile("\n\n"))
            .map { line -> line.split("\n").map { num -> num.toInt() } }
            .map { it.sum() }
            .max()
    }

    fun part2(input: String): Int {
        return input.split(Pattern.compile("\n\n"))
            .map { line -> line.split("\n").map { num -> num.toInt() } }
            .map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readText("Day01_test")
    check(part1(testInput) == 24000)

    val input = readText("Day01")
    println(part1(input))
    println(part2(input))
}
