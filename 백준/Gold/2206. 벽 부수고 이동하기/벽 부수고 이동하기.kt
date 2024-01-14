fun main() {
    // ref.) https://kscodebase.tistory.com/66
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    val (n, m) = readInts()
    val mat = Array(n) { IntArray(m) }

    for (y in 0 until n) {
        val tmp = readStr()
        for (x in tmp.indices) {
            mat[y][x] = tmp[x].code - '0'.code
        }
    }

    // visited가 2차원 배열이 아니라 3차원 배열이다. 마지막 3차원에는 벽을 부순 이력을 저장한다.
    // visited[y][x][0 or 1]: (y, x) 위치에서 0은 벽을 부순적이 없는 상황, 1은 벽을 부순적이 있는 상황
    // 한번도 벽을 부수지 않을 수 있으나, 이미 한번 부순 이력이 있다면 해당 이력을 계속 가져가야한다.
    val visited = Array(n) { Array(m) { BooleanArray(2) } }

    // (y, x) -> hasBroken
    val queue = java.util.LinkedList<Pair<Pair<Int, Int>, Boolean>>() // 첫번째 원소를 자르는 비용이 많이 발생하지 않기 위해 LinkedList
    queue.add(Pair(Pair(0, 0), false))

    val anotherQueue = mutableSetOf<Pair<Pair<Int, Int>, Boolean>>() // 다음 스테이지 사용할 위치들인데, 중복을 방지하기 위해 set

    var flg = false
    var answer = 1
    var min =  987654321
    while (queue.isNotEmpty() || anotherQueue.isNotEmpty()) {
        if (queue.isEmpty() && anotherQueue.isNotEmpty()) {
            queue.addAll(anotherQueue)
            anotherQueue.clear()
            answer += 1
        }

        val (a, hasBroken) = queue.removeFirst()
        val (y, x) = a

//        println("y: $y, x: $x, hasBroken: $hasBroken, answer: $answer")

        if (visited[y][x][if (hasBroken) 1 else 0]) {
            continue
        }

        if (y == n - 1 && x == m - 1) {
            flg = true
            if (answer < min) {
                min = answer
            }
            continue
        }

        visited[y][x][if (hasBroken) 1 else 0] = true

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                continue
            }

            if (visited[ny][nx][if (hasBroken) 1 else 0]) {
                continue
            }

            if (mat[ny][nx] == 0) {
                anotherQueue.add(Pair(Pair(ny, nx), hasBroken))
            } else {
                if (!hasBroken) {
                    anotherQueue.add(Pair(Pair(ny, nx), true))
                }
            }
        }
    }

    println(if (flg) min else -1)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }