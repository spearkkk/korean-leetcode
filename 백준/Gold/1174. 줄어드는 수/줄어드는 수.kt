fun main() {

    val n = readInt()

    val arr = (0 .. 9L).toMutableList()
    if (n <= 9) {
        println(arr[n - 1])
        return
    }

    var left = 0
    var right = arr.size
    while (true) {
        for (idx in left until right) {
            val base = arr[idx]

            for (jdx in 0 .. 9) {
                if (base % 10 <= jdx) {
                    continue
                }

                val tmp = base * 10 + jdx
                arr.add(tmp)
            }
        }

        if (arr.size > n) {
            break
        }

        if (left >= right) {
            break
        }

        left = right
        right = arr.size
    }

    if (n > arr.size) {
        println(-1)
        return
    }
    println(arr[n - 1])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }