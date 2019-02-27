


> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 7. Class

**Class(클래스)**
- class 키워드로 선언
- 클래스 이름/헤더(형식 매개변수, 기본 생성자 등)/바디({})로 구성

```kotlin
class Invoice(data: Int){
}
```
- 헤더와 바디는 옵션 -> 중괄호도 생략가능
``` kotlin
class Invoice
```

**기본생성자**
- 클래스 별로 1개만 가능
- 클래스 헤더의 일부
- 클래스 이름 뒤에 작성
```kotlin
class Person constructor(firstName: String){
}
```
- 어노테이션이나 접근지정자가 없을 때는, 기본생성자의 constructor 키워드를 생략 가능
```kotlin
class Person(firstName: String) {
}
```
- 기본생성자는 코드를 가질 수 없다(바디가 겹치기 때문)
	* 초기화는 초기화(init 키워드) 블록 안에서 작성해야함
	* 기본 생성자의 파라미터는 init블록 안에서 사용 가능
```kotlin
class Customer(name: String){
	init {
		logger.info("Customer initialized with value ${name}")
	}
}
```
- 기본생성자의 파라미터는 프로퍼티 초기화 선언에도 사용 가능
```kotlin
class Customer(name: String) {
	val customerKey = name.toUpperCase()
}
```
- 프로퍼티 선언 및 초기화는 기본생성자에서 간결한 구문으로 사
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE1NjE2Mjc0MjksLTEyMzIzODA4MDIsNz
kyMzI2NDk0XX0=
-->