import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val lk = LinkedList<Char>()
    var cursor = 0

    var st = br.readLine()
    for(i in 0 until st.length) lk.add(st[i])
    cursor = lk.size

//    lk.removeAt(1)
//    for(i in 0 until lk.size) println(lk[i])
//    println("$cursor")
//    println("${lk.size}")

    val num = Integer.parseInt(br.readLine())
    // read command
    for(i in 1..num){
        st = br.readLine()
        val cmd = st.split(" ")
        when(cmd[0]){
            "L" -> {
                if(cursor > 0) cursor--
            }
            "D" -> {
                if(cursor != lk.size) cursor++
            }
            "B" -> {
                if(cursor > 0) lk.removeAt(--cursor)
            }
            "P" -> {
                lk.add(cursor++, cmd[1].first())
            }
        }
    }

    for(i in 0 until lk.size) bw.write("${lk[i]}")
    bw.flush()
    bw.close()
}