package com.code_remote.classes.class1

fun main(args: Array<String>){

    //capital sensitive, we write camelCase

    var yesOrNo: Boolean = true     //acltually a 1 for true or a 0 for false

    var number: Int = 5432 //positive and negative

    var veryLongNumber: Long = 999999999999999999L
    println(veryLongNumber)

    veryLongNumber = System.currentTimeMillis() //max long used for time in miliseconds
    println(veryLongNumber)

    var decimalUnpreciseNumber: Float = 9999.9999999999f //notice the f at the end rounds at 6-7 decimals

    var decimalNumber: Double = 9999.9999999999 //power of308

    var word: String = "All fits in a string, $decimalNumber, $veryLongNumber $number"


    println("false")
    println(yesOrNo) //automatic typecasting

    //number = veryLongNumber you can't put something bigger in something smaller
    veryLongNumber = number.toLong()
    number = veryLongNumber.toInt()

    println(decimalUnpreciseNumber) //Used for graphic calculations with view's
    println(decimalNumber) //Used for calculations (not money)

    val whatIsTheOutcome: Int = 10/3 //Important lesson!
    println(whatIsTheOutcome)

    //Calculations BODMAS () ^2 / * + -
    //Brackets, Orders, Division, Multiply, add, substract
}