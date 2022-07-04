class Logger(private val name: String) {
    fun log(s: String) = println("$name: $s")
}

class NotificationSender{
    fun send(s: String) = println("Notify: $s")
}

context (Logger, NotificationSender)
fun store(s: String){
    log("Stored $s on disk")
    send("Successful storage event")
}

fun main() {
    val logger = Logger("main")
    val notificationSender = NotificationSender()
    with(logger) {
        with(notificationSender) {
            store("an image")
            store("a text file")
            store("a cheese burger")
        }
    }
}