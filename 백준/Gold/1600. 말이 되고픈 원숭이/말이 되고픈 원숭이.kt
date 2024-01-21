fun isAvailable(y: Int, x: Int, n: Int, m: Int): Boolean {
    return y in 0 until n && x in 0 until m
}

fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)
    val horseDirY = intArrayOf(2, 2, 1, 1, -2, -2, -1, -1)
    val horseDirX = intArrayOf(1, -1, 2, -2, 1, -1, 2, -2)


    val k = readInt()
    val (m, n) = readInts()

    val mat = Array(n) { IntArray(m) }

    // initialize
    for (y in 0 until n) {
        mat[y] = readInts().toIntArray()
    }

    // (y, x) -> k
    val queue = java.util.ArrayDeque<Pair<Pair<Int, Int>, Int>>()
    val anotherQueue = mutableSetOf<Pair<Pair<Int, Int>, Int>>()

    val visited = Array(n) { Array(m) { BooleanArray(k + 1) } }

    queue.add(Pair(Pair(0, 0), k))

    var cnt = 0
    var flg = false
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
            queue.addAll(anotherQueue)

//            println("anotherQueue: ${anotherQueue.joinToString(" ")}")
            anotherQueue.clear()
            cnt += 1
        }

        val (point, leftHorseStep) = queue.removeFirst()
        val (y, x) = point

//        println("y: $y, x: $x, leftHorseStep: $leftHorseStep, cnt: $cnt")

        if (visited[y][x][leftHorseStep]) {
            continue
        }

        if (y == n - 1 && x == m - 1) {
            flg = true
            break
        }

        visited[y][x][leftHorseStep] = true

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx, n, m)) {
                continue
            }

            if (mat[ny][nx] == 0) {
                anotherQueue.add(Pair(Pair(ny, nx), leftHorseStep))
            }
        }

        if (leftHorseStep > 0) {
            for (i in 0 until 8) {
                val ny = y + horseDirY[i]
                val nx = x + horseDirX[i]

                if (!isAvailable(ny, nx, n, m)) {
                    continue
                }

                if (mat[ny][nx] == 0) {
                    anotherQueue.add(Pair(Pair(ny, nx), leftHorseStep - 1))
                }
            }
        }
    }
    println(if (flg) cnt else -1)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }