package com.example.hello

import kotlin.math.pow

fun main() {
    // Return 값이 없는 경우
    sum01(10, 20)
    println(sum03(10, 20))

    // 함수의 overloading
    some("abc")
    some(10)
    some(10, "abc")

    // 함수의 기본값.
    sayHelllo1("Kim")
    sayHelllo1()// 아무것도 안쓸수도 있다.

    // 함수의 null 처리
    sayHello2("Kim")
    sayHello2(null)

    // 가변 인수 처리 <- 함수의 데이터가 몇개가 들어올지 모른다.
    varFun("a","b", "c")
    varFun("a", "b", "c", "d")


    // BMI
    var resultText = bmiCalculation(75, 170)
    println("당신은 $resultText 입니다.")

}// ---- END


fun sum01(a : Int, b : Int ){
    println(a + b)
}

fun sum03(a : Int , b : Int ) : Int = a + b // : Int 는 안적어도 됨.


fun some(a : String){

}

fun some(a : Int) {

}

fun some(a : Int , b: String){

}

fun sayHelllo1(name : String = "Anonymous"){ // 데이터가 없을경우 Anonymous라는 값이 찍히도록 null값 처리함.
    println("Hello $name")
}

fun sayHello2(name: String?){ // ? null 값이 들어올수 있는것을 처리
    if (name == null){
        println("Hello Anonymous")
    }else{
        print("Helllo $name")

    }
}
// variable argument <- Key word : vararg
fun<T> varFun(vararg array: T ){
    for (a in array){
        println(a)
    }
}

fun bmiCalculation(weight : Int, height : Int ) : String{
    var weightDouble = weight.toDouble()
    var heightDouble = height.toDouble() / 100.0
    var bmiCalc : Double = weightDouble / heightDouble.pow(2)

    print("BMI지수 : %.2f".format(bmiCalc))
    return when(bmiCalc){
        in 1.0 .. 18.5 -> "저체중"
        in 18.5 .. 23.0 -> "정상"
        in 23.0 .. 25.0 -> "정상"
        in 25.0 .. 30.0 -> "정상"
        else -> "고도 비만"
    }

}  // return 타입은 : String이다.