fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

typealias HeightToNumber = Pair<Int, Int>

fun main() {
    /**
     * 암호코드를 순차적으로 해석한다고 생각하자.
     * Case 1). 암호코드 하나를 복호화했다면 다음 암호코드를 붙여서 복호화 가능한지 알아봐야한다.
     * Case 2). 그런데 이미 암호코드 두개를 복호화했다면 다음 암호코드를 붙여서 복호화를 할 수 없다.
     *
     * dp[y][x] : y 길이의 암호코드를 복호화하는데 마지막에 x개의 암호코드를 복호화했을 때의 가질 수 있는 개수
     * x: 0 -> 한 개의 암호코드를 복호화 했을 때
     * x: 1 -> 두 개의 암호코드를 복호화 했을 때
     *
     * dp[y][0]: dp[y - 1][0] + dp[y - 1][1], if mat[y] 복호화 가능할 때
     * dp[y][1]: dp[y - 2][0] + dp[y - 2][1], if mat[y - 1]mat[y] 복호화 가능할 때
     */

    val codes = readStr()
    val n = codes.length
    val mat = IntArray(n)
    val dp = Array(n) { IntArray(2) }
    for (i in codes.indices) {
        mat[i] = codes[i].code - '0'.code
    }
    if (n == 0) {
        println(0)
        return
    }

    fun couldBeDecoded(code: Int): Boolean {
        return code in 1 .. 26
    }

    dp[0][0] = if (couldBeDecoded(mat[0])) 1 else 0
    if (n == 1) {
        println(dp[0][0])
        return
    }

    if (couldBeDecoded(mat[1])) {
        dp[1][0] = dp[0][0]
    }
    if (mat[0] != 0 && couldBeDecoded(mat[0] * 10 + mat[1])) {
        // mat[0] != 0, 01와 같은 암호코드를 처리하기 위해
        dp[1][1] = 1
    }

    fun mod(code: Int): Int {
        return code % 1_000_000
    }

    for (y in 2 until n) {
        if (couldBeDecoded(mat[y])) {
            dp[y][0] = mod(dp[y - 1][0] + dp[y - 1][1])
        }
        if (mat[y - 1] != 0 && couldBeDecoded(mat[y - 1] * 10 + mat[y])) {
            // mat[y - 1] != 0, 01와 같은 암호코드를 처리하기 위해
            dp[y][1] = mod(dp[y - 2][0] + dp[y - 2][1])
        }
    }

//    for (i in 0 until n) {
//        println("dp[${i}][0]: ${dp[i][0]}, dp[${i}][1]: ${dp[i][1]}")
//    }
    println(mod(dp[n - 1][0] + dp[n - 1][1]))
}