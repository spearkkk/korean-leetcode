fun main() {

    val sb = StringBuilder()

    fun dig(k: Int, arr: Array<Int>) {

        val answer = IntArray(6)

        val visited = BooleanArray(arr.size) { false }

        fun bt(cur: Int, cnt: Int) {
            if (cnt == 6) {
                sb.append(answer.joinToString(" "))
                sb.appendLine()
                return
            }

            for (idx in cur until arr.size) {
                if (visited[idx]) {
                    continue
                }

                answer[cnt] = arr[idx]
                visited[idx] = true
                bt(idx + 1, cnt + 1)

                visited[idx] = false
            }
        }

        bt(0, 0)
    }

    while (true) {
        val input = readInts()
        val k = input[0]
        if (k == 0) {
            break
        }

        val arr = input.slice(1 until input.size).toTypedArray()

        dig(k, arr)
        println(sb)
        sb.clear()
    }
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