import java.util.*
import kotlin.collections.ArrayList

fun main(){
    val arr= arrayOf(1,2,3,4,5,6,7,8,9)

    arr.kThLargestAndSmallestInArray(readLine()?.toInt() ?:1)


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

fun Array<Int>.arrayMaxAndMin(){
    /**
     * Finds max and min of an array and prints the values
     * Time complexity - O(n)
     * Space complexity - O(n)
     */

    var arr=this
    var max=0; var min=0
    for (i in arr.indices){
        min=arr[0]
        max=arr[0]
        if(min>arr[i]){
            min=arr[i]
        }
        if (max<arr[i]){
            max=arr[i]
        }
    }
    print(max.toString()+" "+min.toString())
}

fun Array<Int>.kThLargestAndSmallestInArray(k:Int){
    var arr=this
    arr.sort()
    var max=0;var min=0
    max=arr[arr.size-k]
    min=arr[k]

    print(max.toString()+" "+min.toString())
}



