fun main() {

    repeat(readInt()) {
        val n = 11
        val m = 11

        val board = Array(n) { IntArray(m) { 0 } }
        for (y in 0 until n) {
            board[y] = readInts().toIntArray()
        }

        var answer = 0
        val positionMarker = BooleanArray(m) { false }
        fun bt(y: Int, sum: Int) {
            if (y == n) {
                if (answer < sum) {
                    answer = sum
                }
                return
            }

            for (x in 0 until m) {
                if (positionMarker[x]) {
                    continue
                }
                if (board[y][x] <= 0) {
                    continue
                }

                positionMarker[x] = true
                bt(y + 1, sum + board[y][x])
                positionMarker[x] = false
            }
        }

        bt(0, 0)
        println(answer)
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }