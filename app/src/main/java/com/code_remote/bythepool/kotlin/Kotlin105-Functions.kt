package com.code_remote.classes.class1

fun main(args: Array<String>) {

    doSomethingFunctional()

    val quote = "He who fears he will suffer, already suffers because he fears."
    val author = "Michel De Montaigne"

    passingValueThroughFunction(quote)

    val quoteAndAuthor = getAvalueBack(quote, author)

}

fun doSomethingFunctional() {
    println("I just did something functional")
}

fun passingValueThroughFunction(nameItWhatEverYouWant: String){
    //default value
    //make it nullable
}

fun getAvalueBack(quote:String, author: String) : String {
    return "$quote - $author"
}