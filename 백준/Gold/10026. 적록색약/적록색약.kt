fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val n = readInt()
    val m = n
    val mat = Array(n) { CharArray(m) }

    for (y in 0 until n) {
        val tmp = readStr()
        for (x in 0 until m) {
            mat[y][x] = tmp[x]
        }
    }

    // 색맹이 '아닌' 사람이 방문한 이력과 색맹인 사람이 방문한 이력을 따로 관리한다.
    val visited = Array(n) { Array(m) { BooleanArray(2) } }
    
    fun bfs(initialY: Int, initialX: Int, color: Char) {
        // (y, x) -> human?
        val queue = java.util.LinkedList<Pair<Pair<Int, Int>, Boolean>>()

        queue.add(Pair(Pair(initialY, initialX), true)) // 색맹이 '아닌' 사람이 아직 못 가본 곳이기 때문에 넣는다.
        if (!visited[initialY][initialX][0]) { // 색맹인 사람이 이전에 이미 가본 곳이라면 넣지 않는다.
            queue.add(Pair(Pair(initialY, initialX), false))
        }

        val anotherQueue = mutableSetOf<Pair<Pair<Int, Int>, Boolean>>()

        while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
            if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
                queue.addAll(anotherQueue)
                anotherQueue.clear()
            }

            val (point, isHuman) = queue.removeFirst()
            val (y, x) = point
            val humanIndex = if (isHuman) 1 else 0

//        println("y: $y, x: $x, cnt: $cnt")

            if (visited[y][x][humanIndex]) {
                continue
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

                if (isHuman && mat[ny][nx] == color) { // 색맹이 '아닌' 사람은 현재 방문하는 색상이랑 같으면 넣을 수 있다.
                    anotherQueue.add(Pair(Pair(ny, nx), true))
                }
                if (!isHuman && mat[ny][nx] == 'B' && color == 'B') { // 색맹인 사람은 파랑색은 구분한다.
                    anotherQueue.add(Pair(Pair(ny, nx), false))
                }
                if (!isHuman && (mat[ny][nx] == 'R' || mat[ny][nx] == 'G') && (color == 'R' || color == 'G')) { // 색맹인 사람은 초록색과 빨강색을 구분하지 못해서 같이 넣는다.
                    anotherQueue.add(Pair(Pair(ny, nx), false))
                }
            }
        }

    }

    var humanCnt = 0
    var nonHumanCnt = 0
    for (y in 0 until n) {
        for (x in 0 until m) {
            if (!visited[y][x][1]) { // 색맹이 '아닌' 사람이 아직 못가본 곳이면 가봐야한다.
                humanCnt += 1
                if (!visited[y][x][0]) { // 색맹인 사람이 이미 가본 곳이라면 카운트하지 않는다.
                    nonHumanCnt += 1
                }
                bfs(y, x, mat[y][x])
            }
        }
    }

    println("$humanCnt $nonHumanCnt")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }