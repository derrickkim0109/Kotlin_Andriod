package com.example.hello

fun main() {

    // Genearic 은 타입을 딱 정해서 쓰는것이다.

    // Data Type을 혼용해서 쓰는 Array
    var array = arrayOf(1, "Korea", true)
    // array는 {} 중괄호를 써야한다.
    println("${array[0]} ... ${array[1]} ... ${array[2]}")
    array[0] = 10

    // 정수만 사용하는 Array
    var arrayInt = arrayOf<Int>(10, 20, 30)// 타입 정리해서 쓰는게 훨씬 깔끔하다.
    println(arrayInt.max())
    println(arrayInt.reverse()) // 역순 찍기
    println(arrayInt.average())
    println(arrayInt.sorted())
    println(arrayInt.contains(7)) //7이 포함 되있냐? True or False
    // 정수 전용 Array
    var arrayInt2 = intArrayOf(10, 20, 30)

    // 실수 전용 Array
    var doubleArray = doubleArrayOf(1.1, 1.2, 1.3)

    // 계산 값을 Array 전용(Lambda 함수 사용 ) -> Closure랑 비슷 {}
    // array를 array로 잡는다.
    var array1 = Array(3){i -> i * 10 } // 10, 20, 30
    var array2 = Array<Int>(3) { i -> i * 100}

    // 혼합형 Array의 초기값을 Null로 적용
    var array3 = arrayOfNulls<Any>(3)
}