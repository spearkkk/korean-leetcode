package spearkkk.acmicpc.no_1912

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.max
import kotlin.math.min

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine()!!.toInt()
    val results = LongArray(n) { Long.MIN_VALUE }

    val values = readLine()!!.split(" ").map(String::toLong)
    results[0] = values[0]
    for (i in 1 until n) {
        results[i] = max(max(values[i] + values[i - 1], values[i] + results[i - 1]), values[i])
    }

    writer.write("${results.max()}")
    writer.newLine()

    writer.flush()
}