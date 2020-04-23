import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

var count = 0
fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var t = sc.nextInt()
    while (t-- > 0) {
        val n = sc.nextInt()
        var graph = Array(n + 1) { 0 }
        for (i in 1..n) graph[i] = sc.nextInt()

        count = 0
        var visit = Array(n + 1) { false }
        var done = Array(n + 1) { false }
        for (i in 1..n) {
            if (!visit[i]) dfs(graph, visit, i, done)
        }
        bw.write("${n - count}\n")
    }
    bw.flush()
}

fun dfs(graph : Array<Int>, visit : Array<Boolean>, now : Int, done : Array<Boolean>){
    visit[now] = true

    val next = graph[now]
    if(!visit[next]) dfs(graph, visit, next, done)
    else if(!done[next]) {
        // count team number
        var i = next
        while(i != now){
            count++
            i = graph[i]
        }
        count++
    }
    done[now] = true
}