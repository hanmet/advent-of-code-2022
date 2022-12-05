import java.util.*

fun main() {

    fun getTestStacks(): List<Stack<Char>> {
        val stack1 = Stack<Char>()
        stack1.addAll(listOf('Z', 'N'))

        val stack2 = Stack<Char>()
        stack2.addAll(listOf('M', 'C', 'D'))

        val stack3 = Stack<Char>()
        stack3.addAll(listOf('P'))

        return listOf(stack1, stack2, stack3)
    }

    fun getStacks(): List<Stack<Char>> {
        val stack1 = Stack<Char>()
        stack1.addAll(listOf('W', 'D', 'G', 'B', 'H', 'R', 'V'))

        val stack2 = Stack<Char>()
        stack2.addAll(listOf('J', 'N', 'G', 'C', 'R', 'F'))

        val stack3 = Stack<Char>()
        stack3.addAll(listOf('L', 'S', 'F', 'H', 'D', 'N', 'J'))

        val stack4 = Stack<Char>()
        stack4.addAll(listOf('J', 'D', 'S', 'V'))

        val stack5 = Stack<Char>()
        stack5.addAll(listOf('S', 'H', 'D', 'R', 'Q', 'W', 'N', 'V'))

        val stack6 = Stack<Char>()
        stack6.addAll(listOf('P', 'G', 'H', 'C', 'M'))

        val stack7 = Stack<Char>()
        stack7.addAll(listOf('F', 'J', 'B', 'G', 'L', 'Z', 'H', 'C'))

        val stack8 = Stack<Char>()
        stack8.addAll(listOf('S', 'J', 'R'))

        val stack9 = Stack<Char>()
        stack9.addAll(listOf('L', 'G', 'S', 'R', 'B', 'N', 'V', 'M'))

        return listOf(stack1, stack2, stack3, stack4, stack5, stack6, stack7, stack8, stack9)
    }

    fun part1(input: String, stacks: List<Stack<Char>>): String {

        val (crates, rearrangements) = input.split("\n\n")

        rearrangements.split("\n").forEach {
            val count = it.substringBefore("from").substringAfter("move").trim().toInt()
            val from = it.substringAfter("from").substringBefore("to").trim().toInt() -1
            val to = it.substringAfter("to").trim().toInt() -1

            for (i in 0 until count) {
                stacks[to].push(stacks[from].peek())
                stacks[from].pop()
            }
        }

        var result = ""
        stacks.forEach{
            result += it.peek()
        }

        return result
    }

    fun part2(input: String, stacks: List<Stack<Char>>): String {
        val (crates, rearrangements) = input.split("\n\n")

        rearrangements.split("\n").forEach {
            val count = it.substringBefore("from").substringAfter("move").trim().toInt()
            val from = it.substringAfter("from").substringBefore("to").trim().toInt() -1
            val to = it.substringAfter("to").trim().toInt() -1

            val tmpStack = Stack<Char>()
            for (i in 0 until count) {
                tmpStack.push(stacks[from].peek())
                stacks[from].pop()
            }

            for (i in 0 until count) {
                stacks[to].push(tmpStack.peek())
                tmpStack.pop()
            }
        }

        var result = ""
        stacks.forEach{
            result += it.peek()
        }

        return result
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readText("Day05_test")
    check(part1(testInput, getTestStacks()) == "CMZ")

    val input = readText("Day05")
    println(part1(input, getStacks()))
    println(part2(input, getStacks()))
}
