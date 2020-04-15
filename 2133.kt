import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var dp = Array(n+1){0}
    dp[0] = 1
    for(i in 1..n){
        if(i % 2 != 0) continue
        else {
            dp[i] = dp[i-2]*3
            var j = 4
            while(j <= i) {
                dp[i] += dp[i-j]*2
                j += 2
            }
        }
    }

    bw.write("${dp[n]}")
    bw.flush()
}