import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val M = sc.nextInt()
    var array1 = Array(N) {""}
    var array2 = ArrayList<String>()
    sc.nextLine()

    for(i in 0 until N){
        array1[i] = sc.nextLine()
    }
    array1.sort()
    for(i in 0 until M){
        val tmp = sc.nextLine()
        if(binarySearch(array1, tmp)) array2.add(tmp)
    }

    println(array2.size)
    array2.sort()
    for(i in 0 until array2.size){
        println(array2[i])
    }
}

fun binarySearch(array : Array<String>, find : String) : Boolean {
    var left = 0
    var right = array.size - 1

    while(left <= right){
        var mid = (left + right) / 2
        when{
            array[mid] > find -> {
                right = mid - 1
            }
            array[mid] < find -> {
                left = mid + 1
            }
            else -> return true
        }
    }
    return false
}