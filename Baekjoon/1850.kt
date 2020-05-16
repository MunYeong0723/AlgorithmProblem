import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val left = sc.nextLong()
    val right = sc.nextLong()

    for(i in 1..gcd(left, right)) bw.write("1")
    bw.flush()
}

fun gcd(a : Long, b : Long) : Long {
    var left = a
    var right = b

    while(right != 0L){
        val r = left % right
        left = right
        right = r
    }
    return left
}