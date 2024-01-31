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

    /**
     * 문제를 확인해보면 강의들을 겹치지 않게 배열해서 한 강의실에 듣게끔 한다.
     * 겹치면 다른 강의실을 사용한다.
     * 최적의로 강의를 배치했을 때, 최소로 사용하는 강의실의 수
     * 
     * ends는 각 강의실의 끝나는 시간을 나타낸다.
     * 
     */
    val ends = java.util.PriorityQueue<Int>()

    for (i in 0 until n) {
        // 배치해야할 강의
        val (s, e) = points[i]

        if (ends.isEmpty()) {
            ends.add(e)
            continue
        }

        // 무조건 ends 에 값을 추가한다.
        // 왜냐하면 앞서 강의를 정렬한 기준이 있기 때문에
        // 시작 시간이 같으면 항상 ends에 있는 값보다 e의 값이 크다
        // 시작 시간이 다르고 만약 e의 값이 ends안의 값보다 작다면, 그 두 강의 중 하나가 하나를 포함하기 때문에 두 개의 강의실을 써야한다.
        // 시작 시간이 이미 들어간 강의 중에 제일 먼저 끝나는 시간보다 크면 그 강의실을 사용하면 된다.
        ends.add(e)
        if (ends.first() <= s) {
            // 이미 끝난 강의실을 이어서 사용한다.
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