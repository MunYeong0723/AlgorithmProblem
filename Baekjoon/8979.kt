import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val K = sc.nextInt()
    var country = Array(N+1) { Array<Int>(3){0} }

    for(i in 0 until N){
        val coun = sc.nextInt()
        var medal = Array<Int>(3){0}
        for(j in 0..2){
            medal[j] = sc.nextInt()
        }
        country[coun] = medal
    }

    var count = 1
    val wantToKnow = country[K]
    for(i in 1..N){
        if(i == K) continue

        if(country[i][0] == wantToKnow[0]){
            if(country[i][1] == wantToKnow[1]){
                if(country[i][2] > wantToKnow[2]) count++
            }
            else if(country[i][1] > wantToKnow[1]){
                count++
            }
        }
        else if(country[i][0] > wantToKnow[0]) count++
    }
    println(count)
}
