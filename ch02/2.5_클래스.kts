//클래스 선언
class Car1

class Car2(val color : String)

val car = Car2("red")
println(car.color) // red


//클래스 생성자
//주 생성자
class Person1 constructor(name : String) {}

class Person2(name : String) {}

class Person3(val name : String) {}

//보조 생성자
class Person4 {
    constructor(age : Int) {
        println("I'm $age years old")
    }
}

class Person5(name : String) {
    constructor(name : String, age : Int) : this(name) {
        println("I'm $age years old")
    }
}

//초기화 블록
class Person6(name : String) {
    val name : String
    init {
        if(name.isEmpty()) {
            throw IllegalArgumentException("Name is empty")
        }
        this.name = name
    }
}

val newPerson = Person6("")
println(newPerson.name) // IllegalArgumentException: Name is empty

val newPerson2 = Person6("Kim")
println(newPerson2.name) // Kim

// 2.5.3 클래스의 상속
open class Flower{
    open fun waterFlower() {
        println("물을 주다")
    }
}

class Rose : Flower() {
    override fun waterFlower() {
        super.waterFlower() //Flower 클래스의 waterFlower() 메서드 먼저 호출
        println("장미에게 물을 주다")
    }
}

val rose = Rose() //객체 생성
rose.waterFlower() // 물을 주다
                   // 장미에게 물을 주다

//부모 클래스 생성자를 실행시키려면 자식 클래스에서 반드시 부모 클래스의 생성자를
//명시적으로 호출해야함.
open class Flower2 (val name : String) {}
class Rose2(name : String, color : String) : Flower2(name) {}

//접근제한자
private val b = 2

//2.5.4 컴패니언 객체 : companion 키워드
class Dinner {
    companion object{ // object 키워드
        val MENU = "pasta" //정적 변수 생성
        fun eatDinner() { //정적 메서드 생성
            println("저녁은 $MENU")
        }
    }
}

println(Dinner.Companion.MENU) // pasta
println(Dinner.MENU) // pasta Companion 생략 가능
Dinner.eatDinner() // 저녁은 pasta

//2.5.6 추상 클래스
abstract class Game {
    fun startGame() {
        println("게임 시작")
    }

    abstract fun printName()
}

class Overwatch : Game() {
    override fun printName() {
        println("오버워치")
    }
}

val overwatch = Overwatch()
overwatch.startGame() // 게임 시작
overwatch.printName() // 오버워치

//2.5.7 데이터 클래스
data class Memo(val title : String , val content : String, var isDone : Boolean)
var memo1 = Memo("마트 가기", "계란, 우유, 빵", false)
var memo2 = memo1.copy(content = "칫솔, 과자") // content 프로퍼티만 변경

println(memo1.toString())
//Memo(title = 마트 가기, content = 계란, 우유, 빵, isDone = false)

println(memo2.toString())
//Memo(title = 마트 가기, content = 칫솔, 과자, isDone = false)