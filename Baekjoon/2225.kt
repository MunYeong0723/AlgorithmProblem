import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    val k = sc.nextInt()

    var dp = Array(k+1){Array(n+1){1}}
    for(i in 2..k){
        for(j in 1..n){
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000
        }
    }

    bw.write("${dp[k][n]}")
    bw.flush()
}