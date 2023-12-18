package spearkkk.acmicpc.no_1463

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val result = IntArray(1000001) { 0 }
    result[1] = 0

    val n = readLine()!!.toInt()
    for (i in 2..1000000) {
        var divide3 = Int.MAX_VALUE
        var divide2 = Int.MAX_VALUE
        val minus1 = result[i - 1]
        if (i % 3 == 0) {
            val k = i / 3
            divide3 = result[k]
        }

        if (i % 2 == 0) {
            val k = i / 2
            divide2 = result[k]
        }

        result[i] = min(divide2, min(divide3, minus1)) + 1
    }

    writer.write("${result[n]}")
    writer.newLine()

    writer.flush()
}