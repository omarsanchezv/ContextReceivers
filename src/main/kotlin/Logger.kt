class Logger(private val name: String) {
    fun log(s: String) {
        println("$name: $s")
    }
}

// it works, but architecturally what do you think the name is correct?
fun Logger.store(s: String){
    log("Stored $s on disk")
}

fun main() {
    val logger = Logger("main")
    with(logger) {
        store("an image")
        store("a text file")
        store("a chese burger")
    }
}