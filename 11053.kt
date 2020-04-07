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

    var count_max = 0
    for(i in 1..n){
        var max_tmp = 0
        for(j in 1..n){
            if(arr[i] > arr[j]){
                if(max_tmp < dp[j]) max_tmp = dp[j]
            }
        }
        dp[i] = max_tmp + 1
        if(dp[i] > count_max) count_max = dp[i]
    }

    bw.write("$count_max\n")
    bw.flush()
}