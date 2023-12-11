
fun main() {
    val n = readInt()
    val line = readStr()

    val stack = ArrayList<Double>()
    val charToInt = mutableMapOf<Char, Int>()

    val ops = setOf('*', '/', '+', '-')
    for (c in line) {
        if (ops.contains(c)) {
            val right = stack.removeLast()
            val left = stack.removeLast()

            when (c) {
                '*' -> {
                    stack.add(left * right)
                }
                '/' -> {
                    stack.add(left / right)
                }
                '+' -> {
                    stack.add(left + right)
                }
                '-' -> {
                    stack.add(left - right)
                }
            }
        } else {
            if (!charToInt.contains(c)) {
                charToInt[c] = readInt()
            }
            charToInt[c]?.toDouble()?.let { stack.add(it) }
        }
    }

    println("%.2f".format(stack.removeLast()))
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()