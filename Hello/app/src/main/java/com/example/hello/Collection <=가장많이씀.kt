package com.example.hello

fun main() {
    // List: 정해진 크기의 자료만 구성
    val list01 : List<String> = listOf("유비", "관우") // 한번 정해지면 추가하거나 수정할수 없다.

    // Mutable List : 정해지지 않은 크기의 자료 구성
    val list02 : MutableList<String> = mutableListOf("유비", "관우")
    list02.add("장비") // append 개념이라 제일 뒤에 들어감.
    println(list02)
    list02.add(1, "여포") // 1번에 여포를 주겠다.
    println(list02)
    list02.remove("장비")
    println(list02)
    list02.removeAt(1)
    println(list02)

    // ArrayList
    val arrayList : ArrayList<String> = ArrayList() //  빈값임.
    arrayList.add("유비")
    arrayList.add("관우")
    arrayList.add("장비")
    println(arrayList)
    arrayList.remove("관우")
    println(arrayList)


}