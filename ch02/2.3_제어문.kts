/*
    2.3.1 범위 클래스
*/

val numRange : IntRange = 1..5
println(numRange.contains(3)) // true
println(3 in numRange) // true
println(3 in numRange) // true

val charRange : CharRange = 'a'..'e'
println(charRange.contains('b')) // true
println('c' in charRange) // true

//2.3.2 for문
for(i in 1..5) {
    println(i) // 1,2,3,4,5
}

for(i in 5 downTo 1) {
    println(i) // 5,4,3,2,1
}

for (i in 1..10 step 2) {
    println(i) // 1,3,5,7,9
}

val students = arrayOf("jun-gi", "jun-su", "si-u", "yeon-seo", "ji-hyeon")

for(name in students) {
    println(name) // jun-gi, jun-su, si-u, yeon-seo, ji-hyeon
}

for((index,name) in students.withIndex()) {
    println("${index+1}번째 학생 : $name") // 1번째 학생 : jun-gi, 2번째 학생 : jun-su, 3번째 학생 : si-u, 4번째 학생 : yeon-seo, 5번째 학생 : ji-hyeon
}

//2.3.3 while문
var num1 = 1

while(num1 < 5) {
    println(num1) // 1,2,3,4
    num1++
}

var num2 = 1
do {
    num2++
    println(num2) // 2,3,4,5
} while (num2 < 5)

//2.3.4 if문
val examScore1 = 60
var isPass = false

if(examScore1 > 80) {
    isPass = true
} else {
    isPass = false
}

println("시험 결과 : $isPass") // 시험 결과 : false

val examScore2 = 99
if(examScore2 == 100) {
    println("만점입니다") // 만점입니다
} else {
    println("만점이 아닙니다")
}

val myAge = 40
val isAdult = if(myAge > 20) true else false

println("성인 여부 : $isAdult") // 성인 여부 : true


//2.3.5 when문
val weather = 15
when(weather) {
    -20 -> {println("매우 추운 날씨")}
    11,12,13,14 -> println("선선해요")
    in 15..30 -> println("더워요")

    //범위 안에 안들어가는 경우
    !in -30..50 -> println("잘못된 값입니다.")
    else -> println("정확한 값을 입력해주세요")
}

val essayScore = 80
val grade = when(essayScore) {
    in 90..100 -> "A학점"
    in 80..89 -> "B학점"
    in 70..79 -> "C학점"
    in 60..69 -> "D학점"
    else -> "F학점"
}
println("학점 : $grade") // 학점 : 80