fun main() {

    fun toPriority(c: Char): Int {
        return if (c.isUpperCase()) {
            c.code - 38
        } else {
            c.code - 96
        }
    }


    fun part1(input: List<String>): Int {
        var sum = 0
        for (rucksack in input) {
            val (left, right) = rucksack.chunked(rucksack.length / 2)
            sum += left.toSet().intersect(right.toSet()).sumOf { toPriority(it) }

        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        val chunks = input.chunked(3)
        for (rucksacks in chunks) {
            sum += rucksacks[0].toSet().intersect(rucksacks[1].toSet()).intersect(rucksacks[2].toSet()).sumOf { toPriority(it) }
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
