import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.math.sqrt

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val min = sc.nextInt()
    val max = sc.nextInt()

    for(i in min..max){
        if(isPrime(i)) bw.write("$i\n")
    }
    bw.flush()
}

fun isPrime(num : Int) : Boolean{
    if(num == 1) return false

    val divide : Int = sqrt(num.toDouble()).toInt()
    for(i in 2..divide){
        if(num % i == 0) return false
    }
    return true
}