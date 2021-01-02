import kotlin.collections.ArrayList

fun main() {
    val n = 5
    val arr = arrayOf(4, 2, -3, 1, 6)

    subArrayWithSumZero(arr)


}

fun reverseArray(arr: Array<Int>) : ArrayList<Int> {
    //arr.reverse()
    val size=arr.size
    var newArray=ArrayList<Int>()

    for (i in arr.size downTo 1){
        newArray.add(i)
    }

    return newArray
}

fun reverseArraySaveSpace(arr: Array<Int>) {
    var temp:Int?=null
    for (i in 0..arr.size/2){
        temp=arr[i]
        arr[i]=arr[arr.size-i-1]
        arr[arr.size-i-1]=temp
    }
}

fun Array<Int>.reverseArray() {
    var temp:Int?=null
    for(i in 0..this.size/2){
        temp=this[i]
        this[i]=this[this.size-i-1]
        this[this.size-i-1]=temp
    }
}

fun Array<Int>.arrayMaxAndMin() {
    /**
     * Finds max and min of an array and prints the values
     * Time complexity - O(n)
     * Space complexity - O(n)
     */

    var arr=this
    var max=0; var min=0
    for (i in arr.indices) {
        min=arr[0]
        max=arr[0]
        if(min>arr[i]){
            min=arr[i]
        }
        if (max<arr[i]){
            max=arr[i]
        }
    }
    print("$max $min")
}

fun Array<Int>.kThLargestAndSmallestInArray(k: Int) {
    /**
     * Finds and prints kth max and min element in the array
     * Time Complexity - O(nlog(n))
     * Space Complexity - same
     */
    var arr=this
    arr.sort()
    var max=0;var min=0
    max=arr[arr.size-k]
    min=arr[k]

    print("$max $min")
}

fun chocolateDistributionProblem(n: Int, m: Int, arr: Array<Int>) {
    /**
     *  Question: https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem/0
     *  Time Complexity - O(nlog(n))
     */

    arr.sort()
    val diffList = arrayListOf<Int>()

    for (i in arr.indices) {
        try {
            val diff = arr[i + m - 1] - arr[i]
            diffList.add(diff)

        } catch (e: ArrayIndexOutOfBoundsException) {
            break
        }

    }

    diffList.sort()

    println(diffList[0])


}

fun trappingRainWater(n: Int, arr: Array<Int>) {
    /**
     * Question- https://practice.geeksforgeeks.org/problems/trapping-rain-water/0
     *
     */

    val temp = arr.sortedArrayDescending()
    var waterQuantity = 0
    val height = temp.toSet().elementAt(1)


    for (i in arr.indices) {

        if (arr[i] < height && (i !=0 || i != arr.lastIndex) ) {
            waterQuantity += height - arr[i]
        }

    }

    println(waterQuantity)


}

fun subArrayWithSumZero(arr: Array<Int>) {
    /**
     *  Question - https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
     *
     */

    // Check if the array  already contains 0
    if (arr.contains(0))
        println("Yes")
    else {

    }
}




