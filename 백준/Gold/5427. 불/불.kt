fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val answer = StringBuilder()

    repeat(readInt()) {
        val (m, n) =  readInts()
        val mat = Array(n) { CharArray(m) }

        // (y, x) -> human?
        val queue = java.util.LinkedList<Pair<Pair<Int, Int>, Boolean>>()

        for (y in 0 until n) {
            val tmp = readStr()
            for (x in 0 until m) {
                mat[y][x] = tmp[x]

                if (mat[y][x] == '@') {
                    queue.add(Pair(Pair(y, x), true))
                } else if (mat[y][x] == '*') {
                    queue.add(Pair(Pair(y, x), false))
                }
            }
        }

        val anotherQueue = mutableSetOf<Pair<Pair<Int, Int>, Boolean>>()
        val visited = Array(n) { Array(m) { BooleanArray(2) } }

        fun isExit(y: Int, x: Int): Boolean {
            return y == 0 || y == n - 1 || x == 0 || x == m - 1
        }

        fun isAvailable(y: Int, x: Int): Boolean {
            return y in 0 until n && x in 0 until m
        }

        var flg = false
        var cnt = 1

        while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
            if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
                // next stage
                for (elem in anotherQueue) {
                    val (point, isHuman) = elem
                    val (y, x) = point
                    if (isHuman && (mat[y][x] != '.' || anotherQueue.contains(Pair(Pair(y, x), false)))) {
                        continue
                    }
                    queue.add(elem)
                }
                if (queue.isEmpty()) {
                    // cannot do next stage
                    break
                }
//                println(anotherQueue.joinToString(", "))
//                println(queue.joinToString(", "))
//                println("cnt: $cnt")
                anotherQueue.clear()
                cnt += 1
            }

            val (point, isHuman) = queue.removeFirst()
            val humanIndex = if (isHuman) 1 else 0
            val (y, x) = point

            if (visited[y][x][humanIndex]) {
                continue
            }

            if (isHuman && isExit(y, x)) {
                flg = true
                break
            }

            visited[y][x][humanIndex] = true
            if (!isHuman) {
                mat[y][x] = '*'
            }

//            println("y: $y, x: $x, cnt: $cnt, mat[y][x]: ${mat[y][x]}")

            for (i in 0 until 4) {
                val ny = y + dirY[i]
                val nx = x + dirX[i]

                if (!isAvailable(ny, nx)) {
                    continue
                }

                if (visited[ny][nx][humanIndex]) {
                    continue
                }

                if (isHuman && mat[ny][nx] == '.') {
                    anotherQueue.add(Pair(Pair(ny, nx), true))
                }

                if (!isHuman && (mat[ny][nx] == '.' || mat[ny][nx] == '@')) {
                    anotherQueue.add(Pair(Pair(ny, nx), false))
                }
            }
        }
        answer.append(if (flg) cnt else "IMPOSSIBLE")
        answer.appendLine()
    }

    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }