package spearkkk.acmicpc.no_11053

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine()!!.toInt()
    val values = readLine()!!.split(" ").map(String::toInt)
    val results = IntArray(n) { 1 }

    for (i in 0 until n) {
        var tmp = 0
        for (j in 0 until i) {
            if (values[i] > values[j] && tmp < results[j]) {
                tmp = results[j]
            }
        }
        results[i] = tmp + results[i]
    }

    writer.write("${results.max()}")
    writer.newLine()

    writer.flush()
}