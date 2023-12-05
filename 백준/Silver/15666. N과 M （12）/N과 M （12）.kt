fun main() {
    val (n, m) = readInts()
    val numbers = readInts().sorted()

    val answer = IntArray(m) // 선택한 수를 저장하는 배열
    val archive = mutableSetOf<String>() // 중복 정답 확인할 때 활용

    val stringBuilder = StringBuilder()

    fun bt(count: Int, baseIdx: Int) {
        if (count == m) {
            val tmp = answer.joinToString(" ")
            if (archive.contains(tmp)) { // 중복인지 확인
                return
            }
            archive.add(tmp)
            stringBuilder.append(tmp) // 결과를 바로 출력하지 않고 스트링 빌더를 이용한다.
            stringBuilder.append("\n")
            return
        }

        for (idx in baseIdx until n) {
            val tmp = numbers[idx]

            answer[count] = tmp
            bt(count + 1, idx)
        }

    }

    bt(0, 0)
    println(stringBuilder)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }