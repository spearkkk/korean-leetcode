fun main() {

    val (n, m) = readInts()

    val stncs = Array(n) { "" }

    val prefix = "anta"
    val suffix = "tica"

    for (idx in 0 until n) {
        val tmp = readStr()
        stncs[idx] = tmp.removePrefix(prefix).removeSuffix(suffix)
    }

    val alph = BooleanArray(26) { false }

    fun check(stnc: String): Boolean {
        for (c in stnc) {
            val idx = c.code - 'a'.code
            if (!alph[idx]) {
                return false
            }
        }
        return true
    }

    alph['a'.code - 'a'.code] = true
    alph['n'.code - 'a'.code] = true
    alph['t'.code - 'a'.code] = true
    alph['i'.code - 'a'.code] = true
    alph['c'.code - 'a'.code] = true
    // 5

    if (m - 5 < 0) {
        println(0)
        return
    }

    var max = 0
    fun bt(cnt: Int, base: Int) {
        if (cnt == m) {
            var tmp = 0
            for (stnc in stncs) {
                if (check(stnc)) {
                    tmp += 1
                }
            }

            if (max < tmp) {
                max = tmp
            }
            return
        }

        for (idx in base until 26) {
            if (alph[idx]) {
                continue
            }

            alph[idx] = true
            bt(cnt + 1, idx + 1)

            alph[idx] = false
        }
    }

    bt(5, 0)
    println(max)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }