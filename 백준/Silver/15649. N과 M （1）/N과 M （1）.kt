fun main() {
    val (n, m) = readInts()

    val visited = BooleanArray(n + 1) { false } // 1부터 n까지 숫자 중 사용한 숫자를 마킹한다.

    val answer = IntArray(m) // 선택한 수를 저장하는 배열

    fun bt(k: Int) {
        if (k == m) {
            println(answer.joinToString(" "))
            return
        }
        
        for (idx in 1 .. n) {
            if (!visited[idx]) { // 1부터 n까지의 숫자 중 선택하지 않은 수라면 해당 수를 선택한다.

                answer[k] = idx
                visited[idx] = true
                bt(k + 1)
                
                visited[idx] = false // 선택한 수를 다시 해제해야 한다. 위에서 이미 선택한 결과를 다 출력했기 때문에
            }
        }

    }

    bt(0)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }