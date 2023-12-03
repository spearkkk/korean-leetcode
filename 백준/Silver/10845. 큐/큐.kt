fun main() {
    val cnt = readInt()

    val holder = java.util.LinkedList<Int>()

    repeat(cnt) {
        when(val m = readStr()) {
            "pop" -> {
                println(if (holder.isEmpty()) -1 else holder.removeFirst())
            }
            "front" -> {
                println(if (holder.isEmpty()) -1 else holder.first)
            }
            "back" -> {
                println(if (holder.isEmpty()) -1 else holder.last)
            }
            "size" -> {
                println(holder.size)
            }
            "empty" -> {
                println(if (holder.isEmpty()) 1 else 0)
            }
            else -> {
                holder.add((m.split(" ")[1]).toInt())
            }
        }
    }
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }