import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

var noteBook = Array(40){Array(40){0}}
var sticker = Array(10){Array(10){0}}
fun main() {
    val sc = Scanner(System.`in`)
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var ans = 0

    val n = sc.nextInt()
    val m = sc.nextInt()
    var k = sc.nextInt()

    while(k-- > 0){
        sticker = Array(10){Array(10){0}}

        var r = sc.nextInt()
        var c = sc.nextInt()
        var list : LinkedList<Pair<Int,Int>> = LinkedList()
        for(i in 0 until r){
            for(j in 0 until c) {
                val tmp = sc.nextInt()
                sticker[i][j] = tmp
                if(tmp == 1) list.add(Pair(i,j))
            }
        }

        outer@ for(tryAttach in 1..4){
            var check = false
            for(i in 0 until n){
                for(j in 0 until m){
                    check = attach(Pair(i,j), list, n, m, 0)
                    if(check) {
                        ans += list.size
                        break@outer
                    }
                }
            }

            if(!check){
                spin90(r,c)
                // swap
                val tmp = r
                r = c
                c = tmp

                list.clear()
                for(i in 0 until r){
                    for(j in 0 until c) {
                        if(sticker[i][j] == 1) list.add(Pair(i,j))
                    }
                }
            }
        }
    }

    bw.write("$ans")
    bw.flush()
}

fun attach(start : Pair<Int,Int>, list : LinkedList<Pair<Int,Int>>, n : Int, m : Int, now : Int) : Boolean {
    if(now == list.size) return true
    val tmp = list[now]

    val newY = start.first + tmp.first
    val newX = start.second + tmp.second

    if(newY < 0 || newY >= n || newX < 0 || newX >= m) return false
    if(noteBook[newY][newX] == 1) return false

    if(attach(start,list,n,m,now+1)) {
        noteBook[newY][newX] = 1
        return true
    }
    noteBook[newY][newX] = 0
    return false
}

// sticker 배열을 90도 돌림
fun spin90(r: Int, c : Int) {
    var change = Array(c){Array(r){0}}

    for(i in 0 until r){
        for(j in 0 until c){
            change[j][r-i-1] = sticker[i][j]
        }
    }

    sticker = change
}
