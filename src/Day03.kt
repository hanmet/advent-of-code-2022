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
            loop@ for (leftC in left) {
                for (rightC in right) {
                    if (leftC == rightC) {
                        println("$leftC: ${toPriority(leftC)}")
                        sum += toPriority(leftC)
                        break@loop
                    }
                }
            }
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        val chunks = input.chunked(3)
        for (rucksacks in chunks) {
            loop@ for (charR1 in rucksacks[0]) {
                if (rucksacks[1].contains(charR1) && rucksacks[2].contains(charR1)) {
                    println(charR1)
                    sum += toPriority(charR1)
                    break@loop
                }
            }
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
