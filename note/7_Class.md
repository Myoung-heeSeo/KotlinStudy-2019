


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

**Primary Constructor(기본생성자)**
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
- 프로퍼티 선언 및 초기화는 기본생성자에서 간결한 구문으로 사용 가능
```kotlin
class Person(val firstName: String, val lastName: String){
}
```
- 기본생성자에 어노테이션 접근지정자 등이 있는 경우 constuctor 키워드 필요(생략 x)
```kotlin
class Customer public @Inject constructor(name: String) {}
```
 
 **Secondary Constructor(보조생성자)**
 - 클래스 별로 여러개를 가질 수 있음
 - constructor 키워드로 선언(바디에 선언)
 ```kotlin
class Person{
	constructor(parent: Person) {
		parent.children.add(this)
	}
}
```
- 클래스가 기본 생성자를 가지고 있다면, 각각의 보조 생성자들은 기본 생성자를 직접/간접적으로 위임해 주어야 함
- this 키워드 사용
	* 직접적: 기본 생성자에 위임
	* 간접적: 다른 보조 생성자에 위임
```kotlin
class Person(val name: String) {
	//기본 생성자에 직접 위임
	constructor(name: String, parent: Person) : this(name) {} 
	//보조생성자를 this를 통해 호출하여 간접적으로 기본 생성자 위임
	constructor() : this("Myounghee Seo", Person()) {}	
}
```
**Generated Primary Constructor(생성된 기본생성자)**
- 클래스에 기본 생성자 or 보조 생성자를 선언하지 않으면, 생성된 기본 생성자가 만들어짐
- 매개 변수가 없음
- 가시성이 public
- 만약 생성된 기본생성자를 public이 아닌 접근지정자로 하고 싶다면, 접근지정자를 지정한 기본생성자를 선언해야 함
```kotlin
class DonCreateMe private constructor () {}
```

**인스턴스(객체) 생성**
- 코틀린에는 new 키워드가 없음
- 객체 생성 시 생성자를 일반 함수 처럼 호출하면 됨
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTkyODkzNzI3NSwtODUxMjg2NjYyLC0xMj
MyMzgwODAyLDc5MjMyNjQ5NF19
-->