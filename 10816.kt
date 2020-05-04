import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = sc.nextInt()
    var card = HashMap<Int, Int>() // key : card, value : the number of card
    //var card = Array(n){0}
    for(i in 0 until n) {
        val num = sc.nextInt()
        val value = card[num]

        if(value != null) card[num] = value+1
        else card[num] = 1
    }

    var m = sc.nextInt()
    while(m-- > 0){
        val find = sc.nextInt()
        if(card.containsKey(find)) bw.write("${card[find]} ")
        else bw.write("0 ")

    }
    bw.flush()
}