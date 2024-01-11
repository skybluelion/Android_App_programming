val price = 3000
val tax = 300
val originalPrice = "The original price is $price"
val totalPrice= "The total price is ${price + tax}"
println(originalPrice) // The original price is 3000
println (totalPrice) // The total price is 3300

val god:String = "신";
val human = "인간";
val msg = """
    실수란 
    ${god}을 용서하는
    ${human}의 행위이다.
"""
println(msg)
println(msg.trimIndent())