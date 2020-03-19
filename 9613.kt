import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val num = sc.nextInt()
    var ans : Long
    for(i in 1..num){
        ans = 0L
        val size = sc.nextInt()
        var arr = Array(size){0}
        arr[0] = sc.nextInt()

        // start find all gcd
        for(outer in 0 until size){
            for(inner in outer+1 until size){
                if(outer == 0) arr[inner] = sc.nextInt()
                ans += gcd(arr[outer], arr[inner])
            }
        }
        bw.write("$ans\n")
    }
    bw.flush()
}

fun gcd(a : Int, b : Int) : Int{
    if(a%b == 0) return b
    return gcd(b, a%b)
}