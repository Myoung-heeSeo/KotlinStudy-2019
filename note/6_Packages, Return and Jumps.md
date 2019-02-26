


> Written with [StackEdit](https://stackedit.io/).

# Kotlin Lecture - 6. Packages, Return, and Jumps

**Package(패키지)**
- 소스 파일은 패키지 선언으로 시작
- 모든 콘텐츠(클래스, 함수, ...)는 패키지에 포함
- 패키지를 명시하지 않으면 이름 없는 기본 패키지에 포함(import 안해도 함수 접근 가능)
```kotlin
package foo.bar

fun baz(){}

class Goo(){}

fun main(args: Array<String>) {
	foo.bar.baz()
	foo.bar.Goo()
}
```

**기본 패키지**
- 기본으로 import되는 패키지가 있음(플랫폼 별로 다름)
```kotlin
kotlin.*
kotlin.annotation.*
kotlin.collections.*
kotlin.comparison.*
kotlin.io.*
kotlin.ranges.*
kotlin.sequences.*
kotlin.text.*
```
- 충돌되는 패키지 내 함수를 import 경우, 'as'로 로컬 리네임 가능
```kotlin
//foo.Bar
//bar.Bar
import bar.Bar as bBar
```

**Label로 Break and Continue**
- 식별자 + @ 형태로 사용(label@)
```kotlin
loop@ for (i in 1..10) {
	println("--- i: $i ---")

	for (j in 1..10) {
		pritnln("j: $j")
		if (i + j > 12) {
			break @loop
		}
	}
}
```
```kotlin
loop@ for (i in 1..10) {
	println("--- i: $i ---")
	for (j in 1..10) {
		if (j < 2) {
			continue@loop
		}
		println("j: $j")
	}
}
```

**Label로 Return**
- 코틀린에서 중첩 될 수 있는 요소들
	* 함수 리터럴
	* 지역함수
	* 객체 표현식
	* 함수
```kotlin
fun foo() {
	var ints = listOf(0, 1, 2, 3)
	ints.forEach(fun(value: Int){
		if(value == 1) return
		print(value)
	})
	print("End")
}
```
**Lambda 식에서 return 시 주의사항**
- 람다식에서 return 시 nearest enclosing 함수가 return
- 람다식에 대해서만 return 하려면 label을 이용
```kotlin
fun foo() {
	var ints = listOf(0, 1, 2, 3)
	ints.forEach {
		if (it == 1) return
		print(it)
	}
	print("End")
}
```
```kotlin
fun foo3() {
	var ints = listOf(0, 1, 2, 3)
	ints.forEach label@ {
		if(it == 1) return@label
		print(it)
	}
	print("End")
}
```
**암시적 레이블(람다에 라벨 쓰기 귀찮을 때)**
- 직접 label을 사용하는 것 보다 편리
- 암시적 레이블은 람다가 사용된 함수의 이름과 동일함
```kotlin
fun foo4(
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTcwMTQ2MjIxOCwyNTkwOTU2OTgsLTE2Mz
k2NTY3NzgsLTEyNTE3NzIwMjMsLTE0Nzk5MzYwNywtMTkyNTk4
NjYwMF19
-->