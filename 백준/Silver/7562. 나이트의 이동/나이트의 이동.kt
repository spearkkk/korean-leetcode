fun main() {
    val answer = StringBuilder()

    val dirY = intArrayOf(2, 2, 1, 1, -2, -2, -1, -1)
    val dirX = intArrayOf(1, -1, 2, -2, 1, -1, 2, -2)

    repeat(readInt()) {
        val n = readInt()
        val (curY, curX) = readInts()
        val (targetY, targetX) = readInts()

        val visited = Array(n) { BooleanArray(n) }

        var cnt = 0
        val queue = arrayListOf(Pair(curY, curX))
        val anotherQueue = arrayListOf<Pair<Int, Int>>()

        while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
            // n번째 움직이는 것을 마킹하기 위해 또 다른 큐를 사용함. 현재 n번째 움직이는 큐의 좌표가 다 없어지면 n+1번째 움직이는 좌표로 넣어줌
            if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
                queue.addAll(anotherQueue)
                anotherQueue.clear()
                cnt += 1
            }

            val (y, x) = queue.removeFirst()

            // 이미 방문한 좌표는 보지 않는다. 여러 좌표에서 동일한 좌표로 올 수 있기 때문에 미리 체크해야 함
            if (visited[y][x]) {
                continue
            }

            visited[y][x] = true

            if (y == targetY && x == targetX) {
                break
            }

            for (i in 0 until 8) {
                val ny = y + dirY[i]
                val nx = x + dirX[i]

                if (ny < 0 || ny >= n || nx < 0 || nx >= n) {
                    continue
                }

                anotherQueue.add(Pair(ny, nx))
            }
        }

        answer.append(cnt)
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