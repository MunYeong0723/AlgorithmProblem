import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val lk = LinkedList<Char>()

    var st = br.readLine()
    for(i in 0 until st.length) lk.add(st[i])
    var it = lk.listIterator(lk.size)

    val num = Integer.parseInt(br.readLine())
    // read command
    for(i in 1..num){
        st = br.readLine()
        val cmd = st.split(" ")
        when(cmd[0]){
            "L" -> {
                if(it.hasPrevious()) it.previous()
            }
            "D" -> {
                if(it.hasNext()) it.next()
            }
            "B" -> {
                if(it.hasPrevious()) {
                    it.previous()
                    it.remove()
                }
            }
            "P" -> {
                it.add(cmd[1].first())
            }
        }
    }

    for(i in 0 until lk.size) bw.write("${lk[i]}")
    bw.flush()
    bw.close()
}