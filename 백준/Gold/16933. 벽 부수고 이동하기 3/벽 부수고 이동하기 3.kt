fun main() {
    val dirY = intArrayOf(1, 0, -1, 0)
    val dirX = intArrayOf(0, 1, 0, -1)

    fun isAvailable(y: Int, x: Int, n: Int, m: Int): Boolean {
        return y in 0 until n && x in 0 until m
    }

    val (n, m, k) = readInts()

    val mat = Array(n) { IntArray(m) }
    for (y in 0 until n) {
        val tmp = readStr()
        for (x in 0 until m) {
            mat[y][x] = tmp[x].code - '0'.code
        }
    }
    /**
     * ref.) 
     * - https://github.com/encrypted-def/basic-algo-lecture/blob/master/0x09/solutions/16933.cpp
     * - https://yabmoons.tistory.com/215
     * 
     * 기존에 풀던 방식 처럼 another queue를 만들어 다음 스테이지로 넘어가는 방식으로 진행했지만,
     * 시간 초과를 통과할 수 없었다.
     * visited 확인을 제대로 해야했지만 정확하게 파악하지 못했다.
     * 
     * 지금 이 풀이는 another queue를 두지 않고 이동한 count를 같이 좌표에 놓고 다니는 상황이다.
     * 당연히 이동한 순서가 낮은 것부터 처리가 되기 때문에 마지막에 도달한 순간이 답이 될 수 있다.
     * 
     * visited 확인은 (y, x) 위치에서 hasK만큼 부순 순간이 있었는지 확인한다.
     * 이미 (y, x) 위치에서 0번, 1번, ... 최대 k번까지 부술 수 있을 텐데, 이미 부순 이력이 있으면 더 이상 진행하지 않는다.
     * 핵심은 낮인 상황에서 hasK번 부순 상태에서 확인할 떄, vistied[ny][nx][hasK + 1]의 진행 여부를 확인하는 것이다.
     * 부수려고 봤더니 이미 누가 hasK + 1번 부순 이력이 있으면 똑같은 과정이 반복이 되니깐 말이다.
     * 낮이고 밤이고 중요하지 않고 (y, x)에서 hasK번 부순 이력이 중요하다. 
     * 이 부분을 캐치하지 못해서 시간 초과가 났을 것 같다.
     * 
     * 단, 밤이라서 한번 스테이 하는 상황에는 visited 값을 변경하지 않고 그냥 스테이하는 것이다. 물론 count는 증가시킨다.
     */
    
    // Point: (((y, x) -> k) -> isDay) -> count
    val queue = java.util.ArrayDeque<Point>()

    val visited = Array(n) { Array(m) { BooleanArray(k + 1) } }

    // initialize first point (1, 1)
    queue.add(Pair(Pair(Pair(Pair(0, 0), 0), true), 1))

    // bfs
    while (queue.isNotEmpty()) {
        val point = queue.removeFirst()
        val (tmp, cnt) = point
        val (tmp1, isDay) = tmp
        val (tmp2, hasK) = tmp1
        val (y, x) = tmp2

        if (y == n - 1 && x == m - 1) {
            println(cnt)
            return
        }

        for (i in 0 until 4) {
            val ny = y + dirY[i]
            val nx = x + dirX[i]

            if (!isAvailable(ny, nx, n, m)) {
                continue
            }

            // 벽이 아니라면 그냥 부수지 않고 진행한다.
            if (mat[ny][nx] == 0) {
                // 이미 방문한 이력이 있으면 진행하지 않는다.
                if (visited[ny][nx][hasK]) {
                    continue
                }
                visited[ny][nx][hasK] = true
                
                queue.add(Pair(Pair(Pair(Pair(ny, nx), hasK), !isDay), cnt + 1))
            } else {
                // 벽이라면 여태 부순 횟수와 최대로 부술 수 있는 k번 횟수를 확인한다.
                if (hasK < k) {
                    
                    // 부수기 전에 (y, x) 위치에서 hasK + 1 번 부순 이력이 있으면 진행하지 않는다. 이미 진행했기 때문이다.
                    if (visited[ny][nx][hasK + 1]) {
                        continue
                    }

                    // 낮이면 바로 부순다.
                    if (isDay) {
                        visited[ny][nx][hasK + 1] = true
                        queue.add(Pair(Pair(Pair(Pair(ny, nx), hasK + 1), false), cnt + 1))
                    } else {
                        // 밤이면 부수지 않고 기다린다. 다음차례에 부술거니깐 visited 도 가만히 둔다.
                        queue.add(Pair(Pair(Pair(Pair(y, x), hasK), true), cnt + 1))
                    }
                }
            }
        }
    }

    println(-1)
}

typealias Point = Pair<Pair<Pair<Pair<Int, Int>, Int>, Boolean>, Int>

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }