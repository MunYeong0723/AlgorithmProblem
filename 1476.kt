import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var E = sc.nextInt()
    var S = sc.nextInt()
    var M = sc.nextInt()
    if(E == 15) E = 0
    if(S == 28) S = 0
    if(M == 19) M = 0


    var x = 1
    while(!(x % 15 == E && x % 28 == S && x % 19 == M)) x++

    bw.write("$x")
    bw.flush()
}