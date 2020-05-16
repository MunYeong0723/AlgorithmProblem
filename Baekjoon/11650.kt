import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

class Pair(x : Int, y : Int) : Comparable<Pair> {
    val x = x
    val y = y

    override fun compareTo(other: Pair): Int {
        if(other.x == this.x){
            return if(this.y <= other.y) -1 else 1
        }
        return if(this.x <= other.x) -1 else 1
    }
}

fun main() {
    val sc = Scanner(System.`in`)
    val bf = BufferedWriter(OutputStreamWriter(System.out))

    val num = sc.nextInt()
    var arr = Array(num+1){Pair(0, 0)}
    for(i in 1..num){
        arr[i] = Pair(sc.nextInt(), sc.nextInt())
    }

    var newArr = Array(num+1){Pair(0, 0)}
    mergeSort(1, num, arr, newArr)

    for(i in 1..num){
        bf.write("${arr[i].x} ")
        bf.write("${arr[i].y}\n")
    }
    bf.flush()
}

fun mergeSort(left: Int, right: Int, arr: Array<Pair>, newArr: Array<Pair>){
    if(left < right){
        var mid = (left + right) / 2
        mergeSort(left, mid, arr, newArr)
        mergeSort(mid+1, right, arr, newArr)
        merge(left, mid, right, arr, newArr)
    }
}

fun merge(left: Int, mid: Int, right: Int, arr: Array<Pair>, newArr: Array<Pair>){
    var i = left; var j = mid+1; var index = left
    while(index <= right){
        if(j > right) newArr[index++] = arr[i++]
        else if(i > mid) newArr[index++] = arr[j++]
        else if(arr[i] < arr[j]) newArr[index++] = arr[i++]
        else newArr[index++] = arr[j++]
    }

    for(i in left..right){
        arr[i] = newArr[i]
    }
}