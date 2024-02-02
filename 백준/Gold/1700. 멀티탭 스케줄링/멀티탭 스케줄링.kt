fun main() {
    /**
     * n개의 공간에 k개를 할당하는 문제
     * n이 k보다 크거나 같다면 할당하는데에 문제는 전혀 없다.
     * 그러나 n이 k보다 작다면 문제가 있다.
     *
     * 1 2 3 4 1 2
     *
     * 2 3 2 3 1 2 7 -> 2, 3이 들어간 상태에서 1를 넣을 때, 3을 빼는 이유는 가까운 미래에 2가 들어올 것이기 떄문이다.
     * 2 3 2 3 1 3 7 -> 위와 반대로 3이 들어올 것이기 떄문에 2를 뺀다.
     *
     * 2 3 2 3 1 7 2
     * 2 3 2 3 1 7 3 -> 1, 7를 다 넣어야 하기 때문이 2, 3이든 빼긴해야 한다.
     *
     * 현재 빈 공간이 남아 있으면 할당
     * 빈 공간이 없다면 조건에 따라 할당
     * 이미 할당한 데이터가 앞으로 들어올 예정이 없다면 바로 뺄 수 있다.
     * 앞으로 들어올 예정이 있다면 제일 나중에 들어올 데이터를 빼야 한다.
     */

    val (n, k) = readInts()
    val numbers = readInts()

    // 각각 숫자별로 언제 등장하는지 저장해놓는다.
    // 등장하는 순간은 매번 바뀌지 않고 똑같아서 미리 저장하는게 이득
    val keyToIndices = mutableMapOf<Int, MutableList<Int>>()
    for (i in numbers.indices) {
        val key = numbers[i]

        keyToIndices.putIfAbsent(key, mutableListOf())
        keyToIndices[key]!!.add(i)

    }

    var cnt = 0

    var cur = 0
    val space = mutableSetOf<Int>()
    while (cur < k) {
        // 현재 빈 공간이 있는 경우, 그냥 넣어버린다.
        // 같은 기기를 사용해도 상관없다 set이기 때문에 알아서 중복 체크가 된다.
        if (space.size != n) {
            space.add(numbers[cur])
            cur += 1
            continue
        }

        // 이미 할당한 기기는 넘긴다.
        if (space.contains(numbers[cur])) {
            cur += 1
            continue
        }

        // 이제 공간 중에 하나를 빼야 한다.
        // 앞서 저장했던 숫자별로 등장 인덱스들 데이터를 보자
        // 우리가 빼야할 데이터는 가장 늦게 등장하거나 아예 등장하지 않는 데이터를 빼면 된다.
        var nxt = space.first()
        var max = cur
        for (i in space) {
            // 현재 위치보다 뒤에 등장하는 인덱스가 있는지 찾는다.
            val tmp = keyToIndices.getOrDefault(i, mutableListOf()).find { it > cur }
            if (tmp == null) {
                // 등장하지 않는다면 해당 데이터를 뺄 수 있다.
                nxt = i
                break
            }

            // 둥장한다면 각각의 등장 위치를 저장한다.
            // 등장 위치 중 최대 큰 값, 가장 나중에 들어온 값만 저장해도 된다.
            if (max < tmp) {
                max = tmp
                nxt = i
            }
        }

        space.remove(nxt)
        space.add(numbers[cur])
        cur += 1

        cnt += 1
    }
    println(cnt)
}

fun readStr() = readln()
fun readStrings() = readStr().split(" ")
fun readInt() = readStr().toInt()
fun readInts() = readStrings().map { it.toInt() }
fun readLong() = readStr().toLong()
fun readLongs() = readStrings().map { it.toLong() }