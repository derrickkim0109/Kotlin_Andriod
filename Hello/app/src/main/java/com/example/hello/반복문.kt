package com.example.hello

fun main() {
    for (i in 1..10){
        println(i)
    }

    // 1부터 100까지 합계 출력
    var sum : Int = 0
    for(i in 1..100){
        sum += i
    }
    println("1부터 100까지의 합은 $sum 입니다.")

    // 1 ~ 99
    for (i in 1 until 100){

    }

    // 2부터 100까지의 숫자중 짝수만 출력
    for (i in 2..100 step 2){

    }

    // 100부터 1까지 감소하면서 출력
    for(i in 100 downTo 1){
        println(i)
    }

    // 99부터 1까지 홀수만 출력
    for (i in 99 downTo 1 step 2){

    }

    // 99 98 97 ..... 90
    // 89 88 87 ..... 80
    // :
    // :
    // 9 8 7 6 5 4 3 2 1

    for (i in 99 downTo 1 ){


        if (i % 10 == 0){
            println()
        }else{
            print("$i ")
        }
    }

    // break with label
    // 바깥쪽 for문에도 같이 break가 걸림
    stop@for (i in 1 .. 3){
        for(j in 1.. 3){
            if (j > i)break@stop
            println("i : $i, j : $j")
        }
    }

}// --- END
