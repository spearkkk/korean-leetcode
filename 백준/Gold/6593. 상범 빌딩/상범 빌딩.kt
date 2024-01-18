fun main() {
    val dirZ = intArrayOf(0, 0, 0, 0, 1, -1)
    val dirY = intArrayOf(1, 0, -1, 0, 0, 0)
    val dirX = intArrayOf(0, 1, 0, -1, 0, 0)

    val answer = StringBuilder()

    while (true) {
        val (h, n, m) =  readInts()
        if (h == 0 && n == 0 && m == 0) {
            break
        }

        val mat = Array(h) { Array(n) { CharArray(m) } }

        // (z, y, x)
        val queue = java.util.LinkedList<Pair<Int, Pair<Int, Int>>>()
        var exit = Pair(-1, Pair(-1, -1))

        for (z in 0 until h) {
            for (y in 0 until n) {
                val tmp = readStr()
                for (x in 0 until m) {
                    mat[z][y][x] = tmp[x]

                    if (mat[z][y][x] == 'S') {
                        queue.add(Pair(z, Pair(y, x)))
                    } else if (mat[z][y][x] == 'E') {
                        exit = Pair(z, Pair(y, x))
                    }
                }
            }
            readStr()
        }


        val anotherQueue = mutableSetOf<Pair<Int, Pair<Int, Int>>>()
        val visited = Array(h) { Array(n) { BooleanArray(m) }}

        fun isExit(z: Int, y: Int, x: Int): Boolean {
            return z == exit.first && y == exit.second.first && x == exit.second.second
        }

        fun isAvailable(z: Int, y: Int, x: Int): Boolean {
            return z in 0 until h && y in 0 until n && x in 0 until m
        }

        var flg = false
        var cnt = 0

        while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
            if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
                queue.addAll(anotherQueue)
                anotherQueue.clear()
                cnt += 1
            }

            val (z, point) = queue.removeFirst()
            val (y, x) = point

            if (visited[z][y][x]) {
                continue
            }

            visited[z][y][x] = true

//            println("z: $z, y: $y, x: $x, exit: $exit")

            if (isExit(z, y, x)) {
                flg = true
                break
            }

            for (i in 0 until 6) {
                val nz = z + dirZ[i]
                val ny = y + dirY[i]
                val nx = x + dirX[i]

                if (!isAvailable(nz, ny, nx)) {
                    continue
                }

                if (visited[nz][ny][nx]) {
                    continue
                }

                if (mat[nz][ny][nx] != '#') {
                    anotherQueue.add(Pair(nz, Pair(ny, nx)))
                }
            }
        }
        answer.append(if (flg) "Escaped in $cnt minute(s)." else "Trapped!")
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