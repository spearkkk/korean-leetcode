package spearkkk.acmicpc.no_1931

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.Comparator
import kotlin.math.max
import kotlin.math.min

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val n = readLine()!!.toInt()
    val schedules = Array(n + 1){ IntArray(2) { -1 } }

    val comparator: Comparator<IntArray> = Comparator { left, right ->
        when {
            left[1] < right[1] -> -1
            left[1] > right[1] -> 1
            else -> left[0] - right[0]
        }
    }

    for (i in 1 .. n) {
        schedules[i] = readLine()!!.split(" ").map(String::toInt).toIntArray()
    }
    schedules.sortWith(comparator)

    var result = 0
    var next = 0

    for (i in 1 .. n) {
        val start = schedules[i][0]
        val end = schedules[i][1]

        if (next <= start) {
            result += 1
            next = end
        }
    }

    writer.write("$result")
    writer.newLine()

    writer.flush()
}