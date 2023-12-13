fun main() {
    val n = readInt()

    val arr = readInts().withIndex().toList()

    val stack = java.util.Stack<IndexedValue<Int>>()

    val answer = IntArray(n)

    for (i in arr.reversed()) {
        while (stack.isNotEmpty() && i.value >= stack.peek().value) {
            val tmp = stack.pop()
            answer[tmp.index] = i.index + 1
        }

        stack.add(i)
    }

    while (stack.isNotEmpty()) {
        val tmp = stack.pop()
        answer[tmp.index] = 0
    }

    println(answer.joinToString(" "))

//    val stack = java.util.Stack<IndexedValue<Int>>()
//    val anotherStack = java.util.Stack<IndexedValue<Int>>()
//
//    val sb = StringBuilder()
//
//    for (nth in readInts().withIndex()) {
//        while (stack.isNotEmpty() && stack.peek().value < nth.value) {
//            anotherStack.add(stack.pop())
//        }
//        if (stack.isNotEmpty()) {
//            sb.append(stack.peek().index + 1)
//            sb.append(" ")
//        } else {
//            sb.append("0 ")
//        }
//
//        while (anotherStack.isNotEmpty()) {
//            stack.add(anotherStack.pop())
//        }
//
//        stack.add(nth)
//    }
//    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }