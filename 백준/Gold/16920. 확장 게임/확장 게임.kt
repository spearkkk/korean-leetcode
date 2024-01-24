fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    fun isAvailable(y: Int, x: Int, n: Int, m: Int): Boolean {
        return y in 0 until n && x in 0 until m
    }

    val (n, m, p) = readInts()
    val steps = readInts().toIntArray()
    val counts = IntArray(p)

    val emptyMat = Array(n) { BooleanArray(m) }
    val mat = Array(n) { CharArray(m) }

    val queues = Array(p) { java.util.ArrayDeque<Pair<Pair<Int, Int>, Int>>() }

    for (y in 0 until n) {
        val tmp = readStr()
        for (x in 0 until m) {
            mat[y][x] = tmp[x]
            if(mat[y][x] == '.') {
                emptyMat[y][x] = true
            } else if (mat[y][x] == '#') {
                continue
            } else {
                queues[mat[y][x].code - '1'.code].add(Pair(Pair(y, x), 0))
                counts[mat[y][x].code - '1'.code] += 1
            }
        }
    }

    while (true) {
        var flg = false

        for (i in 1 .. p) {
            val currentQueue = queues[i - 1]
            val anotherQueue = java.util.ArrayDeque<Pair<Pair<Int, Int>, Int>>()

            while (currentQueue.isNotEmpty()) {
                val (point, step) = currentQueue.removeFirst()
                val (y, x) = point

                if (step >= steps[i - 1]) {
                    anotherQueue.add(Pair(Pair(y, x), 0))
                    continue
                }

                for (j in 0 until 4) {
                    val ny = y + dirY[j]
                    val nx = x + dirX[j]

                    if (!isAvailable(ny, nx, n, m)) {
                        continue
                    }

                    if (!emptyMat[ny][nx]) {
                        continue
                    }

                    emptyMat[ny][nx] = false
                    counts[i - 1] += 1
                    currentQueue.add(Pair(Pair(ny, nx), step + 1))

                    flg = true
                }
            }

            queues[i - 1].clear()
            queues[i - 1].addAll(anotherQueue)
        }

        if (!flg) {
            break
        }
    }

    println(counts.joinToString(" "))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }