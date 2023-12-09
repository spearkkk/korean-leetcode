fun main() {

    val n = readInt()

    val answer = IntArray(n)

    val sb = StringBuilder()
    val visited = BooleanArray(n) { false }

    fun bt(cursor: Int) {
        if (cursor == n) {
            sb.append(answer.joinToString(" "))
            sb.appendLine()
            return
        }

        for (idx in 0 until n) {
            if (visited[idx]) {
                continue
            }
            visited[idx] = true
            answer[cursor] = idx + 1
            bt(cursor + 1)

            visited[idx] = false
        }
    }

    bt(0)
    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }


fun max(left: Int, right: Int): Int {
    if (left < right) {
        return right
    }
    return left
}