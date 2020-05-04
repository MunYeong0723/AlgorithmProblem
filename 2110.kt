import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    val c = sc.nextInt()
    var house = ArrayList<Int>()
    for(i in 1..n) house.add(sc.nextInt())
    house.sort()

    bw.write("${binarySearch(house, c)}")
    bw.flush()
}

fun binarySearch(house : ArrayList<Int>, c : Int) : Int {
    var left = 1
    var right = house[house.size-1] - house[0]
    var max = 0

    while(left <= right){
        val mid = (left+right)/2

        var install = house[0]
        var count = 1
        for(i in 1 until house.size){
            if(house[i] - install >= mid){
                count++
                install = house[i]
            }
        }
        if(count >= c) {
            left = mid+1
            max = mid
        }
        else right = mid-1
    }
    return max
}