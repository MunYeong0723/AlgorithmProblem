import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*

fun mergeSort(left: Int, right: Int, arr: IntArray, newArr: IntArray){
    if(left < right){
        var mid = (left + right) / 2
        mergeSort(left, mid, arr, newArr)
        mergeSort(mid+1, right, arr, newArr)
        merge(left, mid, right, arr, newArr)
    }
}
fun merge(left: Int, mid : Int, right: Int, arr: IntArray, newArr: IntArray){
    // merge
    var i = left; var j = mid+1; var index = left
    while(index <= right){
        if(j > right) newArr[index++] = arr[i++]
        else if(i > mid) newArr[index++] = arr[j++]
        else if(arr[i] < arr[j]) newArr[index++] = arr[i++]
        else if(arr[i] >= arr[j]) newArr[index++] = arr[j++]
    }

    // copy
    for(i in left..right){
        arr[i] = newArr[i]
    }
}

fun main() {
    val bf = BufferedWriter(OutputStreamWriter(System.out))
    val sc = Scanner(System.`in`)
    val num = sc.nextInt()
    var arr = IntArray(num+1){0}
    for(i in 1..num){
        arr[i] = sc.nextInt()
    }

    var newArr = IntArray(num+1){0}
    mergeSort(1, num, arr, newArr)
    for(i in 1..num){
        bf.write("${arr[i]}\n")
    }
    bf.flush()
}