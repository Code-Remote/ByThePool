package com.code_remote.bythepool

import android.util.Log

fun main() {
    println("How to write output to the Logcat ")

    Log.e("TAG: ", "Error output for logcat in RED (better readible)")

    //This is a comment and will be neglected during runtime

    /** doucmentation **/

    var explicitStringVariable: String = "This is a string"
    var implicitStr = "This is also a string, Kotlin very Smart"
    var numberofTypeInt = 1
    var numberofTypeDouble = 93.00
    var nubmerofTypeFloat = 93.00f
    var longNumber = 1234567890098765432L

    //Vars are mutable and can change
    var thisVarCanChange = 15
    val thisVariableCannotChange = 77


    val alwaysTryToUseAValInsteadOfVar: String = "this way you run in less problems when you are" +
            " using lot's of variables in your code an by accident change another"

    val conCatinationWithOtherVal = "This string has $numberofTypeInt variable Inside"
    val conCatinationWithOtherVals = "This string has $numberofTypeInt variable Inside"
}

fun mainOperations() {

    //    https://kotlinlang.org/docs/reference/control-flow.html

    val number = 10
    if (number > 10) {

    } else if (number < 10 && number >= 0) {
        //Run code in this block
    } else {

    }

    //When is like a switch case but also like an ifelse
    when (number) {
        1 -> {
            //run code block if number is 10
        }
        10 -> {
            println("this will run ")
        }
        else -> println("You don't have to use brackets if it's just a single line of code ")
    }

    //When like an ifelse
    val assignRightaway = when {
        number > 10 -> {
            20
        }
        else -> {
            30
        }
    }
}

