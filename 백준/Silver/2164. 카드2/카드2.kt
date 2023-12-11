
fun main() {
    val n = readInt()
    val queue = java.util.LinkedList((1 .. n).toList())

    while (queue.size > 2) {
        queue.removeFirst()
        queue.add(queue.removeFirst())
    }

    println(if (queue.size == 2) queue[1] else queue[0])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()