import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var T = sc.nextInt()
    while(T-- > 0){
        val n = sc.nextInt()
        var sticker = Array(2){Array(n+1){0}}
        // input
        for(i in 0..1){
            for(j in 1..n){
                sticker[i][j] = sc.nextInt()
            }
        }

        // calculate maximum
        for(i in 2..n){
            sticker[0][i] += max(sticker[1][i-1], sticker[1][i-2])
            sticker[1][i] += max(sticker[0][i-1], sticker[0][i-2])
        }
        bw.write("${max(sticker[0][n], sticker[1][n])}\n")
    }
    bw.flush()
}

fun max(a : Int, b : Int) : Int = if(a > b) a else b