import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var card = ArrayList<Int>()
    for(i in 1..n) card.add(sc.nextInt())

    card.sort()
    val m = sc.nextInt()
    for(i in 1..m){
        if(binarySearch(n, card, sc.nextInt())) bw.write("1 ")
        else bw.write("0 ")
    }
    bw.flush()
}

fun binarySearch(n : Int, card : ArrayList<Int>, want : Int) : Boolean{
    var left = 0
    var right = n-1

    while(left <= right){
        val mid = (left+right)/2

        if(card[mid] < want) left = mid+1
        else if(card[mid] > want) right = mid-1
        else return true
    }
    return false
}