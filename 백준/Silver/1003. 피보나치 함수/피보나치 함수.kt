package spearkkk.acmicpc.no_1003

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val array0 = IntArray(42) {0}
    val array1 = IntArray(42) {0}
    array0[0] = 1

    array1[1] = 1

    for(i in 2 until 42) {
        array0[i] = array0[i - 2] + array0[i - 1]
        array1[i] = array1[i - 2] + array1[i - 1]
    }

    val n = readLine()!!.toInt()
    for (i in 1..n) {
        val idx = readLine()!!.toInt()
        writer.write("${array0[idx]} ${array1[idx]}\n")
    }
    writer.flush()
}