import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

var graph = Array(100001){ArrayList<Pair<Int, Int>>()}
var visited = Array(100001){false}
var distanceMAX = 0
var mostFarNode = 0
fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val v = sc.nextInt()
    for(i in 1..v){
        val now = sc.nextInt()
        while(true){
            val next = sc.nextInt()
            if(next == -1) break
            val weight = sc.nextInt()
            graph[now].add(Pair(next, weight))
        }
    }

    visited[1] = true
    dfs(1, v, 0)
    visited[1] = false

    visited[mostFarNode] = true
    dfs(mostFarNode, v, 0)
    bw.write("$distanceMAX")
    bw.flush()
}

fun dfs(now : Int, v : Int, distance : Int) {
    if(distance > distanceMAX) {
        mostFarNode = now
        distanceMAX = distance
    }

    for(i in graph[now]){
        if(!visited[i.first]) {
            visited[i.first] = true
            dfs(i.first, v, distance+i.second)
            visited[i.first] = false
        }
    }
}