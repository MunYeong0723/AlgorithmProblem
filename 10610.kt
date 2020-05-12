import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var N = sc.nextLine()
    var arr = ArrayList<Char>()
    var checkZero = false
    var sumNums = 0
    for(i in 0 until N.length) {
        arr.add(N[i])

        val tmp = N[i]
        if(tmp-'0' == 0) checkZero = true
        else sumNums += tmp-'0'
    }

    if(!checkZero || sumNums % 3 != 0) bw.write("-1")
    else {
        arr.sort()
        for(i in arr.size-1 downTo 0){
            bw.write("${arr[i]}")
        }
    }
    bw.flush()
}