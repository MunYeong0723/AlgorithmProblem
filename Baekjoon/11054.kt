import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var arr = Array(n+1){0}
    for(i in 1..n) arr[i] = sc.nextInt()

    var dp_up = Array(n+1){0}
    var dp_down = Array(n+1){0}
    for(i in 1..n){
        var max_tmp = 0
        for(j in 1 until i){
            if(arr[i] > arr[j]){
                if(max_tmp < dp_up[j]) max_tmp = dp_up[j]
            }
        }
        dp_up[i] = max_tmp + 1
    }
    for(i in n downTo 1){
        var max_tmp = 0
        for(j in n downTo i-1){
            if(arr[i] > arr[j]){
                if(max_tmp < dp_down[j]) max_tmp = dp_down[j]
            }
        }
        dp_down[i] = max_tmp + 1
    }

    var ans = 0
    for(i in 1..n){
        if(ans < dp_up[i]+dp_down[i]-1) ans = dp_up[i]+dp_down[i]-1
    }

    bw.write("$ans")
    bw.flush()
}