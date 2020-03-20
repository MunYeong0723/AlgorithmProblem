import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var bin = Stack<Char>()
    var oct = Stack<Int>()

    val binary = sc.nextLine()
    for(i in 0 until binary.length) bin.push(binary[i])

    // calculate binary to octal
    while(!bin.empty()){
        var octal = 0
        var mul = 1
        if(bin.size >= 3){
            for(i in 0..2){
                if(bin.pop() == '1') octal += mul
                mul *= 2
            }
        }
        else {
            for(i in 0 until bin.size){
                if(bin.pop() == '1') octal += mul
                mul *= 2
            }
        }
        oct.push(octal)
    }

    while(!oct.empty()) bw.write("${oct.pop()}")
    bw.flush()
}