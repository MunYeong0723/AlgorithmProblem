import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val max = 1000000
    var isPrimeArr = Array(max+1){true}
    isPrimeArr[1] = false

    // find prime number
    for(i in 2..max){
        if(isPrimeArr[i]){
            for(j in 2..max){
                if(i*j <= max) isPrimeArr[i*j] = false
                else break
            }
        }
    }

    while(true){
        var input = sc.nextInt()
        if(input == 0) break

        var i = 3
        while(i <= input/2){
            if(!isPrimeArr[i]) { i++; continue }
            if(isPrimeArr[input-i] && (input-i) % 2 != 0) {
                bw.write("$input = $i + ${input-i}\n")
                break
            }
            i++
        }
        if(i > input/2) bw.write("Goldbach's conjecture is wrong.\n")
    }
    bw.flush()
}