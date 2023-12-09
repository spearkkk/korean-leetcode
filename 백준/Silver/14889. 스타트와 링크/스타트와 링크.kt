fun main() {
    val n = readInt()

    val board = Array(n) { IntArray(4) { 0 } }

    for (y in 0 until n) {
        board[y] = readInts().toIntArray()
    }

    var min = Int.MAX_VALUE
    val visited = mutableSetOf<Int>() // 선택한 사람을 팀에 넣는다.
    val notVisited = (0 until n).toMutableSet()

    fun bt(cur: Int) {
        if (visited.size == n / 2) { // 선택한 사람이 n / 2 이면 선택하지 않은 사람들끼리 팀이 된다.

            var leftSum = 0
            var rightSum = 0

            // 팀 별로의 능력치 합을 구한다.
            for (y in visited) {
                for (x in visited) {
                    leftSum += board[y][x]
                }
            }

            for (y in notVisited) {
                for (x in notVisited) {
                    rightSum += board[y][x]
                }
            }

            val tmp = kotlin.math.abs(leftSum - rightSum)
            if (tmp < min) {
                min = tmp
            }

            return
        }

        if (cur >= n) {
            return
        }

        visited.add(cur)
        notVisited.remove(cur)
        bt(cur + 1)

        visited.remove(cur)
        notVisited.add(cur)
        bt(cur + 1)
    }

    bt(0)

    println(min)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }