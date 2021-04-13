package com.technotap.dsaworkbook.dynamicprogramming

fun main() {
    val arr = arrayOf(1, 5, 11, 5)
    println(equalPartition(arr))
}

fun equalPartition(arr: Array<Int>): Boolean {
    var sum: Int = arr.sum()
    if ((sum and 1) == 1) return false
    sum /= 2
    var curr = Array(sum + 1) {false}
    var prev = Array(sum + 1) {false}
    var temp: Array<Boolean>
    curr[0] = true
    prev[0] = true
    for(i in arr.indices) {
        temp = curr
        curr = prev
        prev = temp
        for(j in 1..sum) {
            if(j < arr[i]) curr[j] = prev[j]
            else curr[j] = prev[j] or prev[j - arr[i]]
        }
    }
    return curr[sum]
}