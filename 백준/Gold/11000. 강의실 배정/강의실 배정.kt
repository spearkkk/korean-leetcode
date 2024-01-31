fun main() {
    val n = readInt()

    /**
     * 강의들이 겹치지 않으면 다 들으면 되니깐 문제가 없다.
     *
     * 강의들이 겹치는 순간이 문제다.
     * 강의의 길이가 작은 강의들부터 선택하면 안된다: 1->4, 4->7 vs 5->6
     * 강의의 시작 시간이 작은 것부터 선택하면 안된다: 1->10 vs 5->6, 6->9
     *
     * 그러나 강의의 시작 시간은 같은데 강의의 길이가 더 짧은 것은 항상 올다
     * 1->2, 1->3, 1->4, 1->100 1->2를 선택하는 것은 2부터 시작하는 다른 강의가 있을 때를 생각해보면 항상 옳다.
     *
     * 정렬 기준: 시작 시간, 시작 시간이 같다면 강의의 길이
     *
     * 단, 시작 길이가 다른 강의가 들어왔다면... 이미 선택한 강의가 그 강의를 포함하는지 봐야한다.
     * 1->6: 2->3를 처리할 때 바꿔줘야한다.
     */

    val points = Array(n) { Pair(-1, -1) }

    for (i in 0 until n) {
        val (s, e) = readInts()
        points[i] = Pair(s, e)
    }

    val comparator = compareBy<APoint> { it.first }.then(compareBy<APoint> { it.second - it.first })
    points.sortWith(comparator)
//    println(points.joinToString(" -> "))

    val ends = java.util.PriorityQueue<Int>()

    for (i in 0 until n) {
        val (s, e) = points[i]

        if (ends.isEmpty()) {
            ends.add(e)
            continue
        }

        ends.add(e)
        if (ends.first() <= s) {
            ends.remove()
        }
    }
    println(ends.size)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }

typealias APoint = Pair<Int, Int>