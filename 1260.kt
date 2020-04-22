import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    val n = sc.nextInt()
    val m = sc.nextInt()
    val v = sc.nextInt()

    var edge = Array(n+1){Array(n+1){0}}
    // add edge
    for(i in 1..m){
        val first = sc.nextInt()
        val second = sc.nextInt()

        edge[first][second] = 1
        edge[second][first] = 1
    }

    dfs(edge, v, n)
    bfs(edge, v, n)
}

fun dfs(edge : Array<Array<Int>>, start : Int, n : Int){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var graph = Array(n+1){false}

    var st = Stack<Int>()
    st.push(start)
    while(!st.isEmpty()){
        val search = st.pop()
        if(!graph[search]){
            graph[search] = true
            bw.write("$search ")
        }

        for(i in n downTo 1) {
            if(edge[search][i] == 1 && !graph[i]) st.push(i)
        }
    }
    bw.write("\n")
    bw.flush()
}

fun bfs(edge : Array<Array<Int>>, start : Int, n : Int){
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var graph = Array(n+1){false}

    var q : Queue<Int> = LinkedList()
    q.add(start)
    while(!q.isEmpty()){
        val search = q.remove()
        if(!graph[search]){
            graph[search] = true
            bw.write("$search ")
        }

        for(i in 1..n) {
            if(edge[search][i] == 1 && !graph[i]) q.add(i)
        }
    }
    bw.flush()
}