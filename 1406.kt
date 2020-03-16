import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var left = Stack<Char>()
    var right = Stack<Char>()

    var st = br.readLine()
    for(i in 0 until st.length) left.add(st[i])

    val num = Integer.parseInt(br.readLine())
    // read command
    for(i in 1..num){
        st = br.readLine()
        val cmd = st.split(" ")
        when(cmd[0]){
            "L" -> {
                if(!left.isEmpty()) right.push(left.pop())
            }
            "D" -> {
                if(!right.isEmpty()) left.push(right.pop())
            }
            "B" -> {
                if(!left.isEmpty()) left.pop()
            }
            "P" -> {
                left.push(cmd[1].first())
            }
        }
    }

    for(i in 0 until left.size) bw.write("${left[i]}")
    for(i in right.size-1 downTo 0) bw.write("${right[i]}")
    bw.flush()
    bw.close()
}