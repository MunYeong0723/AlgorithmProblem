import java.util.*

class Node(a : Int){
    var num = a
    var neighbor = ArrayList<Int>()
    var depth = 0
    var visit = false
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    var graph = ArrayList<Node>()
    graph.add(Node(-1)) // dummy data

    // initialization graph
    for(i in 1..n) graph.add(Node(i))

    // add edge in graph
    for(i in 1..m){
        val start = sc.nextInt()
        val end = sc.nextInt()

        graph[start].neighbor.add(end)
        graph[end].neighbor.add(start) // because undirected graph
    }

    var ans = 0
    var st = Stack<Int>()
    st.push(graph[1].num)
    graph[1].visit = true

    // DFS until depth 2
    while(!st.empty()){
        val tmp = st.pop()
        for(i in graph[tmp].neighbor){
            if(graph[i].visit) continue // not visit twice

            graph[i].depth = graph[tmp].depth + 1
            if(graph[i].depth <= 2) { // search until depth 2
                st.push(graph[i].num)
                graph[i].visit = true
            }
        }
        if(tmp != 1) ans++
    }
    println(ans)
}