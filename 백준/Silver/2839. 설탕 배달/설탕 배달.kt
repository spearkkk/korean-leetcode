import java.math.BigDecimal
import java.math.RoundingMode

//import java.math.BigDecimal

//fun readInts(separator: Char = ' ') = readLine()!!.split(separator).map(String::toInt)
//fun readBigDecimal(separator: Char = ' ') = readLine()!!.split(separator).map(String::toDouble).map(BigDecimal::valueOf)

fun main(args: Array<String>) {
    val three = BigDecimal.valueOf(3L)
    val five = BigDecimal.valueOf(5L)

    val total = readLine()!!.toBigDecimal()

    val maxM = total.divide(five, 1, RoundingMode.UNNECESSARY).toBigInteger()

    for(m in maxM.toLong() downTo 0L) {
        val result = total.minus(BigDecimal.valueOf(m).multiply(five)).divideAndRemainder(three)
        if(result[1].compareTo(BigDecimal.ZERO) == 0) {
            val count = result[0].plus(BigDecimal.valueOf(m))
            print(count.toLong())
            return
        }
    }
    print(-1)
}