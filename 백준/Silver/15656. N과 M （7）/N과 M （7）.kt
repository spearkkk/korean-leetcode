fun main() {
    val (n, m) = readInts()
    val numbers = readInts().sorted()

    val answer = IntArray(m) // 선택한 수를 저장하는 배열

    val stringBuilder = StringBuilder()

    fun bt(count: Int) {
        if (count == m) {
            stringBuilder.append(answer.joinToString(" ")) // 결과를 바로 출력하지 않고 스트링 빌더를 이용한다.
            stringBuilder.append("\n")
            return
        }

        for (idx in 0 until n) {
            val tmp = numbers[idx]

            answer[count] = tmp
            bt(count + 1)
        }

    }

    bt(0)
    println(stringBuilder)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }