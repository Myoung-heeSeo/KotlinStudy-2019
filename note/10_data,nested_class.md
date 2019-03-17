


> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 10. Data, Nested classes

**Data 클래스**
- 용도 : 데이터는 보유하지만 아무것도 하지 않는 클래스
- 코틀린에서는 data class 제공
- 클래스 앞에 data 붙이면 됨
```kotlin
data class User(val name: String, val age: Int)
```
- data클래스는 기본 생성자(만)에서 선언된 속성을 통해, 아래의 기능들을 컴파일러가 자동으로 생성해 줌
	* equals()
	* hashCode()
	* copy()
	* toString() of the form "User(name=John, age=42)"
	* componentN() functions
- 명시적으로 정의해주는 경우에는, 컴파일러가 자동으로 생성해주지 않음

**의미있는 Data 클래스의 조건**
- 기본생성자에 1개 이상의 파라미터
- 기본생성자의 파라미터가 var, val로 선언
- Data 클래스는 abstract, open, sealed, inner가 안됨

**1.1이후에 바뀐 점**
- Data클래스 interface 구현 가능
- Sealed class 상속 가능

**기본 값**
- Jvm에서 파라미터 없는 생성자가 필요한 경우, 모든 프로퍼티에 기본값을 설정해 주면 됨
```kotlin
data class Unser(val name: String = "", val age: Int = 0)
```
```kotlin
val exam_0 = User()
val exam_1 = User("Kotlin")
val exam_2 = User("Kotlin", 113)
val exam_3 = User(age=113)
val exam_4 = User(name="Kotlin", age=113)
```

**복사**
- 객체의 기존 값들은 유지하고, 일부 값만 고쳐서 새로운 객체를 만들고 싶은 경우
- Data 클래스에 컴파일러가 copy를 만들어주기 때문에(copy 함수) 바로 copy를 호출해서 쓰면 됨
```kotlin

`
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTQ3OTU1NTU1MCwtMTI2NTgxMjMzM119
-->