fun main() {
    val n = readInt()

    val holder = Array<Int?>(30000) { null }
    var leftCursor = 30000 / 2
    var rightCursor = leftCursor

    repeat(n) {
        val m = readStrings()
        when(m[0]) {
            "push_front" -> {
                if (holder[leftCursor] != null) {
                    leftCursor -= 1
                }
                holder[leftCursor] = m[1].toInt()
            }
            "push_back" -> {
                if (holder[rightCursor] != null) {
                    rightCursor += 1
                }
                holder[rightCursor] = m[1].toInt()
            }
            "pop_front" -> {
                if (holder[leftCursor] == null) {
                    println(-1)
                } else {
                    println(holder[leftCursor])
                    holder[leftCursor] = null
                    leftCursor += 1
                    if (leftCursor > rightCursor) {
                        rightCursor = leftCursor
                    }
                }
            }
            "pop_back" -> {
                if (holder[rightCursor] == null) {
                    println(-1)
                } else {
                    println(holder[rightCursor])
                    holder[rightCursor] = null
                    rightCursor -= 1
                    if (rightCursor < leftCursor) {
                        leftCursor = rightCursor
                    }
                }
            }
            "front" -> {
                println(if (holder[leftCursor] == null) -1 else holder[leftCursor])
            }
            "back" -> {
                println(if (holder[rightCursor] == null) -1 else holder[rightCursor])
            }
            "size" -> {
                if (leftCursor == rightCursor) {
                    println(if (holder[leftCursor] == null) 0 else 1)
                } else {
                    println(rightCursor - leftCursor + 1)
                }
            }
            "empty" -> {
                if (leftCursor == rightCursor) {
                    println(if (holder[leftCursor] == null) 1 else 0)
                } else {
                    println(0)
                }
            }
        }
    }
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }