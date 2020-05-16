import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val k = sc.nextInt()
    val n = sc.nextInt()
    var kind = ArrayList<Int>()
    for(i in 1..k) kind.add(sc.nextInt())
    kind.sort()

    bw.write("${binarySearch(k, n, kind)}")
    bw.flush()
}

fun binarySearch(k : Int, n : Int, kind : ArrayList<Int>) : Long {
    var left = 1L
    var right = kind[k-1].toLong() + 1
    var max = 0L

    while(left <= right){
        val mid = (left+right)/2

        var count = 0L
        for(i in kind){
            count += i / mid
        }

        if(count < n) right = mid-1
        else {
            if(mid > max) max = mid
            left = mid+1
        }
    }
    return max
}