import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    val m = sc.nextInt()
    val firstArr = Array(n){0}
    val secondArr = Array(m){0}
    for(i in 0 until n) firstArr[i] = sc.nextInt()
    for(i in 0 until m) secondArr[i] = sc.nextInt()

    var left = 0
    var right = 0
    while(left < n && right < m){
        if(firstArr[left] < secondArr[right]) bw.write("${firstArr[left++]} ")
        else bw.write("${secondArr[right++]} ")
    }

    while(left < n) bw.write("${firstArr[left++]} ")
    while(right < m) bw.write("${secondArr[right++]} ")

    bw.flush()
}