import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextLong()
    val m = sc.nextLong()

    // count the number of 2
    val count_2 = counter(n, 2) - (counter(n-m, 2) + counter(m, 2))

    // count the number of 5
    val count_5 = counter(n, 5) - (counter(n-m, 5) + counter(m, 5))

    bw.write("${min(count_2, count_5)}")
    bw.flush()
}

fun counter(divide : Long, num : Long) : Long {
    var i = num
    var count = 0L

    while(i <= divide){
        count += divide / i
        i *= num
    }
    return count
}