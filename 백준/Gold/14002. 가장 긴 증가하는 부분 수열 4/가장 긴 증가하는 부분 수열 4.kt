fun main() {

    val d = IntArray(1_000 + 1) // d[k]: k 위치의 수를 포함한 가장 긴 수열의 길이
    val c = IntArray(1_000 + 1) // c[k]: k 위치의 수를 포함한 가장 긴 수열의 앞 원소의 인덱스

    val n = readInt()
    val aa = readInts().toMutableList()
    aa.add(0, 1_000 + 1_000) // 1번째 인덱스에서 0번째 인덱스를 고려하지 않게 하기 위해
    val a = aa.toIntArray()

    for (k in 1 .. n) {
        var tmp = 0
        for (j in 1 until k) {
            if (a[j] < a[k] && d[tmp] < d[j]) { // a[k] 보다 작아야하고 그 중안 가장 긴 수열을 가져와야 한다.
                tmp = j
            }
        }

        d[k] = d[tmp] + 1
        c[k] = tmp
    }

    var answer = n
    for (i in n - 1 downTo 1) {
        if (d[answer] < d[i]) {
            answer = i
        }
    }

    println(d[answer])

    var idx = answer
    val numbers = arrayListOf<Int>()
    while (true) {
        numbers.add(0, a[idx])
        if (c[idx] == 0) {
            break
        }
        idx = c[idx]
    }

    println(numbers.joinToString(" "))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }