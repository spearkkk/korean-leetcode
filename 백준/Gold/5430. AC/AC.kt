fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }

typealias HeightToNumber = Pair<Int, Int>

fun main() {
    fun solve() {
        val funcs = readStr()
        val n = readInt()

        fun parse(raw: String): List<Int> {
            if (n == 0) {
                return emptyList()
            }
            return raw.slice(1 until  raw.length - 1).split(",").map { it.toInt() }.toList()
        }
        val numbers = parse(readStr())

        var isHead = true

        var s = 0
        var e = n - 1

        fun d(): Boolean {
            if (s > e) {
                return false
            }
            if (isHead) {
                s += 1
            } else {
                e -= 1
            }
            return true
        }

        fun r() {
           isHead = !isHead
        }

        for (f in funcs) {
            if (f == 'R') {
                r()
            } else if(f == 'D') {
                if (!d()) {
                    println("error")
                    return
                }
            }
        }

        val answer = if (isHead) numbers.slice(s .. e) else numbers.slice(s .. e).reversed()
        println(answer.joinToString(",", "[", "]"))
    }

    repeat(readInt()) {
        solve()
    }
}