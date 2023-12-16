fun main() {
    val comparator = compareBy<Int> { it }.reversed()
    val pQueue = java.util.PriorityQueue<Int>(comparator)

    val sb = StringBuilder()
    repeat(readInt()) {
        when(val k = readInt()) {
            0 -> {
                if (pQueue.isEmpty()) sb.append(0) else sb.append(pQueue.poll())
                sb.appendLine()
            }
            else -> {
                pQueue.add(k)
            }
        }
    }

    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }