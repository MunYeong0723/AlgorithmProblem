import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = sc.nextInt()

    var dp = Array(11){0}
    for(i in 1..10){
        if(i == 1) dp[i] = 1
        else if(i == 2) dp[i] = 2
        else if(i == 3) dp[i] = 4
        else dp[i] = dp[i-3] + dp[i-2] + dp[i-1]
    }
    for(i in 1..n) bw.write("${dp[sc.nextInt()]}\n")
    bw.flush()
}