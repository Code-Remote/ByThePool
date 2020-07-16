package com.code_remote.classes.class1

fun main(args: Array<String>) {

    val numberDecimal: Double = 5432.09


    val iWantToWriteWhatIRememberToBe = true
    if(iWantToWriteWhatIRememberToBe){
        //run this code
    }

    if(!iWantToWriteWhatIRememberToBe){
        //Run this code if it's '!' not true. With '!' you negate the statement
    }

    if(1+3==4){
        //run this code if the statement is true
    }else{
        //run if the statement would not be true
    }

    println("Enter a number?")
    var number = readLine()!!.toInt()

    if (number > numberDecimal) {
        println("You entered a Higher number")
    } else if (number < 100) {
        println("You entered a Lower then 100 number")
    } else {
        println("Probably between $numberDecimal and 100")
    }

    when {
        number > numberDecimal -> println("You entered a Higher number")
        number < 100 -> println("You entered a Lower then 100 number")
        else -> println("Probably between $numberDecimal and 100")

    }
    // Operators >= <= || &&

}