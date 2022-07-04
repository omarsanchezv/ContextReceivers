import kotlin.random.Random
//Example from kotlin Jetbrains
fun main(args: Array<String>) {
    println("Hello, World!".sarcastic())
    printTransformedGreeting {
        this.sarcastic()
    }
}

fun String.sarcastic(): String {
    return this.asIterable().joinToString {
        if (Random.nextBoolean()) it.uppercase() else it.lowercase()
    }
}

fun printTransformedGreeting(transform: String.() -> String) {
    val greeting = "Hello, World!"
    val transformed = greeting.transform()
    println(transformed)
}