import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var arr = Array(n+1){0}
    for(i in 1..n) arr[i] = sc.nextInt()

    var dp = Array(n+1){0}
    for(i in 1..n){
        for(j in 1..i){
            dp[i] = max(dp[i], arr[j] + dp[i-j])
        }
    }
    bw.write("${dp[n]}")
    bw.flush()
}

fun max(a : Int, b : Int) : Int = if(a>b) a else b  