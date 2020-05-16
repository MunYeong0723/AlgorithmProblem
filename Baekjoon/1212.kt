import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val trans = arrayOf("000", "001", "010", "011", "100", "101", "110", "111")

    val octal = sc.nextLine()
    for(i in 0 until octal.length){
        val tmp = octal[i]-'0'
        if(i == 0) bw.write("${trans[tmp].toInt()}")
        else bw.write("${trans[tmp]}")
    }
    bw.flush()
}