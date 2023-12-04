fun main() {
    val line = readStr()

    var sum = 0 // 같은 레벨일 때의 합
    var num = 1 // 서로 다른 레벨일 때의 곱

    val stack = arrayListOf<Char>()
    for ((idx, nxt) in line.withIndex()) {
        when (nxt) {
            '(' -> {
                num *= 2 // 새로운 레벨의 시작이라서 2를 곱한다.
                stack.add(nxt)
            }
            '[' -> {
                num *= 3 // 새로운 레벨의 시작이라서 3을 곱한다.
                stack.add(nxt)
            }
            ')' -> {
                if (stack.isEmpty() || stack.last() != '(') {
                    println(0)
                    return
                }

                stack.removeLast()

                if (line[idx - 1] == '(') {
                    sum += num // 이전 괄호랑 쌍이 맞으면 () 형태이기 때문에 더한다.
                }

                num /= 2 // 한 레벨의 끝이므로 곱한 값을 다시 나눠줘야 한다.
            }
            ']' -> {
                if (stack.isEmpty() || stack.last() != '[') {
                    println(0)
                    return
                }

                stack.removeLast()

                if (line[idx - 1] == '[') {
                    sum += num
                }

                num /= 3
            }
        }
    }
    println(if (stack.isEmpty()) sum else 0)
}

fun readStr() = readln()
fun readInt() = readStr().toInt()
fun readStrings() = readStr().split(" ")
fun readInts() = readStrings().map { it.toInt() }