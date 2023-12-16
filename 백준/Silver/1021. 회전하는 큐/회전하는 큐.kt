fun main() {
    val (n, m) = readInts()

    val deque = (1 .. n).toMutableList()

    fun check(n: Int): Boolean {
        for (i in 0 .. deque.size / 2) {
            if (deque.get(i) == n) {
                return true
            }
        }
        return false
    }

    var count = 0
    for (i in readInts()) {
        if (check(i)) {
            while (deque.first() != i) {
                deque.add(deque.removeFirst())
                count += 1
            }
        } else {
            while (deque.first() != i) {
                deque.add(0, deque.removeLast())
                count += 1

            }
        }
        deque.removeFirst()
    }
    println(count)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }