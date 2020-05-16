import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var graph = Array(n+1){ArrayList<Int>()}
    for(i in 1 until n){
        val first = sc.nextInt()
        val second = sc.nextInt()

        graph[first].add(second)
        graph[second].add(first)
    }

    val parent = dfs(graph, n)
    for(i in 2..n){
        bw.write("${parent[i]}\n")
    }
    bw.flush()
}

fun dfs(graph : Array<ArrayList<Int>>, n : Int) : Array<Int> {
    var visit = Array(n+1){false}
    var parent = Array(n+1){0}

    var st = Stack<Int>()
    st.push(1)
    while(!st.isEmpty()){
        val tmp = st.pop()
        visit[tmp] = true

        for(i in graph[tmp]){
            if(!visit[i]){
                st.push(i)
                parent[i] = tmp
            }
        }
    }
    return parent
}