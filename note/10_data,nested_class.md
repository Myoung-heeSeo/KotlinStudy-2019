


> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 10. Data, Nested classes

**Data 클래스**
- 용도 : 데이터는 보유하지만 아무것도 하지 않는 클래스
- 코틀린에서는 data class 제공
- 클래스 앞에 data 붙이면 됨
```kotlin
data class User(val name: String, val age: Int)
```
- data클래스는 기본 생성자에서 선언된 속성을 통해, 아래의 기능
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTExNTUyMTc3MjZdfQ==
-->