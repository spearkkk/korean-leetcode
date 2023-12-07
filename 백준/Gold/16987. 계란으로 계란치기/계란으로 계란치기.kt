fun main() {
    val n = readInt()

    val s = arrayListOf<Int>()
    val w = arrayListOf<Int>()
    // s -> w

    repeat(n) {
        val (tmp1, tmp2) = readInts()
        s.add(tmp1)
        w.add(tmp2)
    }

    var max = -1
    var cnt = 0

    fun bt(cur: Int) {
        if (cur == n) { // 다 순회한 후 마지막을 체크한다.
            if (max < cnt) {
                max = cnt
            }
            return
        }

        if (s[cur] <= 0 || cnt == n - 1) { // 현재 계란이 깨졌거나 이미 다깨진 경우 스킵
            bt(cur + 1)
            return
        }

        for (idx in 0 until n) {
            if (idx == cur || s[idx] <= 0) {
                continue
            }


            s[cur] -= w[idx]
            s[idx] -= w[cur]
            if (s[cur] <= 0) {
                cnt += 1
            }
            if (s[idx] <= 0) {
                cnt += 1
            }
            bt(cur + 1)

            if (s[cur] <= 0) {
                cnt -= 1
            }
            if (s[idx] <= 0) {
                cnt -= 1
            }
            s[cur] += w[idx]
            s[idx] += w[cur]
        }
    }

    bt(0)

    println(max)

}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }