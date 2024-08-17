fun main() {
    val (n, c) = readln().split(" ").map { it.toInt() }

    val stalls = IntArray(n)
    repeat(n) {
        stalls[it] = readln().toInt()
    }

    // 정렬
    stalls.sort()

    // https://www.youtube.com/live/0FT0vNlB6Dc?si=L25Wi9yWFL89W3-R
    // 이번 문제의 핵심은 stall에 모든 소를 배정한 후에 두 인접한 소의 거리를 구하는 건데, 그 거리가 최대로 긴 거리를 구해야한다.
    // 집에다가 공유기 설치하는 것으로 번역이 되었는데, 어쨌든 같은 맥락이다.
    // 접근법은 후보 거리를 두고 배정하는거다. 배정할 때 거리를 고려한다.
    // 후보 거리에서 충분히 배정할 수 있으면 후보 거리를 늘려본다.
    // 후보 거리에서 충분히 배정할 수 없으면 후보 거리를 줄여본다.
    
    var left = 0
    var right = stalls[n - 1]

    fun canBeAssigned(distance: Int): Boolean {
        var cnt = 1
        var lastAssigned = stalls[0]

        for (i in 1..<n) {

            if (lastAssigned + distance <= stalls[i]) {
                cnt += 1
                lastAssigned = stalls[i]
            }

            if (cnt == c) {
                return true
            }
        }
        return cnt == c
    }

    var answer = 0

    while (left <= right) {
        val middle = (left + right) / 2

        if (canBeAssigned(middle)) {
            answer = middle
            left = middle + 1
        } else {
            right = middle - 1
        }

    }

    println(answer)
}