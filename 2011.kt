import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val pw = sc.nextLine()
    if(pw == "0"){
        bw.write("0")
        bw.flush()
    }
    else{
        val len = pw.length
        var arr = Array(len+1){0}
        for(i in 1..len) arr[i] = pw[i-1] - '0'

        var dp = Array(len+1){0}
        dp[0] = 1
        for(i in 1..len){
            if(arr[i] in 1..9) dp[i] = (dp[i-1] + dp[i]) % 1000000

            val second = arr[i] + arr[i-1]*10
            if(second in 10..26) dp[i] = (dp[i-2] + dp[i]) % 1000000
        }
        bw.write("${dp[len]}")
        bw.flush()
    }
}