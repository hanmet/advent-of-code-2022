fun main() {

    fun part1(input: List<String>): Int {
        var sum = 0
        for (i in input) {
            var leftContainsRight = true
            var rightContainsLeft = true
            val sections = i.split(",")
                .map { it.split("-") }
            val left = sections[0][0].toInt()..sections[0][1].toInt()
            val right = sections[1][0].toInt()..sections[1][1].toInt()
            left.forEach{
                if(!right.contains(it)) {
                    rightContainsLeft = false
                }
            }
            right.forEach{
                if(!left.contains(it)) {
                    leftContainsRight = false
                }
            }
            if (leftContainsRight || rightContainsLeft) {
                sum++
            }
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        for (i in input) {
            var overlap = false
            val sections = i.split(",")
                .map { it.split("-") }
            val left = sections[0][0].toInt()..sections[0][1].toInt()
            val right = sections[1][0].toInt()..sections[1][1].toInt()
            left.forEach{
                if(right.contains(it)) {
                    overlap = true
                }
            }

            if (overlap) {
                sum++
            }
        }
        return sum
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
