import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var dp = Array(101){0L}
    dp[1] = 1
    dp[2] = 1
    dp[3] = 1
    dp[4] = 2

    // calculate
    for(i in 5..100){
        dp[i] = dp[i-5] + dp[i-1]
    }

    var n = sc.nextInt()
    while(n > 0){
        val i = sc.nextInt()
        bw.write("${dp[i]}\n")
        n--
    }
    bw.flush()
}