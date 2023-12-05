fun main() {
    val (n, m) = readInts()

    val answer = IntArray(m) // 선택한 수를 저장하는 배열

    val stringBuilder = StringBuilder()

    fun bt(count: Int, base: Int) {
        if (count == m) {
            stringBuilder.append(answer.joinToString(" ")) // 결과를 바로 출력하지 않고 스트링 빌더를 이용한다.
            stringBuilder.append("\n")
            return
        }

        for (idx in base .. n) { // 1부터 n까지 중복 선택이 가능하다.
            answer[count] = idx // 현재 값을 선택한다.
            bt(count + 1, idx) // 현재 값을 선택하고 다음 값을 선택한다.
        }

    }

    bt(0, 1)
    println(stringBuilder)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }