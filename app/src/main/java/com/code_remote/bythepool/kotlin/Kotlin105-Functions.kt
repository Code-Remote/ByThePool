package com.code_remote.classes.class1

fun main(args: Array<String>) {

    doSomethingFunctional()

    val quote = "He who fears he will suffer, already suffers because he fears."
    val author = "Michel De Montaigne"

    aFunctionWithParameter(quote)

    val quoteAndAuthor = aFunctionWithParamAndReturnValue(quote, author)
    println(quoteAndAuthor)

    println(aFunctionWithParamThatHasDefautlValue("Just A Quote But No Author"))
}

fun doSomethingFunctional() {
    println("I just did something functional")
}

fun aFunctionWithParameter(nameItWhatEverYouWant: String) {
    //default value
    //make it nullable
}

fun aFunctionWithParamAndReturnValue(quote: String, author: String): String {
    return "$quote - $author"
}

fun aFunctionWithParamThatHasDefautlValue(quote: String, author: String = "Unknown"): String {
    return "$quote - $author"
}