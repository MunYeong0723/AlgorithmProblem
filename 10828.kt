import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*
import kotlin.collections.ArrayList

class Stack(){
    var arr = ArrayList<Int>()

    fun push(x : Int){
        arr.add(x)
    }
     fun pop() : Int {
         if(arr.size > 0){
             val top = arr[arr.size-1]
             arr.removeAt(arr.size-1)
             return top
         }
         else return -1
    }
    fun size() : Int = arr.size
    fun empty() : Int = if(arr.size == 0) 1 else 0
    fun top() : Int = if(arr.size > 0) arr[arr.size-1] else -1
}

fun main() {
    val sc = Scanner(System.`in`)
    val bf = BufferedWriter(OutputStreamWriter(System.out))
    val num = sc.nextInt()
    sc.nextLine()
    var st = Stack()
    
    for(i in 1..num){
        when(sc.next()){
            "push" -> {
                st.push(sc.nextInt())
            }
            "pop" -> {
                bf.write("${st.pop()}\n")
            }
            "size" -> {
                bf.write("${st.size()}\n")
            }
            "empty" -> {
                bf.write("${st.empty()}\n")
            }
            "top" -> {
                bf.write("${st.top()}\n")
            }
        }
        sc.nextLine()
    }
    bf.flush()
}