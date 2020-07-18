package com.code_remote.bythepool

fun main() {
    println("Hello World")

    //Comments important
    val firstName = "Evert"

    //Verbose Kotlin doesn't need String
    val explicitType: String = "Evert"

    println(firstName)

    //The old way
    println("Hello "+firstName)

    //The new way
    println("$firstName you can type here again")

    //Run more single line code in a string with brackets
    println("This is double firstname ${firstName.trim()}")

    //Trim won't be called
    println("This is double firstname $firstName.trim() ")

    val age = 32
    val lastName = "van de Braak"

    println("My firstname is $firstName and my lastName is $lastName and i'm $age year's old")

    val myFloat = 123.3F
    val veryLongNumber: Long = 1234567890123456666L

    val result = myFirstFunctionWithReturn("Evert", "van de Braak")
    println(result)

    println(myFirstFunctionWithReturn("Evert", "van de Braak"))

    defaultValue("Evert")

    theFullSentence( age = 13, firstName =  "Evert")

}

fun theFullSentence(firstName:String, lastName: String = "Unknonwn", age: Int = 0): String{
    return "My firstname is $firstName and my lastName is $lastName."
}

fun myFirstFunction(){
    println("I just ran my first func")
}

fun myFirstFunction(lastName:String, firstName: String){
    println("I just ran my first func")
}

fun myFirstFunctionWithReturn(firstName:String, lastName: String): String{
    return "My firstname is $firstName and my lastName is $lastName."
}

fun defaultValue(firstName:String, lastName: String = "Unknonwn"): String{
    return "My firstname is $firstName and my lastName is $lastName."
}

