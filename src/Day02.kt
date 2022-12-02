fun main() {
    fun calcPoints2(opponentsShape: String, game: String): Int {

        return when {
            opponentsShape == "A" && game == "X" -> 3 + 0
            opponentsShape == "A" && game == "Y" -> 1 + 3
            opponentsShape == "A" && game == "Z" -> 2 + 6
            opponentsShape == "B" && game == "X" -> 1 + 0
            opponentsShape == "B" && game == "Y" -> 2 + 3
            opponentsShape == "B" && game == "Z" -> 3 + 6
            opponentsShape == "C" && game == "X" -> 2 + 0
            opponentsShape == "C" && game == "Y" -> 3 + 3
            opponentsShape == "C" && game == "Z" -> 1 + 6
            else -> -1
        }

    }

    fun calcPoints1(opponentsShape: String, game: String): Int {
        return when {
            opponentsShape == "A" && game == "X" -> 1 + 3
            opponentsShape == "A" && game == "Y" -> 2 + 6
            opponentsShape == "A" && game == "Z" -> 3 + 0
            opponentsShape == "B" && game == "X" -> 1 + 0
            opponentsShape == "B" && game == "Y" -> 2 + 3
            opponentsShape == "B" && game == "Z" -> 3 + 6
            opponentsShape == "C" && game == "X" -> 1 + 6
            opponentsShape == "C" && game == "Y" -> 2 + 0
            opponentsShape == "C" && game == "Z" -> 3 + 3
            else -> -1
        }
    }

    fun part1(input: List<String>): Int {
        return input.sumOf {
            val (opponentsShape, game) = it.split(" ")
            calcPoints1(opponentsShape, game)
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf {
            val (opponentsShape, game) = it.split(" ")
            calcPoints2(opponentsShape, game)
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
