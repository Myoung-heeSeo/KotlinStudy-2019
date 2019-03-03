


> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 9. Properties and Fields

**프로퍼티 선언**
- 코틀린 클래스는 프로퍼티를 가질 수 있음
	* var : mutable / val : read-only
```kotlin
class Address{
	var name: String = "Kotlin"	//property
	val city: String = "Seoul"
}
```
- 프로퍼티 사용은 자바의 필드를 사용하듯이 하면 됨
```kotlin
fun copyAddress(address: Address): Address{
	val result = Address()
	result.name = address.name
	// ...
	return result
}
```
**프로퍼티 문법**
- 전체 문법
```kotlin
var <propertyName>[: <PropertyType>][=<property_initializer>]
	[<getter>]
	[<setter>]
```
- 옵션 (생략가능)
	* PropertyType
		- property_initalizer에서 타입이 추론 가능한 경우 생략 가능
	* property_initializer
	* getter
	* setter
**프로퍼티 예제**
- 두코드는 거의 같음
```kotlin
class Address{
	var name="Kotlin"
}
```
```kotlin
class Address2 {
	var name: String = "Kotlin"
	//get과 set 재정의
		get() {
			return field
		}
		set(value) {
			field = value
		}
}
```
**var (mutable) 프로퍼티**
```kotlin
class Address {
	//default getter와 setter
	//타입은 Int
	var initialized = 1

	//error: default getter와 setter를 사용한 경우
	명시적인 초기화가 필요하기 때문에 에러 발생
	var allByDefault: Int?
```
**val(read-only) 프로퍼티**
- setter가 없음
```kotlin
class Address{
	//default getter
	//타입은 Int
	val initialized = 1

	//error: default getter를 사용한 경우
	//명시적인 초기화가 필요하므로 에러 발생
	val allByDefault: Int?
```
**Custom accessors(getter, setter)**
- getter와 setter를 재정의하는 것
- 프로퍼티 선언 내부에 일반 함수처럼 선언
- getter
```kotlin
val isEmpty: Boolean
	get() = this.size == 0
```
- setter
	* 관습적으로 setter의 파라미터 이름은 value임(변경 가능)
```kotlin
var stringRepresentation: String
	get() = this.toString()
	set(value) {
		setDataFromString(value)
	}
```
**타입생략**
- 코틀린 1.1부터
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTM0MTQzMTQ3NCwtNzM4MTcwNzUyLDkyOT
I4NjcyNCw5NjAyNTI1OTVdfQ==
-->