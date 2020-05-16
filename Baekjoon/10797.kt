import java.util.*

fun main() {
    val sc : Scanner = Scanner(System.`in`)
    var date = sc.nextInt()
    var warning = 0

    for(i in 1..5){
        if(date == sc.nextInt()) warning++
    }
    println(warning)
}