fun main() {
    // ref.) https://kscodebase.tistory.com/66
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val (m, n) = readInts()
    val mat = Array(n) { IntArray(m) }

    val queue = java.util.LinkedList<Pair<Int, Int>>()

    for (y in 0 until n) {
        mat[y] = readInts().toIntArray()
        for (x in 0 until m) {
            if (mat[y][x] == 1) { // 이미 익은 토마토부터 시작해야하기 떄문에 초기화 때 확인한다.
                queue.add(Pair(y, x))
            }
        }
    }

    val visited = Array(n) { BooleanArray(m) }
    val anotherQueue = mutableSetOf<Pair<Int, Int>>()

    var cnt = 0
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
//            println("anotherQueue: ${anotherQueue.joinToString(", ")}")
            
            // 넣을 땐, 0이어서 넣었지만 다른 원소를 처리할 때 1로 만들어지는 경우가 있다.
            // queue에 채워넣을 때 한번 더 확인한다.
            // 반례
            // 3 3
            // 1 1 1
            // 0 0 0
            // 0 0 0
            for (elem in anotherQueue) {
                val (y, x) = elem
                if (mat[y][x] == 0) {
                    queue.add(elem)
                }
            }
            anotherQueue.clear()

            if (queue.isEmpty()) {
                break
            }
            cnt += 1
        }

        val (y, x) = queue.removeFirst()

//        println("y: $y, x: $x, cnt: $cnt")

        if (visited[y][x]) {
            continue
        }

        visited[y][x] = true
        mat[y][x] = 1 // 여기에 도달했다는 것은 토마토가 주변에 의해 익었기 떄문이다.

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue
            }

            if (visited[ny][nx]) {
                continue
            }

            if (mat[ny][nx] == 0) {
                anotherQueue.add(Pair(ny, nx))
            }
        }
    }

    for (y in 0 until n) {
        for (x in 0 until m) {
            if (mat[y][x] == 0) {
                println(-1) // 하나라도 익지 않은 토마토가 있을 경우
                return
            }
        }
    }
    println(cnt)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }