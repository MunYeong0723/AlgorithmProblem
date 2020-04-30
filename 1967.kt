import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

class Node(num : Int, weight : Int){
    var num = 0
    var weight = 0
    init {
        this.num = num
        this.weight = weight
    }

}

var max = 0
var maxNode = 0
var graph  = Array(10001){ArrayList<Node>()}
var visit = Array(10001){false}
fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    for(i in 1 until n){
        val first = sc.nextInt()
        val second = sc.nextInt()
        val weight = sc.nextInt()

        graph[first].add(Node(second, weight))
        graph[second].add(Node(first, weight))
    }
    // root로부터 제일 멀리 있는 node를 찾음
    dfs(1, 0)

    visit = Array(10001){false}
    // 위에 찾은 node로부터 제일 멀리 있는 node를 찾음
    dfs(maxNode, 0)

    bw.write("$max\n")
    bw.flush()
}

fun dfs(point : Int, dist : Int) {
    visit[point] = true

    if(dist > max) {
        max = dist
        maxNode = point
    }
    for(i in graph[point]){
        if(!visit[i.num]) dfs(i.num, dist + i.weight)
    }
}