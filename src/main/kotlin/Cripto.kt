data class Bitcoin(val quantity: Int)
data class Dollar(val quantity: Int)

class ExchangeProvider(){
    val bitcoinPrice = 20000
}

context (ExchangeContext)
fun wallet(
    bitcoin: Bitcoin,
    dollar: Dollar
): Dollar {
    return bitcoin + dollar
}

interface ExchangeContext {
    val exchangeProvider: ExchangeProvider
}

context(ExchangeContext)
operator fun Bitcoin.plus(other: Dollar): Dollar {
    return Dollar(other.quantity + (this.quantity * exchangeProvider.bitcoinPrice))
}


fun main(){
    val bitcoin = Bitcoin(2)
    val dollar = Dollar(500)
    val exchangeContext = object : ExchangeContext{
        override val exchangeProvider: ExchangeProvider
            get() = ExchangeProvider()
    }
    with(exchangeContext){
        val total = wallet(bitcoin, dollar)
        println("you have ${total.quantity} dollars in total")
    }
}