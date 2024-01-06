package spearkkk.acmicpc.no_11047

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val firstLine = readLine()!!.split(" ").map(String::toLong)
    val n = firstLine[0]
    val k = firstLine[1]

    val currency = ArrayList<Long>()
    for (i in 0 until n.toInt()) {
        currency += readLine()!!.toLong()
    }

    var leftK = k
    var result = 0L

    for (i in currency.indices) {
        if (leftK == 0L) break
        val currentCurrency = currency[currency.size - 1 - i]
        val count = leftK / currentCurrency
        if (count != 0L) {
            result += count
            leftK -= (currentCurrency * count)
        }
    }

    writer.write("$result")
    writer.newLine()

    writer.flush()
}