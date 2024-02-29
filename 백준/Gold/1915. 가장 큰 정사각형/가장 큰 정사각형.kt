fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

typealias HeightToNumber = Pair<Int, Int>

fun main() {
    /**
     * dp[y, x] 위치에서 가질 수 있는 최대 크기를 저장한다.
     * dp[y, x]는 mat[y][x] == 1일 때 아래와 같이 구할 수 있다.
     * 1. dp[y-1][x-1]에 저장한 값을 k라고 할 때
     * 2. y 값은 고정 시키고 x값을 loop를 수행하여 mat[y][x] == 1인지 확인한다.
     * 3. x 값은 고정 시키고 y값을 loop를 수행하여 mat[y][x] == 1인지 확인한다.
     * 4. 2번과 3번이 다 참이면 dp[y-1][x-1] + 1 아니면 1
     */
    val (n, m) = readInts()
    val mat = Array(n) { IntArray(m) }

    for (y in 0 until n) {
        val raw = readStr()
        for (x in 0 until m) {
            mat[y][x] = if (raw[x] == '1') 1 else 0
        }
    }

    val dp = Array(n) { IntArray(m) }

    for (y in 0 until n) {
        for (x in 0 until m) {
            if (mat[y][x] == 0) {
                continue
            }

            // cannot build square
            if (y < 1 || x < 1) {
                dp[y][x] = 1
                continue
            }

            // cannot expand square
            if (dp[y - 1][x - 1] == 0) {
                dp[y][x] = 1
                continue
            }

            // expand if possible
            var cnt = 1
            for (k in 1 .. dp[y - 1][x - 1]) {
                if (mat[y][x - k] != 1 || mat[y - k][x] != 1) {
                    break
                }
                cnt += 1
            }
            dp[y][x] = cnt
        }
    }

    var max = 0
    for (y in 0 until n) {
        for (x in 0 until m) {
//            print(dp[y][x])
            if (max < dp[y][x]) {
                max = dp[y][x]
            }
        }
//        println()
    }

    println(max * max)
}