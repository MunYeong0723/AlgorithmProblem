import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    sc.nextLine()
    var graph = Array(n+2){Array(n+2){'0'}}
    for(i in 1..n){
        val string = sc.nextLine()
        for(j in 1..n) graph[i][j] = string[j-1]
    }

    var ans = LinkedList<Int>()
    for(y in 1..n){
        for(x in 1..n){
            if(graph[y][x] == '1') {
                graph[y][x] = '0'
                ans.add(bfs(graph, Pair(y, x)))
            }
        }
    }

    ans.sort()
    bw.write("${ans.size}\n")
    for(i in ans){
        bw.write("$i\n")
    }
    bw.flush()
}

fun bfs(graph : Array<Array<Char>>, start : Pair<Int, Int>) : Int {
    var q : Queue<Pair<Int, Int>> = LinkedList()
    q.add(start)

    var count = 0
    while(!q.isEmpty()){
        val now = q.remove()
        count++
        val y = now.first
        val x = now.second

        if(graph[y][x+1] == '1'){ // check right
            q.add(Pair(y, x+1))
            graph[y][x+1] = '0'
        }
        if(graph[y][x-1] == '1'){ // check left
            q.add(Pair(y, x-1))
            graph[y][x-1] = '0'
        }
        if(graph[y+1][x] == '1'){ // check down
            q.add(Pair(y+1, x))
            graph[y+1][x] = '0'
        }
        if(graph[y-1][x] == '1'){ // check up
            q.add(Pair(y-1, x))
            graph[y-1][x] = '0'
        }
    }
    return count
}