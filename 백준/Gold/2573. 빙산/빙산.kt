val dirY = intArrayOf(1, 0, -1, 0)
val dirX = intArrayOf(0, 1, 0, -1)

fun isAvailable(y: Int, x: Int, n: Int, m: Int): Boolean {
    return y in 0 until n && x in 0 until m
}

fun main() {

    val (n, m) = readInts()


    val mat = Array(n) { IntArray(m) }

    val queue = java.util.ArrayDeque<Pair<Int, Int>>()
    val anotherQueue = mutableListOf<Pair<Int, Int>>()

    // initialize
    for (y in 0 until n) {
        mat[y] = readInts().toIntArray()
    }

    for (y in 0 until n) {
        for (x in 0 until m) {
            if (mat[y][x] == 0) {
                for (i in 0 until 4) {
                    val ny = y + dirY[i]
                    val nx = x + dirX[i]

                    if (!isAvailable(ny, nx, n, m)) {
                        continue
                    }

                    if (mat[ny][nx] != 0) {
                        anotherQueue.add(Pair(ny, nx))
                    }
                }
            }
        }
    }

//    println(queue.joinToString(" "))

    var cnt = 0
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {

//            println()
//            for (y in 0 until n) {
//                println(mat[y].joinToString(" "))
//            }

            val iceCnt = getIceCnt(n, m, mat)
            if (iceCnt == 0) {
                println(0)
                return
            }

            if (iceCnt != 1) {
                println(cnt)
                return
            }

            for (elem in anotherQueue) {
                val (y, x) = elem

                if (mat[y][x] == 0) {
                    continue
                }

                queue.add(elem)
            }

//            println("queue: ${queue.joinToString(" ")}")

            if (queue.isEmpty()) {
                break
            }
            anotherQueue.clear()
            cnt += 1
        }

        val (y, x) = queue.removeFirst()

        if (mat[y][x] <= 0) {
            continue
        }
        mat[y][x] -= 1

//        println("y: $y, x: $x, mat[y][x]: $mat[y][x]")

        if (mat[y][x] > 0) {
            anotherQueue.add(Pair(y, x))
            continue
        }

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx, n, m)) {
                continue
            }

            if (mat[ny][nx] != 0) {
                anotherQueue.add(Pair(ny, nx))
            }
        }
    }
    println(cnt)
}

fun getIceCnt(n: Int, m: Int, mat: Array<IntArray>): Int {
    val visited = Array(n) { BooleanArray(m) }

    fun dfs(y: Int, x: Int) {
        if (visited[y][x]) {
            return
        }
        if (mat[y][x] == 0) {
            return
        }

        visited[y][x] = true

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx, n, m)) {
                continue
            }
            dfs(ny, nx)
        }
    }

    var iceCnt = 0
    for (y in 0 until n) {
        for(x in 0 until m) {
            if (visited[y][x]) {
                continue
            }

            if (mat[y][x] != 0) {
                dfs(y, x)
                iceCnt +=1
            }
        }
    }

    return iceCnt
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }