package com.example.hello

fun main() {
    val num1 = 5
    if ( num1 < 10 ){
        print("$num1 < 10")
    }

    if (num1 > 0 && num1 <= 10){
        println("0 < $num1 <= 10")
    }else if (num1 > 10 && num1 <= 20){
        println("10 < $num1 <= 20")
    }else{
        println("$num1 > 20 ")
    }

    // Simplify 한것.  위에랑 똑같은 것.
    if (num1 in 1..10){
        println("0 < $num1 <= 10")
    }else if (num1 > 10 && num1 <= 20){
        println("10 < $num1 <= 20")
    }else{
        println("$num1 > 20 ")
    }

    //-----------------------------------------------------------------------------
    // if 표현식 -- > 이런 표현식은 if 와 else 가 같은 열에 존재 해야함. 자동 return 값임.
    val result = if(num1 > 10 ) "유비" else "관우"
    println(result)

    val result2 = if(num1 < 10){
        print("유비 : ")
        10 + 20
    }else{
        print("관우 :")
        20 + 20
    }
    println(result2)

    //-----------------------------------------------------------------------------
    // When 표현식
    val  num2 = 1
    when(num2){
        1 -> println("num2 == 1")// 1일 경우에? 이렇게 쓴다.
        2 -> println("num2 == 2")
        else -> { // defalut 값 쓰기
            println("num2 is neither 1 nor 2")
        }
    }

    val data1 = "Apple"
    when(data1){
        "Apple" -> println("iPhone")
        "Samsung" -> println("Galaxy")
        else -> println("data1 is not Apple or Samsung")
    }

    // 여러 값을 조건으로 표현
    val data2 = 30
    when(data2){
        10, 20 -> println("data2 is 10 or 20")// 10일 경우 20 일 경우 <- ,로 여러값을 한꺼번에 체크가 가능하다.
        30, 40 -> println("data2 is 30 or 40")
        else -> println("????")
    }

    // 특정 범위를 조건으로 표현
    val num3 = 15
    when(num3){
        !in 1..100 -> println("Invalid data") // not -> !
        in 1..10 -> println("1 <= $num3 <= 10")
        in 11..20 -> println("11 <= $num3 <= 20")
        else -> println("$num3 > 20")
    }

    // list(ArrayList)나 배열로 data 찾기
    val list = listOf<String>("유비", "관우", "장비")
    val array = arrayOf("조조", "여포", "초선")
    val data4 = "초선"
    when(data4){
        in list -> println("$data4 is in list")
        in array -> println("$data4 is in array")
    }

    // if-else의 대체
    val data5 = 15
    if(data5 <= 10){
        println("$data5 < 10")
    }else if(data5 in 11..20){
        println("10 < $data5 <= 20 ")
    }else {
        println("$data5 > 20")
    }

    // when으로 변경하기
    when(data5){
        in 0..10 -> println("$data5 < 10")
        in 11..20 -> println("10 < $data5 <= 20 ")
        else -> println("$data5 > 20")
    }

    when{
        data5 <= 10 ->  println("$data5 < 10")
        data5 in 11..20 -> println("10 < $data5 <= 20 ")
        data2 in 1..10 ->  println("10 < $data2 <= 20 ")
        else -> println("$data5 > 20")
    }


    // 함수를 이용한 다양한 타입의 데이터에 대한 조건식 처리

    testWhen(1) // Integer
    testWhen("Apple") // String
    testWhen(true) // Boolean

    //--------------------
    // 사용자가 입력한 숫자가 짝수 인지 홀수 인지 판별한다.
    print("숫자를 입력하세요.!")
    var inputValue: Int = readLine()!!.toInt() // !! <- 강제 unwrapping
    if (inputValue % 2 == 0 ){
        println("$inputValue 는(은) 짝수 입니다.")
    }else{
        println("$inputValue 는(은) 홀수 입니다.")
    }


    quiz()



    //--------------------
} // end of main function


// function 은 Main Function 밖에 존재해야함.
fun testWhen(data: Any){
    when(data){
        1 -> println("data value is 1")
        "Apple" -> println("data value is Apple")
        is Boolean -> println("data type is Boolean ")
    }
}

// ------------------------------------------------
// *** 19세 이상의 BMI 계산기 ***
// 몸무게를 입력하세요 ! (Kg) :
// 키를 입력하세요 ! (cm) :
// BMI 지수:
// 비만 입니다.
// ------------------------------------------------

fun quiz(){
    print("몸무게를 입력하세요!(Kg) :")
    var inputWeightValue : Int = readLine()!!.toInt() // !! <- 강제 unwrapping
    print("키를 입력하세요!(cm) :")
    var inputHeightValue : Int = readLine()!!.toInt()
    //var bmiCalc : Double = (inputWeightValue/(inputHeightValue*inputHeightValue)) * 100 .toDouble()
    var bmiCalc : Double = (inputWeightValue/(inputHeightValue*inputHeightValue)) * 100 .toDouble()

    println("bmi = $bmiCalc")
    when{
        bmiCalc <= 18.5 -> println("저체중 입니다.")
        bmiCalc > 18.5 && bmiCalc < 23 -> println("정상 입니다.")
        bmiCalc >= 23 && bmiCalc < 25 -> println("정상 입니다.")
        bmiCalc > 25 -> println("비만입니다.")
        else -> println("다시 입력해주세요.")
    }
}
