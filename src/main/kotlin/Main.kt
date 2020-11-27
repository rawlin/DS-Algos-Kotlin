import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val arr= arrayOf(1,2,3,4)

    arr.reverseArray()
    arr.forEach { i -> print(i)  }

}

fun reverseArray(arr: Array<Int>):ArrayList<Int> {
    //arr.reverse()
    val size=arr.size
    var newArray=ArrayList<Int>()

    for (i in arr.size downTo 1){
        newArray.add(i)
    }

    return newArray
}

fun reverseArraySaveSpace(arr:Array<Int>){
    var temp:Int?=null
    for (i in 0..arr.size/2){
        temp=arr[i]
        arr[i]=arr[arr.size-i-1]
        arr[arr.size-i-1]=temp
    }
}

fun Array<Int>.reverseArray(){
    var temp:Int?=null
    for(i in 0..this.size/2){
        temp=this[i]
        this[i]=this[this.size-i-1]
        this[this.size-i-1]=temp
    }
}



