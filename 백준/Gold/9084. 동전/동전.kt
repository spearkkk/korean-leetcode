fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

fun main() {
    /**
     * ref.) https://yabmoons.tistory.com/556
     *
     * 위 설명을 보면 진짜 단순하다.
     *
     * dp[k] = k원을 만드는 방법들
     *
     * dp[0] = 0원을 만드는 방법은 한 가지, 이게 핵심이다. 하나도 동전을 갖지 않았을 때 우리는 0원을 만들 수 있다.
     * dp[k] = k원을 만드는 방법은 사용할 수 있는 동전에 따라 다르다.
     * 10원을 사용할 수 있다면 dp[k] = dp[k - 10]이랑 같다. 왜냐하면 k-10원에서 10원을 사용해 k원을 만들 수 있기 때문이다.
     * 단순히 동전을 사용하기 때문에 언제 사용하는지는 무시해야한다.
     *
     */

    val sb = StringBuilder()

    repeat(readInt()) {
        val n = readInt()
        val coins = readInts()
        val m = readInt()

        val dp = IntArray(m + 1)
        dp[0] = 1

        for (i in 0 until n) {
            var coin = coins[i]

            while (coin <= m) {
                dp[coin] = dp[coin] + dp[coin - coins[i]]
                coin += 1
            }
        }
        sb.append(dp[m])
        sb.appendLine()
    }
    println(sb)
}