import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var k = sc.nextInt() // number of case
    while(k-- > 0){
        val v = sc.nextInt() // number of node
        val e = sc.nextInt() // number of edge
        var edge = Array(v+1){ArrayList<Int>()}

        for(i in 1..e){
            val first = sc.nextInt()
            val second = sc.nextInt()

            edge[first].add(second)
            edge[second].add(first)
        }

        if(isBipartite(edge, v)) bw.write("YES\n")
        else bw.write("NO\n")
    }
    bw.flush()
}

fun isBipartite(edge : Array<ArrayList<Int>>, v : Int) : Boolean {
    var color = Array(v+1){0} // node color (1 or 2). if node is 0, not visit yet
    // color node
    for(i in 1..v){
        if(color[i] == 0) {
            if(!dfs(edge, color, i)) return false
        }
    }
    return true
}

fun dfs(edge : Array<ArrayList<Int>>, color : Array<Int>, start : Int) : Boolean {
    var st = Stack<Int>()
    st.push(start)
    color[start] = 1
    while(!st.isEmpty()){
        val visit = st.pop()

        for(i in edge[visit]){
            if(color[i] == 0) {
                color[i] = 3 - color[visit]
                st.push(i)
            }
            else if(color[i] == color[visit]) return false
        }
    }
    return true
}