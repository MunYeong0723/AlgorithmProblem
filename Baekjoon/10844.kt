import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var dp = Array(n+1){Array(10){0}}

    // initialize
    var count = 0L
    for(i in 0..9){
        if(i == 0) dp[1][i] = 0
        else dp[1][i] = 1
        count += dp[1][i]
    }

    if(n > 1) count = 0L
    for(i in 2..n){
        for(j in 0..9){
            if(j == 0) dp[i][j] = dp[i-1][j+1] % 1000000000
            else if(j == 9) dp[i][j] = dp[i-1][j-1] % 1000000000
            else {
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000
            }
            if(i == n) count += dp[i][j]
        }
    }

    bw.write("${count % 1000000000}")
    bw.flush()
}