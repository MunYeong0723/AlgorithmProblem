import java.util.*

fun main() {
    val sc:Scanner = Scanner(System.`in`)
    var play = Array(3) {""}

    for(j in 0..2){
        var head = 0
        for(i in 1..4) {
            when (sc.nextInt()) {
                0 -> {
                    head++
                }
            }
        }
        when(head){
            0 -> {
                play[j] = "E"
            }
            1 -> {
                play[j] = "A"
            }
            2 -> {
                play[j] = "B"
            }
            3 -> {
                play[j] = "C"
            }
            4 -> {
                play[j] = "D"
            }
        }
    }

    for(j in 0..2){
        println(play[j])
    }
}