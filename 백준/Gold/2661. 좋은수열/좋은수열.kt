fun main() {
    val arr = intArrayOf(1, 2, 3)

    val n = readInt()

    fun check(number: String): Boolean {
        val anotherNumber = number
        val l = anotherNumber.length / 2

        for (len in 1 .. l) {
            // 0 until len
            // len until len + len
            for (idx in 0 until anotherNumber.length - 1) {
                if (idx + len + len > anotherNumber.length) {
                    continue
                }
                val left = anotherNumber.slice(idx until idx + len)
                val right = anotherNumber.slice(idx + len until idx + len + len)

                if (left == right) {
                    return false
                }
            }
        }
        return true
    }

    var flg = false

    fun bt(cnt: Int, cur: String) {
        if (cnt == n) {
            if (check(cur)) {
                println(cur)
                flg = true
            }
            return
        }

        for (elem in arr) {
            val tmp = cur + elem

            if (check(tmp)) {
                bt(cnt + 1, tmp)
            }

            if (flg) {
                return
            }
        }
    }

    bt(0, "")
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()