
fun main() {
    val n = readInt()

    val queue = java.util.LinkedList<String>()

    val sb = StringBuilder()

    fun handle(c: String) {
        val split = c.split(" ")
        val realC = split[0]

        when(realC) {
            "push" -> {
                queue.add(split[1])
            }
            "pop" -> {
                sb.append(if (queue.isEmpty()) -1 else queue.removeFirst())
                sb.appendLine()
            }
            "size" -> {
                sb.append(queue.size)
                sb.appendLine()
            }
            "empty" -> {
                sb.append(if (queue.isEmpty()) 1 else 0)
                sb.appendLine()
            }
            "front" -> {
                sb.append(if (queue.isEmpty()) -1 else queue.first())
                sb.appendLine()
            }
            "back" -> {
                sb.append(if (queue.isEmpty()) -1 else queue.last())
                sb.appendLine()
            }
        }
    }

    repeat(n) {
        val c = readStr()

        handle(c)
    }
    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()