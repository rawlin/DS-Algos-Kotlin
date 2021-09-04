import kotlin.math.sqrt

fun main() {
    val a = primeSieve(15)
    a.forEach { prime ->
        println(prime)
    }

}

fun findSecondLargestNumber(arr: IntArray): Int? {
    if (arr.isEmpty()) return null
    if (arr.size == 1) return arr[0]

    var largest = Int.MIN_VALUE
    var secondLargest = Int.MIN_VALUE


    for (i in arr.indices) {
        if (arr[i] > largest) {
            secondLargest = largest
            largest = arr[i]
        } else if (arr[i] > secondLargest && arr[i] != largest) {
            secondLargest = arr[i]
        }
    }

    return secondLargest
}

private fun removeWhiteSpaces(string: String): String {

    val result: MutableList<Char> = ArrayList()

    for (i in string) {
        if (i != ' ') {
            result.add(i)
        }
    }

    return result.toString()
}


fun reverseArray(arr: Array<Int>): ArrayList<Int> {
    //arr.reverse()
    val size = arr.size
    var newArray = ArrayList<Int>()

    for (i in arr.size downTo 1) {
        newArray.add(i)
    }

    return newArray
}

fun reverseArraySaveSpace(arr: Array<Int>) {
    var temp: Int? = null
    for (i in 0..arr.size / 2) {
        temp = arr[i]
        arr[i] = arr[arr.size - i - 1]
        arr[arr.size - i - 1] = temp
    }
}

fun Array<Int>.reverseArray() {
    var temp: Int? = null
    for (i in 0..this.size / 2) {
        temp = this[i]
        this[i] = this[this.size - i - 1]
        this[this.size - i - 1] = temp
    }
}

fun Array<Int>.arrayMaxAndMin() {
    /**
     * Finds max and min of an array and prints the values
     * Time complexity - O(n)
     * Space complexity - O(n)
     */

    var arr = this
    var max = 0;
    var min = 0
    for (i in arr.indices) {
        min = arr[0]
        max = arr[0]
        if (min > arr[i]) {
            min = arr[i]
        }
        if (max < arr[i]) {
            max = arr[i]
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
    var arr = this
    arr.sort()
    var max = 0;
    var min = 0
    max = arr[arr.size - k]
    min = arr[k]

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

        if (arr[i] < height && (i != 0 || i != arr.lastIndex)) {
            waterQuantity += height - arr[i]
        }

    }

    println(waterQuantity)


}

fun primeSieve(n: Int): IntArray {
    val primes = BooleanArray(n + 1) { true }

    primes[0] = false
    primes[1] = false

    for (i in 2..(sqrt(n.toFloat()).toInt())) {
        if (primes[i]) {
            var j = 2
            while (i * j <= n) {
                primes[i * j] = false
                j++
            }
        }
    }

    val foundPrimes = mutableListOf<Int>()

    primes.forEachIndexed { index, prime ->
        if (prime)
            foundPrimes.add(index)
    }
    return foundPrimes.toIntArray()
}




