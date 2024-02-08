fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    val stack = mutableListOf<Long>()
    val counts = LongArray(80_000 + 1)

    repeat(readInt()) {
        val height = readStr().toLong()

        while (stack.isNotEmpty() && stack.last() <= height) {
            stack.removeLast()
        }
        counts[it] += stack.size + 0L
        stack.add(height)
    }

    println(counts.sum())
}