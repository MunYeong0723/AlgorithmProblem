import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

fun main() {
    val sc : Scanner = Scanner(System.`in`)
    var num = -1
    var array = ArrayList<Int>()

    while(true){
        num = sc.nextInt()
        if(num == 0) break
        array.add(num)
    }

    for(num in array){
        var count = 0
        for(i in num+1..num*2){
            if(isPrime(i)) count++

        }
        println(count)
    }
}

fun isPrime(num : Int) : Boolean {
    var i = 2
    var check = true

    if(num == 1) return false

    while(i <= sqrt(num.toDouble())){
        if(num % i == 0){
            check = false
            break
        }
        else i++
    }
    return check
}