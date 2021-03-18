package com.example.hello

fun main() {

    // 문자가 들어올지 숫자가 들어올지 모를때 쓰는게 Any
    println(getLength("Hello"))
    println(getLength(123))


    // Type 변환
    val a1 : Int = 10
    var a2 : Double = a1.toDouble()


} // End of the main

fun getLength(obj: Any) : Int { // 개수 구할때!
    if (obj is String){
        return obj.length
    }
    return obj.toString().toInt()
}