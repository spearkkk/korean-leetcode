fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val n = readInt()
    val m = n

    fun isAvailable(y: Int, x: Int): Boolean {
        return y in 0 until n && x in 0 until m
    }

    val mat = Array(n) { IntArray(m) }

    // initialize
    for (y in 0 until n) {
        mat[y] = readInts().toIntArray()
    }

    val queue = java.util.LinkedList<Pair<Pair<Int, Int>, Int>>()
    val anotherQueue = mutableSetOf<Pair<Pair<Int, Int>, Int>>()
    val visited = Array(n) { BooleanArray(m) }

    // 이미 육지를 주어진 mark 값으로 채운다.
    // 육지 별로 서로 다른 마킹
    fun dfs(y: Int, x: Int, mark: Int) {
        if (visited[y][x]) {
            return
        }
        if (mat[y][x] == 0) {
            return
        }

        visited[y][x] = true
        mat[y][x] = mark

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx)) {
                continue
            }

            if (mat[ny][nx] == 0) {
                anotherQueue.add(Pair(Pair(ny, nx), mark)) // 현재 육지에 인접한 바다를 넣는다.
                continue
            }
            dfs(ny, nx, mark)
        }
    }

    // dfs로 각 육지별 마킹하기
    var mark = 2
    for (y in 0 until n) {
        for(x in 0 until m) {
            if (visited[y][x]) {
                continue
            }

            if (mat[y][x] == 1) {
                dfs(y, x, mark)
                mark += 1
            }
        }
    }

    var cnt = 0
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
            for (elem in anotherQueue) {
                val (point, marked) = elem
                val (y, x) = point

                // 이미 방문한 경우
                if (visited[y][x]) {
                    // 같은 육지로 마킹 된 상황이면 그냥 넘긴다.
                    if (mat[y][x] == marked) {
                        continue
                    }
                    // 같은 육지가 아니라면 이미 다른 영토이기 때문에 끝을 낸다.
                    // 이 같은 경우는 다음 스테이지로 넘어가기 전에 이미 누군가의 영토이기 때문에
                    // 경로는 시간 * 2
                    println(cnt * 2)
                    return
                }

                queue.add(elem)
            }

            if (queue.isEmpty()) {
                break
            }
            cnt += 1
        }

        val (point, marked) = queue.removeFirst()
        val (y, x) = point

        // 이미 방문했다면 확인한다.
        if (visited[y][x]) {
            // 방문한 값이 다른 영토라면 끝을 낸다.
            // 이는 현재 스테이지가 진행되고 있었기 때문에
            // 시간 * 2 - 1
            // 왜냐하면 현재 스테이지 중에 먼저 처리한 곳에 마킹을 하고
            // 같은 스테이지에서 다른 곳을 처리하려고 보니 마킹이 되었기 때문이다.
            // 즉, 현재 스테이지에서 두 영토가 빈 영토에 같이 도착한 경우
            if (mat[y][x] != marked) {
                println(cnt * 2 - 1)
                return
            }
            continue
        }
        visited[y][x] = true
        mat[y][x] = marked

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx)) {
                continue
            }

            if (mat[ny][nx] != marked) {
                anotherQueue.add(Pair(Pair(ny, nx), marked))
            }
        }
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }