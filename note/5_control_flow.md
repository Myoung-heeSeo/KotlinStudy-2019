


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

**when**
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


<!--stackedit_data:
eyJoaXN0b3J5IjpbMTQyMjQ5MTU5OCw4NjkyMzAyMTYsLTE1OD
A3MTcxN119
-->