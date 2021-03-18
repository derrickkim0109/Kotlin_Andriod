package com.example.hello

fun main() {
    // Pascal, Camel, Snake
    // AppleFruit, appleFruit, apple_fruit

    // 변수 선언
    // val : value의 약자로 변경 불가능한 Assign-Once(immutable) 변수
    // var : variable의 약자로 변경이 가능한 mutable 변수

    // 정수, 변수의 선언
    // ; 세미콜론 없다.

    var num1 : Int = 10
    var num2 : Int = 20

    println(num1 + num2)

    // null을 허용하지 않고 data를 할당하는 변수의 선언
    val num3 : Int // 이렇게 쓰면 null 허용 하지 않음
    val num4 : Int? = null // null 을 허용 하겠다.

    // Class안의 전역변수와 지역변수의 초기화
    class User{
        val objData1: String = "String" // 전역변수는 무조건 초기값이 필요하다.

        fun some(){
            // 함수안의 지역변수는 초기값을 안줘도 된다는 차이점이 존재!
            val location1 : String
        }
    }

    // String Interpolation
    // Swift와는 차이점이네 \ 안쓰고 $쓰는것.
    println("2 + 3 =  ${num1 + num2} ")

    // 범위 연산자
    // 끝의 함수에 연산자 못씀.
    for(i in 3..5){
        print("$i")
    }
    println()

    // null 안전 관련 연산자 = null safety
    var a : Int? = null
    val nullCheck = a ?: 10 // a = null 이면 10 을 줘라 .
    println(nullCheck)

    // it 연산자
    var array1 = arrayOf(10, 20, 30) // 배열 선언 해준것이다.
    array1.forEach {
        println("$it 이란")
    }

}// --- END