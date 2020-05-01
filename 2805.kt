import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.abs

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    val m = sc.nextInt()

    var max = 0L
    var arr = Array(1000001){0L}
    var min = 0L
    for(i in 0 until n){
        val tmp = sc.nextLong()
        arr[i] = tmp

        if(max < tmp) max = tmp
        min += tmp
    }

    var ans = 0L
    // binary search
    var left = 0L
    var right = max
    while(left <= right){
        val mid = (left+right)/2
        var bring = 0L

        for(i in 0 until n){
            if(arr[i] > mid) bring += arr[i] - mid
        }

        if(bring-m in 0 until min){
            min = bring - m
            ans = mid
        }

        if(bring > m) left = mid+1
        else right = mid-1
    }

    bw.write("$ans")
    bw.flush()
}