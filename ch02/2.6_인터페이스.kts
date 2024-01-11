//2.6.1 인터페이스 정의
interface Car1{
    abstract fun drive()
    fun stop() //abstract 키워드 생략 가능
}

//2.6.2 디폴트 메서드
interface Car2{
    abstract fun drive()
    fun stop()
    fun destroy() = println("차량 파괴") //디폴트 메서드
}

//2.6.3 인터페이스의 구현

class Ferrari : Car2 {
    override fun drive() {
        println("Ferrari 주행")
    }

    override fun stop() {
        println("Ferrari 정지")
    }
}

val myFerrari = Ferrari() //객체 생성
myFerrari.drive() //Ferrari 주행
myFerrari.stop() //Ferrari 정지
myFerrari.destroy() //차량 파괴

//2.6.4 다중 인터페이스 구현 2.6.5 상속과 구현
interface Animal {
    fun breath()
    fun eat()
}

interface Human {
    fun think()
}

open class Name(val name : String){
    fun printName() {
        println("이름은 $name 입니다")
    }
}

class Korean(name : String) : Name(name), Animal, Human { // 부모 클래스 생성자에 필요한 인수 전달
    override fun breath() {
        println("숨쉬기")
    }

    override fun eat() {
        println("먹기")
    }

    override fun think() {
        println("생각하기")
    }
}

val jun = Korean("준") //객체 생성
jun.printName() //이름은 준 입니다
jun.breath() //숨쉬기
jun.eat() //먹기
jun.think() //생각하기