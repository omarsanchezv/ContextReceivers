class Logger(private val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}

//now it is look like the store can be called when the logger is present, and it can be called only in that context
context (Logger)
fun store(s: String){
    log("Stored $s on disk")
}

fun main() {
    val logger = Logger("main")
    with(logger) {
        store("an image")
        store("a text file")
        store("a cheese burger")
    }
}