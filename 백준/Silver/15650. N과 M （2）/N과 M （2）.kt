fun main() {
    val (n, m) = readInts()

    val visited = BooleanArray(n + 1) { false } // 1부터 n까지 숫자 중 사용한 숫자를 마킹한다.

    val answer = IntArray(m) // 선택한 수를 저장하는 배열

    fun bt(k: Int, base: Int) {
        if (k == m) {
            println(answer.joinToString(" "))
            return
        }

        for (idx in base .. n) { // base를 두어 앞에서 선택한 수부터 시작한다.
            if (!visited[idx]) { // 1부터 n까지의 숫자 중 선택하지 않은 수라면 해당 수를 선택한다.

                answer[k] = idx
                visited[idx] = true
                bt(k + 1, idx) // 선택한 수를 base로 두어서 선택한 수보다 큰 수를 선택하도록 한다. 

                visited[idx] = false // 선택한 수를 다시 해제해야 한다. 위에서 이미 선택한 결과를 다 출력했기 때문에
            }
        }

    }

    bt(0, 1)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }