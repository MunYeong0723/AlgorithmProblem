import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val N = sc.nextInt()
    var K = sc.nextInt()
    var coins = Array(N){0}
    for(i in 0 until N) coins[i] = sc.nextInt()

    var coinNum = 0
    var i = N-1
    while(K > 0 && i >= 0){
        if(coins[i] > K) {i--; continue}

        while(coins[i] <= K) {
            K -= coins[i]
            coinNum++
        }
    }
    bw.write("$coinNum")
    bw.flush()
}