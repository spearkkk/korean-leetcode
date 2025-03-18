fun main() {
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