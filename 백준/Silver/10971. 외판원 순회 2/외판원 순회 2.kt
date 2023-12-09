fun main() {

    val n = readInt()

    val board = Array(n) { IntArray(n) { 0 } }
    for (y in 0 until n) {
        board[y] = readInts().toIntArray()
    }

    val visited = BooleanArray(n) { false }
    val answer = IntArray(n)
    var min = Int.MAX_VALUE

    fun bt(cnt: Int) {
        if (cnt == n) {
            var tmp = 0
            for (idx in 0 until n) {
                val w = board[answer[idx]][answer[(idx + 1) % n]]
                if (w == 0) {
                    return
                }
                tmp += w
            }

            if (tmp < min) {
                min = tmp
            }
            return
        }

        for (idx in 0 until n) {
            if (visited[idx]) {
                continue
            }

            visited[idx] = true
            answer[cnt] = idx
            bt(cnt + 1)

            visited[idx] = false
        }
    }

    bt(0)

    println(min)
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