import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val m = sc.nextInt()
    val n = sc.nextInt()
    var graph = Array(n+2){Array(m+2){-1}}
    for(i in 1..n){
        for(j in 1..m) graph[i][j] = sc.nextInt()
    }

    var ans = solve(graph, m, n)
    bw.write("$ans")
    bw.flush()
}

fun solve(graph: Array<Array<Int>>, m : Int, n : Int) : Int {
    var q : Queue<Pair<Int, Int>> = LinkedList()
    for(i in 1..n){
        for(j in 1..m){
            if(graph[i][j] == 1) q.add(Pair(i, j))
            else if(graph[i][j] == 0){
                if(graph[i+1][j] == -1 && graph[i-1][j] == -1 && graph[i][j+1] == -1 && graph[i][j-1] == -1) return -1
            }
        }
    }

    var day = 0
    if(q.size == 0) return -1
    else {
        q = bfs(graph, q)
        while(q.size > 0){
            day++
            q = bfs(graph, q)
        }

    }
    // check if there is 0 in graph
    for(i in 1..n){
        for(j in 1..m){
            if(graph[i][j] == 0) return -1
        }
    }
    return day
}

fun bfs(graph: Array<Array<Int>>, q : Queue<Pair<Int, Int>>) : Queue<Pair<Int, Int>>{
    var q_return : Queue<Pair<Int, Int>> = LinkedList()
    while(!q.isEmpty()){
        val tmp = q.remove()
        val first = tmp.first
        val second = tmp.second

        if(graph[first+1][second] == 0){ // check down
            graph[first+1][second] = 1
            q_return.add(Pair(first+1, second))
        }
        if(graph[first-1][second] == 0){ // check up
            graph[first-1][second] = 1
            q_return.add(Pair(first-1, second))
        }
        if(graph[first][second+1] == 0){ // check right
            graph[first][second+1] = 1
            q_return.add(Pair(first, second+1))
        }
        if(graph[first][second-1] == 0){ // check left
            graph[first][second-1] = 1
            q_return.add(Pair(first, second-1))
        }
    }
    return q_return
}