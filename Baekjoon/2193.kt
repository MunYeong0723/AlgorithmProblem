import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var dp = Array(n+1){Array(2){0L}}

    // initialize
    dp[1][0] = 0
    dp[1][1] = 1

    for(i in 2..n){
        dp[i][0] = dp[i-1][0] + dp[i-1][1]
        dp[i][1] = dp[i-1][0]
    }

    bw.write("${dp[n][0] + dp[n][1]}")
    bw.flush()
}