fun main() {
    val word = readStr()
    val cnt = readInt()

    val holder = java.util.LinkedList<Char>()
    word.forEach {
        holder.add(it)
    }

    val cursor = holder.listIterator(holder.size)

    repeat(cnt) {
        when(val m = readStr()) {
            "L" -> {
                if (cursor.hasPrevious()) {
                    cursor.previous()
                }
            }
            "D" -> {
                if (cursor.hasNext()) {
                    cursor.next()
                }
            }
            "B" -> {
                if (cursor.hasPrevious()) {
                    cursor.previous()
                    cursor.remove()
                }
            }
            else -> {
                cursor.add(m[2])
            }
        }
    }

    println(holder.joinToString(""))
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }