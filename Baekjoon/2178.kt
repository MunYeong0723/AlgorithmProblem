import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

class Cell(x : Int, y : Int, move : Int){
    var x : Int = 0
    var y : Int = 0
    var move : Int = 0

    init {
       this.x = x
        this.y = y
        this.move = move
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    val m = sc.nextInt()
    sc.nextLine()
    var graph = Array(n+2){Array(m+2){0}}
    for(i in 1..n){
        val st = sc.nextLine()
        for(j in 1..m) graph[i][j] = st[j-1] - '0'
    }

    val ans = bfs(graph, n, m)
    bw.write("$ans")
    bw.flush()
}

fun bfs(graph : Array<Array<Int>>, n : Int, m : Int) : Int {
    var q : Queue<Cell> = LinkedList()
    q.add(Cell(1, 1, 1))
    graph[1][1] = 0

    while(!q.isEmpty()){
        val tmp = q.remove()
        val first = tmp.x
        val second = tmp.y
        val move = tmp.move

        if(first == n && second == m) return move

        if(graph[first+1][second] == 1){ // check down
            q.add(Cell(first+1, second, move+1))
            graph[first+1][second] = 0
        }
        if(graph[first-1][second] == 1){ // check up
            q.add(Cell(first-1, second, move+1))
            graph[first-1][second] = 0
        }
        if(graph[first][second+1] == 1){ // check right
            q.add(Cell(first, second+1, move+1))
            graph[first][second+1] = 0
        }
        if(graph[first][second-1] == 1){ // check left
            q.add(Cell(first, second-1, move+1))
            graph[first][second-1] = 0
        }
    }
    return 1
}