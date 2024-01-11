println("Hello world")
val pi : Double = 3.14 // val 변수명 : 자료형 = 값
println(pi)
val pi2 = 3.14 // val 변수명 = 값
println(pi2)

var name = "gil-dong" // 형 추론 (String)
name = "hong gil-dong"
println(name)

val numByte : Byte = 100
val numShort : Short = 20
val numint = 1 // 자료형 생략 가능
val numlong = 2L //자료형 생략 가능

val numDouble : Double = 3.2
val numFloat : Float = 3.2f

val char1 : Char = 'H'
val isTrue : Boolean = true
val greeting :String = "Hello world"

var age:Int = 20
// 타입이 한번 정해지면 바꿀 수 없다.
// age = "hello"

val 한글 : String = "한글은 세종대왕이 창제한 문자이다."
println(한글)

val stringArray : Array<String> = arrayOf("apple","banana","grape")
println(stringArray[0])
val intArray = arrayOf(1,2,3) // 자료형 생략
println(intArray[2])

// 명시적 형변환
val score = 100 // Int 형
println(score.javaClass)
println(score.javaClass.kotlin)

val scoreString = score.toString() // String 형
val scoreDouble = score.toDouble() // Double 헝
println(scoreDouble) // 100.0
println(scoreDouble.javaClass.kotlin) // 100.0

val a:Int = 7
val b:Int = 4
// 산술연산
println("${a} + ${b} = ${a + b}")
println("${a} - ${b} = ${a - b}")
println("${a} * ${b} = ${a * b}")
println("${a} / ${b} = ${a / b}")  // 정수 div 정수 = 정수
println("${a} % ${b} = ${a % b}")

// 관계연산
println("${a} > ${b} : ${a > b}")
println("${a} < ${b} : ${a < b}")
println("${a} >= ${b} : ${a >= b}")
println("${a} <= ${b} : ${a <= b}")
println("${a} == ${b} : ${a == b}")
println("${a} != ${b} : ${a != b}")

// 논리연산
val b1 = true
val b2 = false
println("${b1} and ${b2} : ${b1 and b2}")
println("${b1} && ${b2} : ${b1 && b2}")
println("${b1} or ${b2} : ${b1 or b2}")
println("${b1} || ${b2} : ${b1 || b2}")
println("! ${b1} : ${! b1}")

// 마이너스 값에 대한 나머지 연산시 부호를 따라감. 자바와 같음.
println("${a} % ${b} = ${a % b}")
val a2= -7
println("${a2} % ${b} = ${a2 % b}")

// 두 객체가 메모리 상에서 동일한 위치를 가리키는지 확인
println("${a} === ${b} : ${a === b}")
val c = a
println("${a} === ${c} : ${a === c}")

// 두 객체가 메모리 상에서 서로 다른 위치를 가리키는지 확인
println("${a} !== ${b} : ${a !== b}")
println("${a} !== ${c} : ${a !== c}")


// 그 외 연산
println(2 - 1.1)
println(2.minus(1.1))

// 파일의 시작에 import java.math.BigDecimal 선언
// 파일의 시작에 import java.math.BigInteger 선언

val bigDec1 = java.math.BigDecimal("2")
val bigDec2 = java.math.BigDecimal("1.1")
println(bigDec1.subtract(bigDec2))

val bigInt1 = java.math.BigInteger("123456789012345678901234567890")
val bigInt2 = java.math.BigInteger("987654321098765432109876543210")

// 덧셈
val sum = bigInt1 + bigInt2
println("덧셈 결과: $sum")

// 곱셈
val product = bigInt1 * bigInt2
println("곱셈 결과: $product")

// 나눗셈
val division = bigInt2 / bigInt1
println("나눗셈 결과: $division")

// 나머지 연산
val remainder = bigInt1 % bigInt2
println("나머지 연산 결과: $remainder")
