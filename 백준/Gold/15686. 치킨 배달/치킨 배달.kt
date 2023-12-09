fun main() {
    val (n, m) = readInts()

    val houses = mutableListOf<Pair<Int, Int>>()
    val stores = mutableListOf<Pair<Int, Int>>()

    for (y in 0 until n) {
        val tmp = readInts()
        for (x in tmp.indices) {
            if (tmp[x] == 1) {
                houses.add(Pair(y, x))
            } else if (tmp[x] == 2) {
                stores.add(Pair(y, x))

            }
        }
    }

    val visited = BooleanArray(stores.size) { false }

    var min = Int.MAX_VALUE

    fun bt(cur: Int, cnt: Int) {
        if (stores.size - cnt == m) {

            var sum = 0
            for (house in houses) {
                sum += stores.withIndex().filter { !visited[it.index] }
                    .map { it.value }
                    .map { kotlin.math.abs(it.first - house.first) + kotlin.math.abs(it.second - house.second)}.min()
            }

            if (sum < min) {
                min = sum
            }

            return
        }

        for (idx in cur until stores.size) {
            if (visited[idx]) {
                continue
            }

            visited[idx] = true
            bt(idx, cnt + 1)

            visited[idx] = false
        }
    }

    bt(0, 0)

    println(min)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }