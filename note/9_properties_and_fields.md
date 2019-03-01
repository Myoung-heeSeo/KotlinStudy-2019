


> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 9. Properties and Fields

**프로퍼티 선언**
- 코틀린 클래스는 프로퍼티를 가질 수 있음
	* var : mutable / val : read-only
```kotlin
class Address{
	var name: String = "Kotlin"
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
	* property
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTMyMTQ0ODU0LDk2MDI1MjU5NV19
-->