import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.min

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var num = sc.nextInt()
    var dp = Array(num+1){0}
    for(i in 2..num){
        dp[i] = dp[i-1] + 1
        if(i % 3 == 0) dp[i] = min(dp[i], dp[i/3]+1)
        else if(i % 2 == 0) dp[i] = min(dp[i], dp[i/2]+1)
    }

    bw.write("${dp[num]}\n")
    bw.flush()
}