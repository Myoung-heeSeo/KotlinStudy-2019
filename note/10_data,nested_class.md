


> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 10. Data, Nested classes

**Data 클래스**
- 용도 : 데이터는 보유하지만 아무것도 하지 않는 클래스
- 코틀린에서는 data class 제공
- 클래스 앞에 data 붙이면 됨
```kotlin
data class User(val name: String, val age: Int)
```
- data클래스는 기본 생성자에서 선언된 속성을 통해(만), 아래의 기능들을 컴파일러가 자동으로 생성해 줌
	* equals()
	* hashCode()
	* copy()
	* toString() of the form "User(name=John, age=42)"
	* componentN() functions
- 명시적으로 정의해주는 경우에는, 컴파일러가 자동으로 생성해주지 않음
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTc3MTM5MjgxXX0=
-->