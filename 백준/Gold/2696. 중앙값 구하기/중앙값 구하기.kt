fun main() {
    val sb = StringBuilder()

    repeat(readInt()) {
        var n = readInt()
        var cnt = 0
        val answer = ArrayList<Int>()

        val holder = java.util.ArrayList<Int>()

        while (n > 0) {
            val numbers = readInts()
            for (number in numbers) {
                holder.add(number)

                if (holder.size % 2 == 1) {
                    cnt += 1
                    holder.sort()

                    val iter = holder.iterator()
                    repeat(holder.size / 2) {
                        iter.next()
                    }
                    answer.add(iter.next())
                }

            }
            n -= numbers.size
        }

        sb.append(cnt)
        sb.appendLine()
        sb.append(answer.withIndex().joinToString(" ") {
            if (it.index != 0 && it.index % 10 == 0) "\n${it.value}" else "${it.value}"
        })
        sb.appendLine()
    }
    println(sb)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readLong() = readStr().toLong()
fun readInts() = readStrings().map { it.toInt() }
fun readLongs() = readStrings().map { it.toLong() }