import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val octal = sc.nextLine()
    for(i in 0 until octal.length){
        var tmp = octal[i]-'0'
        var print = "000"
        while(tmp > 0){
            if(tmp >= 4) {
                print = "100"
                tmp -= 4
            }
            else if(tmp >= 2){
                print = print[0] + "10"
                tmp -= 2
            }
            else if(tmp >= 1){
                print = print.substring(0,2) + "1"
                tmp -= 1
            }
        }
        if(i == 0){
            bw.write("${print.toInt()}")
        }
        else bw.write("$print")
    }
    bw.flush()
}