


> Written with [StackEdit](https://stackedit.io/).

# Kotlin Lecture - 5. Control Flow

**If else**
```kotlin
if() {}
else {}
```
- if문이 식으로 사용되는 경우가 있음 
	-> 값을 반환해야 하며, 반드시 else를 동반해야 함
```kotlin
val max = if(a>b) a else b
```
- if식의 braches들이 블록을 가질 수 있음
- 블록 마지막 구문이 return 값이 됨
```kotlin
val max = if(a>b) {
	print("Choose a")
	a
} else {
	print("Choose b")
	b
}
```
- 삼항연산자(ternary)가 없음
	* if문이 삼항연산자 역할을 해내기 때문
```kotlin
val max = if(a>b) a else b
```

**When**
- switch문 역할
- 각각의 branches의 조건문에 만족할 때 까지 위에서 부터 순차적으로 인자를 비교함
```kotlin
when(x) {
	1 -> print("x == 1")
	2 -> print("x == 2")
	else -> {	//Note the block
		print("x is neither 1 nor 2")
	}
}
```
 - when문이 식으로 사용된 경우
	 -> 조건을 만족하는 branch의 값이 전체 식의 결과 값, else문 필수
- else는 다른 branch들의 조건이 만족되지 않을 때 수행
```kotlin
var res = when(x) {
	100 -> "A"
	90 -> "B"
	80 -> "C"
	else -> "F"
}
```
- 컴파일러가 else문이 없어도 된다는 것을 입증할 수 있는 경우엔 else 생략 가능
```kotlin
var res = when (x) {
	true -> "맞다"
	false -> "틀리다"
}
```
- 여러 조건들이 같은 방식으로 처리될 수 있는 경우, branch의 조건문에 콤마(,)를 사용하여 표기
```kotlin
when (x) {
	0, 1 -> print("x == 0 or x == 1")
	else -> print("otherwise")
}
```
- Branch의 조건문에 함수나 식을 사용할 수 있음
```kotlin
when (x) {
	parseInt(x) -> print("s encodes x")
	1 + 3 -> print("4")
	else -> print("s does not encode x")
}
```
- range나 collection에 in이나 !in으로 범위 등을 검사할 수 있음
```kotlin
val validNumbers = listOf(3, 6, 9)
when (x) {
	in validNumbers -> print("x is valid")
	in 1..10 -> print("x is in the range")
	!in 10..20 -> print("x is outside the range")
	else -> print("none of the above")
}
```
- is나 !is를 이용하여 타입 검사 가능
	* 스마트 캐스트 적용
```kotlin
fun hasPrefix(x: Any) = when(x) {
	is Sring -> x.startsWith("prefix")
	else -> false
}
```
- when은 if-else if 체인을 대체할 수 있음
- when에 인자를 입력하지 않으면, 논리연산으로 처리됨
```kotlin
when{	//인자 없음
	x.isOdd() -> print("x is odd")
	x.isEven() -> print("x is even")
	else -> print("x is funny")
}
```

**For Loops**
- for문은 iterator을 제공하는 모든 것을 반복할 수 있음
```kotlin
for (item in collection)	
	print(item)
```

- for문의 body가 블록이 올 수도 있음
```kotlin
for (item in collection) {
	print(item.id)
	print(item.name)
}
```
- 배열이나 리스트를 반복할 때, index를 이용하고 싶다면 indices를 이용하면 됨
```kotlin
val array = arrayOf("가", "나", "다")
for (i in array.indices) {
	println("$i: ${array[i]}")
}
```
- withIndex()로도 index 이용 가능
```kotlin
val array = arrayOf("가", "나", "다")
for ((index, value) in array.withIndex()) {
	println("$index: ${value}")
}
```

**While Loops**
- do-while문에서 body(do)의 지역변수를 조건문(while)이 참조 가능
```kotlin
while () {}
```
```kotlin
do {
	val y = retrieveData()
} while (y != null) //
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbNTEwMDc3Mjg0LDMzMzU1NzgwMywxMDU2OT
czNjU2LDE2MzEyNDI3MDksLTI2NDg5MjU2Myw4NjkyMzAyMTYs
LTE1ODA3MTcxN119
-->