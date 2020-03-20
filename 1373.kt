import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var binary = sc.nextLine()
    val len = binary.length

    if(len % 3 == 1){
        binary = "00$binary"
    }
    else if(len % 3 == 2){
        binary = "0$binary"
    }

    var i = 0
    while(i < len){
        bw.write("${(binary[i]-'0')*4 + (binary[i+1]-'0')*2 + (binary[i+2]-'0')*1}")
        i += 3
    }
    bw.flush()
}