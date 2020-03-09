import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val K = sc.nextInt()
    sc.nextLine()

    // make board
    //var jump = Array(N+1){Array(N+1){0}}
    var jump = Array(N+1){ IntArray(N+1)}
    var num = 1
    var x = 1
    var y = 1
    jump[y][x++] = num++
    while(num <= N*N) {
        if(x == 1 || y == N){
            while(y >= 1 && x <= N){
                jump[y--][x++] = num++
            }
            if(x > N) {
                y++
                x = N
            }
            if(y < 1) y = 0
            y++
        } else if(y == 1 || x == N){
            while(x >= 1 && y <= N){
                jump[y++][x--] = num++
            }
            if(y > N) {
                y = N
                x++
            }
            if(x < 1) x = 0
            x++
        }
    }

    x = 1
    y = 1
    var ans = 1
    // Rabbit jump
    var string = sc.next()
    val input = string.split("")
    for(i in input){
        when(i){
            "U" -> {
                ans += jump[--y][x]
            }
            "D" -> {
                ans += jump[++y][x]
            }
            "L" -> {
                ans += jump[y][--x]
            }
            "R" -> {
                ans += jump[y][++x]
            }
        }
    }
    println(ans)
}