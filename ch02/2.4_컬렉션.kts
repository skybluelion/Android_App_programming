
//2.4.1 리스트List
// 읽기전용 listOf()
val numImmutableList = listOf(1,2,3)
//numList[0] = 1 // error

val numMutableList = mutableListOf(1,2,3)
numMutableList[0] = 100 // ok

println(numImmutableList) // [1, 2, 3]
println(numMutableList) // [100, 2, 3]
println(numMutableList[0]) // 100

println(numMutableList.contains(1)) // false
println(numMutableList.contains(100)) // true

//2.4.2 셋 set
// 읽기전용 setOf()
val numImmutableSet = setOf(1,2,3,3,3)
println(numImmutableSet) // [1, 2, 3]

// 읽기쓰기 setOf()
val numMutableSet = mutableSetOf(1,2,3,3,3)
numMutableSet.add(100)
numMutableSet.remove(1)
numMutableSet.remove(200) // false

println(numMutableSet) // [2, 3, 100]
println(numMutableSet.contains(1)) // false

//2.4.3 맵 map
// 읽기전용 mapOf()
val immutableMap = mapOf("name" to "jinsu", "age" to 25, "age" to 27, "height" to 180)
println(immutableMap) // {name=jinsu, age=27, height=180}

// 읽기쓰기 mapOf()
val mutableMap = mutableMapOf("돈까스" to "일식", "짜장면" to "중식", "김치찌개" to "중식")
mutableMap.put("된장찌개", "한식")
mutableMap.remove("돈까스")
mutableMap.replace("김치찌개", "한식")
println(mutableMap) // {짜장면=중식, 된장찌개=한식, 김치찌개=한식}