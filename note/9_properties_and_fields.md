


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
- 코틀린 1.1부터는 getter를 통해 타입을 추론할 수 있는 경우 프로퍼티 타입 생략 가능
```kotlin
val isEmpty: Boolean
	get() = this.size == 0 //has type Boolean
```
```kotlin
val isEmpty	//v_1.1~
	get() = this.size == 0 //has type Boolean
```

**프로퍼티**
- accessor에 가시성 변경이 필요하거나 어노테이션이 필요한 경우
- 기본 accessor의 수정 없이 body없는 accessor를 통해 정의 가능
```kotlin
var setterVisibility: String = "abc"
	private set
var setterWithAnnotation: Any? = null
	@inject set //annotate the setter with Inject
```
- Body를 작성해 주어도 됨
```kotlin
var setterVisibility: String = "abc"
	private set(value) {
		field = value
	}
```

**Backing Fields**
- 코틀린 클래스는 field를 가질 수 없음
- 'field'라는 식별자를 통해 접근할 수 있는, automatic backing field를 제공함
- field는 프로퍼티의 accessor에서만 사용가능 함
```kotlin
//the initializer value is written directly
//to the backing field
var counter = 0
	set(value) {
		if (value >= 0 ) field = value
	}
```

**Backing Fields 생성 조건**
- accessor중 1개라도 기본 구현을 사용하는 경우
- custom accessor에서 field 식별자를 참조하는 경우
```kotlin
//the initializer value is written directly to the backing field
var counter = 0
	set(value) {
		if(value > = 0 ) field = value
	}
```
- Backing field를 생성하지 않는 경우
```kotlin
val isEmpty: Boolean
	get() = this.size == 0
```
**Backing Properties**
- "implicit backing field" 방식이 맞지 않는 경우에는 "backing property"를 이용할 수도 있다.
```kotlin
private var _table: Map<String, Int>? = null
public val table: Map<String, Int>
	get() {
		if (_table == null) {
			_table = HashMap()
		}
		return _table ?: throw AssertionError("null ")
	}
```
**Compile-Time Constants**
- const modifier를 이용하면 컴파일 타임 상수를 만들 수 있음
	* 이런 프로퍼티는 어노테이션에서도 사용 가능
- 조건
	* Top-level 이거나(class안에 들어가면 x)
	* object의 멤버이거나
	* String이나 프리미티브 타입으로 초기화된 경우
```kotlin
const val SUBSYSTEM_DEPRECATED : String = "This subsystem is deprecated"

@Deprecated(SUBSYSTEM_DEPRECATED)
fun foo() {}
```

**Late-Initialized Properties**
- 일반적으로 프로퍼티는 non-null타입으로 선언됨
- 간혹 non-null타입 프로퍼티를 사용하고 싶지만, 생성자에서 초기화를 해줄 수 없는 경우가 있음
	* Dependency injection
	* Butter knife
	* Unit test의 setup 메소드
```kotlin
public class MyTest{
	lateinit var subject: TestSubject

	@SetUp fun setup() {
		subject = TestSubject()
	}

	@Test fun test() {
		subject.method() // dereference directly
	}
}
```
- 객체가 constructor에서는 할당되지 못하지만 여전히 non-null타입으로 사용하고 싶은 경
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTA2Mzc0MzQ0Nyw5MDI0MTQxODQsLTE3ND
YwODczODksMzg1MDc1NTc2LDc4ODQ1MjAyNCwtMTI1MDg1MTEx
OSwtNzEyNjQ0OTMsLTM4NjU5NjQyNSwtNjY3NjQ0OTM2LDE3MT
Y2NzM1MiwxOTkxMTEyMzM2LDE1NTg3ODAwODcsLTczODE3MDc1
Miw5MjkyODY3MjQsOTYwMjUyNTk1XX0=
-->