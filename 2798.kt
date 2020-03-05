import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val sc:Scanner = Scanner(System.`in`)
    var N = sc.nextInt()
    var M = sc.nextInt()
    var array = ArrayList<Int>()

    for(i in 0 until N){
        array.add(sc.nextInt())
    }
    array.sort()

    // find maximum sum ( <= M )
    var maximum = 0
    var tmp = 0
    for(i in N-1 downTo 2){
        for(j in i-1 downTo 1){
            for(k in j-1 downTo 0){
                tmp = array[i] + array[j] + array[k]
                if(tmp in (maximum + 1)..M){
                    maximum = tmp
                }
            }
        }
    }
    println(maximum)
}