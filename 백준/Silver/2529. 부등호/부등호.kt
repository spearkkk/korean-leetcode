fun main() {
    val n = readInt()

    val operators = readStrings()

    val nums = (0 .. 9).toList().toIntArray()
    val visited = BooleanArray(10) { false }

    val answer = IntArray(n + 1)

    var min = Long.MAX_VALUE
    var max = Long.MIN_VALUE

    fun bt(cursor: Int) {
        if (cursor == n + 1) {
            for (idx in 0 until n) {
                val left = answer[idx]
                val right = answer[idx + 1]
                val op = operators[idx]

                if ("<" == op && left > right) {
                    return
                }

                if (">" == op && left < right) {
                    return
                }
            }

            val tmp = answer.joinToString("").toLong()

            if (tmp < min) {
                min = tmp
            }

            if (max < tmp) {
                max = tmp
            }

            return
        }

        for (idx in nums.indices) {
            if (visited[idx]) {
                continue
            }

            visited[idx] = true
            answer[cursor] = nums[idx]
            bt(cursor + 1)

            visited[idx] = false
        }
    }

    bt(0)
    println("%0${n + 1}d".format(max))
    println("%0${n + 1}d".format(min))
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

fun deepCopy(source: Array<IntArray>, dest: Array<IntArray>) {
    for (y in source.indices) {
        for (x in 0 until source[y].size) {
            dest[y][x] = source[y][x]
        }
    }
}