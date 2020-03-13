import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bf = BufferedWriter(OutputStreamWriter(System.out))

    val num = sc.nextInt()
    sc.nextLine()
    for(i in 1..num){
        val vps = sc.nextLine()
        var bracket = 0

        loop@ for(j in 0 until vps.length){
            when(vps[j]){
                '(' -> {
                    bracket++
                }
                ')' -> {
                    bracket--
                    if(bracket < 0) break@loop
                }
            }
        }

        if(bracket == 0) bf.write("YES\n")
        else bf.write("NO\n")
    }
    bf.flush()
}