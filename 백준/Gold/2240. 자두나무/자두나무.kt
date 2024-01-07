fun main() {
    val (t, w) = readInts()

    val p = IntArray(t + 1)
    repeat(t) {
        p[it + 1] = readInt()
    }

    val d = Array(t + 1) { Array(w + 1) { IntArray(3) { 0 } } }
    // d[k][m][l]: k 시점에서 m번의 이동, l위치의 자두를 가진 개수

    for (k in 1 .. t) {

        d[k][0][1] = d[k - 1][0][1] + if (p[k] % 2 == 1) 1 else 0 // 1번 위치에서 한번도 움직이는 않은 경우, k시점에서의 1번 위치에서 떨어진 자두는 다 가질 수 있다.

        // 1부터 최대 w번 까지 이동할 수 있다.
        for (m in 1 .. w) {
            if (m > k) {
                break // k시점에서 이동횟수인 m이 더 클 수 있다. m은 항상 k보다 작거나 같다.
            }

            if (p[k] % 2 == 1) {
                d[k][m][1] = kotlin.math.max(d[k - 1][m - 1][2], d[k - 1][m][1]) + 1 // k - 1 시점에서 2에서 1로 이동하는 경우와 1번에서 그대로 있는 경우를 비교해야 한다. 2에서 1로 이동하는 경우는 m - 1에서 m이 되어야 한다. 왜냐하면 이동했기 때문이다.
                d[k][m][2] = kotlin.math.max(d[k - 1][m - 1][1], d[k - 1][m][2]) // 1번에 자두가 떨어졌기 때문에 2번에 있으면 자두를 얻지 못하기 때문에 1를 더하지 않는다.
            } else {
                d[k][m][1] = kotlin.math.max(d[k - 1][m - 1][2], d[k - 1][m][1])
                d[k][m][2] = kotlin.math.max(d[k - 1][m - 1][1], d[k - 1][m][2]) + 1
            }
        }
    }

    var answer = 0
    
    // 최대 w만큼 이동할 수 있다는 것은 움직이도 않아도 된다는 것이다. 그래서 0부터 w까지 움직인 횟수를 다 확인해봐야 한다.
    for (i in 0 .. w) {
        answer = kotlin.math.max(answer, kotlin.math.max(d[t][i][1], d[t][i][2]))
    }
    println(answer)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }