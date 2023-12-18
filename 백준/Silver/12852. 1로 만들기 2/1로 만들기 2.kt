fun main() {
    val n = readInt()
    val count = IntArray(n + 1)
    val pre = IntArray(n + 1)

    count[1] = 0
    pre[1] = 0

    for (i in 2 .. n) {
        var currentCount = count[i - 1] + 1
        var currentPre = i - 1

        if (i % 2 == 0 && count[i / 2] + 1 < currentCount) {
            currentCount = count[i / 2] + 1
            currentPre = i / 2
        }

        if (i % 3 == 0 && count[i / 3] + 1 < currentCount) {
            currentCount = count[i / 3] + 1
            currentPre = i / 3
        }

        count[i] = currentCount
        pre[i] = currentPre
    }

    println(count[n])
    var cursor = n
    while (true) {
        print("$cursor ")
        if (cursor == 1) {
            break
        }
        cursor = pre[cursor]
    }
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }