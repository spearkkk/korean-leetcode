fun main() {
    val (n, m) = readInts()
    val numbers = readInts().sorted()

    val visited = mutableSetOf<Int>()
    val answer = IntArray(m) // 선택한 수를 저장하는 배열

    val stringBuilder = StringBuilder()

    fun bt(count: Int, baseIdx: Int) {
        if (count == m) {
            stringBuilder.append(answer.joinToString(" ")) // 결과를 바로 출력하지 않고 스트링 빌더를 이용한다.
            stringBuilder.append("\n")
            return
        }

        for (idx in baseIdx until n) {
            val tmp = numbers[idx]
            if (visited.contains(tmp)) {
                continue
            }

            visited.add(tmp)
            answer[count] = tmp
            bt(count + 1, idx)

            visited.remove(tmp)
        }

    }

    bt(0, 0)
    println(stringBuilder)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }