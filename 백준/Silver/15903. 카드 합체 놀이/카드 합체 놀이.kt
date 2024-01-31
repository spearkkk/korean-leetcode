fun main() {
    val (n, m) = readInts()

    val cards = java.util.PriorityQueue<Long>()
    cards.addAll(readLongs())

    for (i in 0 until m) {
        val left = cards.remove()
        val right = cards.remove()

        cards.add(left + right)
        cards.add(left + right)
    }

    println(cards.sum())
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }