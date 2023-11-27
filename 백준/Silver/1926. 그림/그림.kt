
fun main() {
    val reader = java.util.Scanner(System.`in`)

    val n = reader.nextInt()
    val m = reader.nextInt()

    val matrix = Array(n) { Array(m) { 0 } }

    for (dn in 0 until n) {
        for (dm in 0 until m) {
            matrix[dn][dm] = reader.nextInt()
        }
    }

    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, -1, 0, 1)

    val visited = mutableSetOf<Pair<Int, Int>>()

    var count = 0
    var maxArea = 0

    for (dn in 0 until n) {
        for (dm in 0 until m) {
            val cursor = Pair(dn, dm)

            if (visited.contains(cursor) || matrix[dn][dm] == 0) {
                continue
            }

            visited.add(cursor)

            val queue = arrayListOf<Pair<Int, Int>>()
            queue.add(cursor)

            var area = 0

            while (queue.isNotEmpty()) {
                val anotherCursor = queue.removeFirst()
                area +=1

                for (idx in 0 .. 3) {
                    val x = anotherCursor.first + dx[idx]
                    val y = anotherCursor.second + dy[idx]

                    val nextCursor = Pair(x, y)
                    if (visited.contains(nextCursor)) {
                        continue
                    }

                    fun isValid(cursor: Pair<Int, Int>): Boolean {
                        return cursor.first in 0 until n && cursor.second in 0 until m
                    }

                    if (isValid(nextCursor) && matrix[nextCursor.first][nextCursor.second] == 1) {
                        visited.add(nextCursor)
                        queue.add(nextCursor)
                    }
                }
            }

            if (maxArea < area) {
                maxArea = area
            }
            count += 1
        }
    }

    println(count)
    println(maxArea)
}