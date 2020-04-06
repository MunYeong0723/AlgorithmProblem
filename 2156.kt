import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    val arr = Array(n+1){0}
    for(i in 1..n) arr[i] = sc.nextInt()

    var dp = Array(n+1){0}
    // calculate maximum
    for(i in 1..n){
        when(i){
            1 -> dp[i] = arr[i]
            2 -> dp[i] = arr[i-1] + arr[i]
            else -> {
                dp[i] = max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i])
                dp[i] = max(dp[i-1], dp[i])
            }
        }
    }
    bw.write("${dp[n]}")
    bw.flush()
}

fun max(a : Int, b : Int) : Int = if(a>b) a else b