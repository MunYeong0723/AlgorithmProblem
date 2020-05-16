import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var dp = Array(n+1){Array(10){1}}

    for(i in 2..n){
        for(j in 1..9){
            dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 10007
        }
    }

    var count = 0
    for(i in 0..9) count += dp[n][i]

    bw.write("${count % 10007}")
    bw.flush()
}