import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var card = ArrayList<Int>()
    for(i in 0 until n) card.add(sc.nextInt())
    card.sort()


    var m = sc.nextInt()
    while(m-- > 0){
        val target = sc.nextInt()
        bw.write("${findEnd(card, n, target) - findStart(card, n, target)} ")
    }
    bw.flush()
}

fun findStart(card : ArrayList<Int>, n : Int, target : Int) : Int {
    var left = 0
    var right = n

    while(left < right){
        val mid = (left+right)/2
        if(card[mid] >= target) right = mid
        else left = mid + 1
    }
    return right
}

fun findEnd(card : ArrayList<Int>, n : Int, target : Int) : Int {
    var left = 0
    var right = n

    while(left < right){
        val mid = (left+right)/2
        if(card[mid] <= target) left = mid + 1
        else right = mid
    }

    return right
}