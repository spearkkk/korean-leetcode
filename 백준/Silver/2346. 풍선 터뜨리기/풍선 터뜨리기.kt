fun main() {
    val n = readInt()

    val queue = java.util.ArrayDeque(readInts().withIndex().toList())

    val answer = ArrayList<Int>(n)

    while (true) {
        val cur = queue.remove()
        answer.add(cur.index + 1)

        if (queue.isEmpty()) {
            break
        }

        if (cur.value > 0) {
            repeat(cur.value - 1) {
                queue.add(queue.remove())
            }
        } else {
            repeat(cur.value * -1) {
                queue.addFirst(queue.removeLast())
            }
        }
    }

    println(answer.joinToString(" "))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }