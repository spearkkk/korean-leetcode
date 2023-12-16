fun main() {

    val comparator = Comparator<Int> { left, right ->
        val leftAbs = kotlin.math.abs(left)
        val rightAbs = kotlin.math.abs(right)
        if (leftAbs == rightAbs) {
            left.compareTo(right)
        } else {
            leftAbs.compareTo(rightAbs)
        }
    }

    val pQ = java.util.PriorityQueue(comparator)
    repeat(readInt()) {
        when(val k = readInt()) {
            0 -> {
                println(if (pQ.isEmpty()) 0 else pQ.poll())
            }
            else -> {
                pQ.add(k)
            }
        }
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }