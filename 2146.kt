import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

var map = Array(100){Array(100){-1}}
val d = arrayOf(arrayOf(-1,0), arrayOf(1,0), arrayOf(0,-1), arrayOf(0,1))

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var map = Array(n){Array(n){0}}
    for(i in 0 until n){
        for(j in 0 until n) map[i][j] = sc.nextInt()
    }

    var island = ArrayList< ArrayList<Pair<Int, Int>> >()
    for(i in 0 until n){
        for(j in 0 until n){
            if(map[i][j] == 1) island.add( dfs(n, Pair(i,j), map) )
        }
    }

    var min = n*n
    for(i in 0 until island.size){
        for(j in i+1 until island.size){
            min = min(min, minBridge(n, island[i], island[j]))
        }
    }

    bw.write("${min-1}")
    bw.flush()
}

fun min(a: Int, b : Int) : Int = if(a<b) a else b

fun dfs(n : Int, now : Pair<Int, Int>, map : Array<Array<Int>> ) : ArrayList<Pair<Int, Int>> {
    var line = ArrayList<Pair<Int, Int>>()

    var st = Stack<Pair<Int, Int>>()
    map[now.first][now.second] = 0
    st.push(now)
    while(!st.isEmpty()){
        val tmp = st.pop()
        line.add(tmp)

        for(i in 0 until 4) {
            val newY = tmp.first + d[i][0]
            val newX = tmp.second + d[i][1]

            if (newY < 0 || newY >= n || newX < 0 || newX >= n) continue

            if (map[newY][newX] == 1) {
                map[newY][newX] = 0
                st.push(Pair(newY, newX))
            }
        }
    }
    return line
}

fun minBridge(n : Int, nowIsland : ArrayList<Pair<Int, Int>>, nextIsland : ArrayList<Pair<Int, Int>>) : Int {
    var min = n*n
    for(i in 0 until nowIsland.size){
        val now = nowIsland[i]
        for(j in 0 until nextIsland.size){
            val next = nextIsland[j]

            val distance = abs(now.first-next.first) + abs(now.second-next.second)
            if(min > distance) min = distance
        }
    }
    return min
}