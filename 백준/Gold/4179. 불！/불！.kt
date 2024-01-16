fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val (n, m) = readInts()
    val mat = Array(n) { CharArray(m) }

    // (y, x) -> human?
    val queue = java.util.LinkedList<Pair<Pair<Int, Int>, Boolean>>()

    for (y in 0 until n) {
        val tmp = readStr()
        for (x in 0 until m) {
            mat[y][x] = tmp[x]
            if (mat[y][x] == 'J') {
                queue.add(Pair(Pair(y, x), true))
            }
            if (mat[y][x] == 'F') {
                queue.add(Pair(Pair(y, x), false))
            }
        }
    }

    val visited = Array(n) { Array(m) { BooleanArray(2) } }
    val anotherQueue = mutableSetOf<Pair<Pair<Int, Int>, Boolean>>()

    var flg = false
    var cnt = 1
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
//            println("${anotherQueue.joinToString(", ")}")
            for (elem in anotherQueue) {
                val (point, isHuman) = elem
                val (y, x) = point
                if (isHuman && (visited[y][x][0] || anotherQueue.contains(Pair(Pair(y, x), false)))) {
//                    println("y: $y, x: $x")
                    continue
                }
                queue.add(elem)
            }
//            println("${queue.joinToString(", ")}")
            anotherQueue.clear()
            cnt += 1
        }

        val (point, isHuman) = queue.removeFirst()
        val (y, x) = point
        val humanIndex = if (isHuman) 1 else 0

//        println("y: $y, x: $x, cnt: $cnt")

        if (visited[y][x][humanIndex]) {
            continue
        }

        if (isHuman && (y == 0 || y == n - 1 || x == 0 || x == m - 1)) {
            flg = true
            break
        }

        visited[y][x][humanIndex] = true

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue
            }

            if (visited[ny][nx][humanIndex]) {
                continue
            }

            if (isHuman && mat[ny][nx] == '.') {
                anotherQueue.add(Pair(Pair(ny, nx), true))
            }
            if (!isHuman && mat[ny][nx] != '#') {
                anotherQueue.add(Pair(Pair(ny, nx), false))
            }
        }
    }

    println(if (flg) cnt else "IMPOSSIBLE")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }