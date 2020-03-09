import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    val K = sc.nextInt()
    sc.nextLine()

    // put maximum number each diagonal line
    var arr = Array(2*N){0L}
    var max = 0L
    var add = 0L
    for(i in 1 until 2*N){
        if(i <= N) max += ++add
        else max += --add
        arr[i] = max
    }

    // Rabbit jump
    var string = sc.next()
    val input = string.split("")
    var ans = 1L
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

fun findNumber(N : Int, y : Int, x : Int, array : Array<Long>) : Long {
    val lineNum = y + x - 1
    var num = array[lineNum]

    if(lineNum <= N){
        if(lineNum % 2 == 0) num -= x - 1
        else num -= y - 1
    }
    else {
        if(lineNum % 2 == 0) num -= N - y
        else num -= N - x
    }
    return num
}