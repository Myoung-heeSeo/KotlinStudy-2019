



> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 3. Basic Syntax


**패키지 정의**
- 패키지 정의는 파일 최상단에 위치
- 디렉토리-패키지 일치 불필요
 ```kotlin
    package my.demo
    import java.util.*
```


**함수 정의**    
- 함수는 fun 키워드로 정의
 ```kotlin
  fun sum(a: Int, b: Int): Int {
     return a + b
  }
  ```    
  - 함수 몸체가 식인 경우 return 생략 가능
  - 이런 경우 return type이 추론됨
 ```kotlin
 fun sum(a: Int, b: Int) = a + b
 ```
 - return할 value가 없는 경우 Unit(Object)으로 return
 - Unit는 Java의 void 같은 역할
 ```kotlin
 fun printKotlin(): Unit{
	 println("hello")
}
```
- Unit은 생략 가능
```kotlin
fun printKotlin(){
	println("hello")
```
**지역 변수 정의**
- val: 읽기전용 변수로 값의 할당이 1회만 가능한 final(java)이나 const(C++)과 유사
```kotlin
val a: Int = 1 //즉시 할당
val b = 2 //'Int' type 추론
val c: Int //컴파일 오류, 초기화가 필요함
c = 3 //컴파일 오류, 읽기전용
```
- var: mutable 변수
```kotlin
var x = 5
x += 1
```
**주석**
- Java와 Javascript와 동일
- //: 한줄
- /* */: 여러 줄 (block comment), 중첩 가능(java와 다르게)

**문자열 템플릿**
- String Interpolation(문자열 보간법)
```kotlin
var a = 1
val s1 = "a is $a"

a = 2
val s2 = "${s1.replace("is", "was")}, but now is $a"
```
**조건문**
```kotlin
fun maxOf(a: Int, b: Int) Int {
	if (a > b) {
		return a
	} else {
		return b
	}
}
```
- 조건식으로 사용 가능
 ```kotlin
fun maxOf(a: Int, b: Int) = if (a > b) a else b
```
**Nullable**
- 값이 null일 수 있는 경우 타입에 nullable 마크를 명시 해야 함
```kotlin
fun parseInt(str: String): Int? {
	// 정수가 아닌 경우 null을 return
}
```
- nullable type의 변수 접근 시, null 체크 필수
- 안하면 컴파일 오류 발생
```kotlin
fun printProduct(arg1: String, arg2: String) {
	var x: Int? = parseInt(arg1)
	var y: Int? = parseInt(arg2)

	if (x != null && y != null) {
		println(x * y)
	} else {
		println("either '$arg1' or '$arg2' is not a number")
	}
}
```
**자동 타입 변환**
- 타입 체크만 해도 자동으로 타입 변환이 됨
```kotlin
fun getStringLength(obj: Any): Int? {
	if (obj is String) {
		// 'obj' 가 자동으로 String 타입으로 변환 됨
		return obj.length
	}
	return null
}
```
**While loop - java랑 거의 비슷**
```kotlin
while() {}
```
**When expression**
- switch-case같은 기능
```kotlin
fun describe(obj: Any): String = 
	when (obj) {
		1 -> "One" 
		"Hello" -> "Greeting"
		is Long -> "Long"
		!is String -> "Not a string"
		else -> "Unknown"
```
**Ranges**
- In 연산자를 이요해 숫자 범위 체크 가능
```kotlin
val x = 3
if (x in 1..10) {
	println("fits in range")
}
```
- range를 이용한 for loop
 ```kotlin
for (x in 1..5) {
	print(x)
}
```
**collections**
- 컬렉션도 in으로 loop가능
 ```kotlin
val items = listOf("apple", "banana", "kiwi")
for (item in items) {
	println(item)
}
```
- in으로 해당 값이 collection에 포함되는지 체크 가능
```kotlin
val items = setOf("apple", "banana", "kiwi")
when {
	"orange" in items -> println("juicy")
	"apple" in items -> println("apple is fine too")
}
```
- lambda expression을 이용하여 컬렉션에 filter, map 등의 연산 가능
```kotlin
val fruits = listOb("banana", "avocado", "apple", "kiwi")
fruits
	.filter { it.startsWith("a") }
	.sortedBy { it }
	.map { it.toUpperCase() }
	.forEach { println(it) }
```





<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM3MTA4Nzg0OV19
-->