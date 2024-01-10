fun main() {
    val left = readStr()
    val right = readStr()

    val d = Array(1_000 + 1) { IntArray(1_000 + 1) }

    for (i in 1 .. left.length) {
        for (j in 1 .. right.length) {
            if (left[i - 1] == right[j - 1]) {
                // 두 위치인 i, j에서의 문자가 같다는 것은 얘를 공통 최장 수열에 넣을 수 있다.
                // 이전에 구했던 공통 최장 수열의 길이에 1를 더한다.
                d[i][j] = d[i - 1][j - 1] + 1
            } else {
                // 서로 같지 않다는 것은 공통 최장 수열에 넣을 수 없다는 것이다.
                // 따라서 이미 구했던 공통 최장 수열의 길이를 넣는다.
                // 그러나 left, right 중에서 만들 수 있기 때문에 둘 중에 큰 값을 넣는다.
                d[i][j] = kotlin.math.max(d[i - 1][j], d[i][j - 1])
            }
        }

    }

    println(d[left.length][right.length])
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }