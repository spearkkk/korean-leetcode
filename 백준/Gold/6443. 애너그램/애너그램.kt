import java.util.TreeSet

fun main() {
    val sb = StringBuilder()
    repeat(readInt()) {
        val word = readStr()
        val cToCount = IntArray(26) { 0 }
        for (c in word) {
            cToCount[c.code - 'a'.code] += 1
        }

        val answers = TreeSet<String>()
        var answer = ""

        fun bt(cnt: Int) {
            if (cnt == word.length) {
                if (!answers.contains(answer)) {
                    answers.add(answer)
                }
                return
            }

            for (i in 0 until 26) {
                if (cToCount[i] <= 0) {
                    continue
                }
                cToCount[i] -= 1
                answer += Char(i + 'a'.code)
                bt(cnt + 1)
                cToCount[i] += 1
                answer = answer.slice(0 until answer.length - 1)
            }
        }

        bt(0)
        sb.append(answers.joinToString("\n"))
        sb.appendLine()
    }
    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }