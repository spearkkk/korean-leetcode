package spearkkk.acmicpc.no_10870

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val values = LongArray(21) { 0L }
    values[1] = 1
    for (i in 2..20) {
        values[i] = values[i - 2] + values[i - 1]
    }

    val n = readLine()!!.toInt()

    writer.write("${values[n]}")
    writer.newLine()

    writer.flush()
}