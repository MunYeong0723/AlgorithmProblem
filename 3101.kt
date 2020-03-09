import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val K = sc.nextInt()
    sc.nextLine()

    // put maximum number each diagonal line
    var arr = Array(2*N){0}
    var max = 0
    var add = 0
    for(i in 1 until 2*N){
        if(i <= N) max += ++add
        else max += --add
        arr[i] = max
    }

    // Rabbit jump
    var string = sc.next()
    val input = string.split("")
    var ans = 1
    var x = 1
    var y = 1
    for(i in input){
        when(i){
            "U" -> {
                ans += findNumber(N, --y, x, arr)
            }
            "D" -> {
                ans += findNumber(N, ++y, x, arr)
            }
            "L" -> {
                ans += findNumber(N, y, --x, arr)
            }
            "R" -> {
                ans += findNumber(N, y, ++x, arr)
            }
        }
    }
    println(ans)
}

fun findNumber(N : Int, y : Int, x : Int, array : Array<Int>) : Int{
    val lineNum = y + x - 1
    var num = array[lineNum]

    if(lineNum <= N){
        if(lineNum % 2 == 0){
            var start_y = lineNum
            var start_x = 1

            while(x != start_x || y != start_y){
                start_y--
                start_x++
                num--
            }
        }
        else {
            var start_y = 1
            var start_x = lineNum

            while(x != start_x || y != start_y){
                start_y++
                start_x--
                num--
            }
        }
    }
    else {
        if(lineNum % 2 == 0){
            var start_y = N
            var start_x = lineNum + 1 - N

            while(x != start_x || y != start_y){
                start_y--
                start_x++
                num--
            }
        }
        else {
            var start_y = lineNum + 1 - N
            var start_x = N

            while(x != start_x || y != start_y){
                start_y++
                start_x--
                num--
            }
        }
    }
    return num
}