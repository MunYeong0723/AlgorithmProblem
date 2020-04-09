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
    var max = 0
    for(i in 1..n){
        var sum_tmp = 0
        for(j in 1 until i){
            if(arr[i] > arr[j]){
                if(sum_tmp < dp[j]) sum_tmp = dp[j]
            }
        }
        dp[i] = sum_tmp + arr[i]
        if(max < dp[i]) max = dp[i]
    }

    bw.write("$max")
    bw.flush()
}