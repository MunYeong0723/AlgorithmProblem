import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var dp = Array(n+1){0}
    for(i in 1..n) dp[i] = i

    for(i in 1..n){
        var j = 2
        while(j*j <= i){
            dp[i] = min(dp[i], dp[i-j*j]+1)
            j++
        }
    }

    bw.write("${dp[n]}")
    bw.flush()
}

fun min(a : Int, b : Int) : Int = if(a<b) a else b