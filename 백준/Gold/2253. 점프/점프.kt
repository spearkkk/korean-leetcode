fun main() {
    /**
     * 최소 점프 횟수가 답이기 때문에 회수가 작은 위치를 먼저 처리한다.
     * -> min-heap
     * 
     * 핵심은 위치에 도달했을 때, 위치만 고려하지 않고 속도를 같이 고려해야한다.
     * 왜냐하면 위치와 속도에 따라서 점프할 수 있는 상태가 다르다.
     * (위치, 속도)가 하나의 유일한 상태로 봐야한다.
     * 배열로 이 상태를 저장하기 보다는 set으로 관리한다.
     * 
     */
    fun solution(n: Int, x: MutableSet<Int>): Int {
        // (count, (index, velocity))
        val pq = java.util.PriorityQueue<Pair<Int, Pair<Int, Int>>>(compareBy { it.first })

        pq.add(Pair(0, Pair(1, 0)))

        val visited = mutableSetOf<Pair<Int, Int>>()

        while (pq.isNotEmpty()) {
            val (count, tmp) = pq.poll()
            val (index, velocity) = tmp

            if (visited.contains(tmp)) {
                continue
            }

            if (x.contains(index)) {
                continue
            }

            if (index == n) {
                return count
            }

            val dec = velocity - 1
            val inc = velocity + 1

            if (index + dec <= n && dec > 0) {
                pq.add(Pair(count + 1, Pair(index + dec, dec)))
            }

            if (index + inc <= n && inc > 0) {
                pq.add(Pair(count + 1, Pair(index + inc, inc)))
            }

            if (index + velocity <= n && velocity > 0) {
                pq.add(Pair(count + 1, Pair(index + velocity, velocity)))
            }
            visited.add(tmp)
        }

        return -1
    }

    val (n, m)  = readln().split(" ").map { it.toInt() }

    val x = mutableSetOf<Int>()
    for (i in 1 .. m) {
        x.add(readln().toInt())
    }
    println(solution(n, x))
}