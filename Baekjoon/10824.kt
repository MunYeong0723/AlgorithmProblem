import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val first = sc.next() + sc.next()
    val second = sc.next() + sc.next()
    val ans : Long = first.toLong() + second.toLong()

    bw.write("$ans\n")
    bw.flush()
}