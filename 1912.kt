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
    var max = arr[1]
    for(i in 2..n){
        if(arr[i] < dp[i-1]+arr[i]) dp[i] = dp[i-1]+arr[i]
        else dp[i] = arr[i]

        if(max < dp[i]) max = dp[i]
    }

    bw.write("$max")
    bw.flush()
}