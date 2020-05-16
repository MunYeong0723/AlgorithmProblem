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
    dp[1] = arr[1]
    for(i in 2..n){
        if(i == 2) dp[2] = max(arr[i], dp[i-1]+arr[i])
        else{
            dp[i] = max(dp[i-2], dp[i-3]+arr[i-1]) + arr[i]
        }
    }

    bw.write("${dp[n]}")
    bw.flush()
}

fun max(a : Int, b: Int) : Int = if(a>b) a else b