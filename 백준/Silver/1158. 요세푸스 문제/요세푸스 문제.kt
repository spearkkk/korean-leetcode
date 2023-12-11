
fun main() {
    val (n, k) = readInts()

    val sb = java.util.LinkedList<Int>()

    val queue = (1 .. n).toMutableList()

    var cnt = 0
    while (queue.isNotEmpty()) {
        cnt += 1
        val tmp = queue.removeFirst()

        if (cnt == k)  {
            sb.add(tmp)
            cnt = 0
            continue
        }
        queue.add(tmp)
    }

    println(sb.joinToString(", ", "<", ">"))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }

fun zeroFill(cnt: Int, number: Int) = println("%0${cnt}d".format(number))