import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val min = sc.nextInt()
    val max = sc.nextInt()
    var isPrime = Array(max+1){true}
    isPrime[1] = false

    for(tmp in 2..max){
        if(isPrime[tmp]){
            for(inner in 2..max){
                if(tmp*inner <= max) isPrime[tmp*inner] = false
                else break
            }
        }
    }

    for(i in min..max){
        if(isPrime[i]) bw.write("$i\n")
    }
    bw.flush()
}