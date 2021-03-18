package com.example.hello

fun main() {

    // Instance 생성
    // Kotlin New선언 없음.
    val instance01 = MyClass()
    instance01.sayHello()

    var user01 = User1("유비" , 20)

    var user02 = User2("장비")
    var user03 = User2("장비", 20)

    var user04 = User3("장비")
    var user05 = User3("장비", 20)
    var user06 = User3("장비", 20, "java@naver.com")

    println("-----------------------------")

    var user07 = User4()
    user07.greeting = "Kim"
    println(user07.greeting)

}// ------

class MyClass{
    //-----
    // Properties
    //-----
    var name: String = "Apple"

    fun sayHello(){
        println("Hello $name")
    }
}// ---------


class User1(name: String, age: Int){
    // 초기 작업. <- 실행되자마자 구동되는 부분.
    init {
    println("$name's age is $age")
    }
}

// Construction
class User2(name: String){ // 주생성자.
    init {
        println("init : $name")
    }
    constructor(name: String, age: Int): this(name){
        println("contructor : $name, $age")
    }
}

class User3(name : String){
    init {
        println("init : $name")
    }
    constructor(name: String, age: Int): this(name){
        println("constructor01 : $name, $age")
    }
    constructor(name: String, age : Int, email: String) :this(name, age){
        println("constructor02 : $name, $age, $email")
    }
}

class User4{
    var greeting : String = "Hello"
    set(value) {
        field = "Hello!" + value
    }
    get() = field.toUpperCase()

    var age : Int = 0

}