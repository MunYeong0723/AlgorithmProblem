import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = sc.nextInt()
    var m = sc.nextInt()
    val k = sc.nextInt()

    var team = 0
    while(n+m >= k){
        if(n < 2 || m < 1) break

        n -= 2; m -= 1
        if(n+m >= k) team++
    }

    bw.write("$team")
    bw.flush()
}