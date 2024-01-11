import java.time.*
import java.util.*

/*
fun 함수명 (매개변수) : 반환 자료형 {
    //실행할 코드 내용
}
 */


fun myMain1() {
    fun printAge(age : Int) : Unit {
        println(age)
    }
    printAge(15)
}
myMain1()

fun myMain2() {
    fun printAge(age: Int) {
        println(age)
    }
    printAge(15)
}
myMain2()

fun addNum(a : Int, b : Int) : Int {
    return a + b
}
println(addNum( 200, 400)) // 600

fun addNum2(a : Int, b : Int) = a + b
println(addNum2( 300, 500)) // 800

fun minusNum(a : Int, b : Int) = a - b
println(minusNum(minusNum( 1000, 200) , 100)) // 700



// Calendar 클래스를 이용해 나이 계산
fun calculateAge(birthDate: Calendar): Int {
    val currentDate = Calendar.getInstance()
    var age = currentDate.get(Calendar.YEAR) - birthDate.get(Calendar.YEAR)
    // 생일이 지나지 않았을 경우 나이 1살 감소
    if (birthDate.get(Calendar.DAY_OF_YEAR) > currentDate.get(Calendar.DAY_OF_YEAR)) {
        age--
    }
    return age
}

fun todaysAge() : Unit{
    val year = 1993 // 4자리의 연도로 지정
    val month = 7
    val day = 8
// 생일을 Calendar 클래스를 사용하여 설정
    val birthDate = Calendar.getInstance()
    birthDate.set(year, month - 1, day)
// 오늘의 나이 계산
    println("오늘의 나이는 ${calculateAge(birthDate)} 살입니다.")
}
todaysAge()

// LocalDate와 Period를 이용한 나이 계산
fun todaysAge2() : Unit {
    val birthDate = LocalDate.of(1993, 7-1, 8)
    println("오늘의 나이는 ${Period.between(birthDate, LocalDate.now()).years}살입니다.")
}
todaysAge2()
