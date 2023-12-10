fun main() {

    val (n, m) = readInts()

    val arr = Array(n) { ArrayList<Int>() }

    repeat(m) {
        val (y, x) = readInts()
        arr[y].add(x)
        arr[x].add(y)
    }

    val visited = BooleanArray(n) { false }

    var flg = false

    fun bt(cursor: Int, cnt: Int) {
        if (cnt == 4) {
            flg = true
            println(1)
            return
        }

        for (x in arr[cursor]) {
            if (!visited[x]) {
                visited[x] = true
                bt(x, cnt +1)

                visited[x] = false
            }

            if (flg) {
                return
            }
        }
    }

    for (y in 0 until n) {
        visited[y] = true
        bt(y, 0)
        if (flg) {
            return
        }

        visited[y] = false
    }

    println(0)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }