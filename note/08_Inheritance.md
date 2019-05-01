


> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 8. Inheritance

**Inheritance(상속)**
- 코틀린의 최상위 클래스는 Any
- 클래스에 상위타입을 선언하지 않으면 Any가 상속
```kotlin
class Example1 //암시적인 Any 상속
class Example2 : Any() //명시적인 Any 상속
```

- Any는 java.lang.Object와는 다른 클래스임
	* equals(), hashCode(), toString()만 있음

```kotlin
package kotlin
public open class Any {
	public open operator fun equals(other: Any?): Boolean
	public open fun hashCode(): Int
	public open fun toString(): String
}
```
- 명시적으로 상위타입을 선언하려면, 클래스헤더의 콜론(:) 뒤에 상위타입 선언
- 파생클래스에 기본생성자가 있으면, 파생클래스의 기본생성자에서 상위타입의 생성자를 호출해서 초기화할 수 있음
```kotlin
open class Base(p: Int)

class Derived(p: Int) : Base(p)
```
- 파생클래스에 기본생성자가 없으면 	
	* 각각의 보조생성자에서 상위타입을 super키워드를 이용하여 초기화하거나
	* 다른 생성자에게 상위타입을 초기화할 수 있게 위임해주어야함
```kotlin
class MyView : View {
	constructor() : super(1)
	constructor(ctx: Int) : this()
	constructor(ctx: Int, attrs: Int) : super(ctx, attrs)
}
``` 
- open 어노테이션은 java의 final과 반대
- open class란 다른 클래스가 상속가능함을 암시
- 기본적으로 코틀린의 모든 class는 final
**Method Overriding(메소드 오버라이딩)**
- 오버라이딩 될 메소드(슈퍼)
	* open 어노테이션 요구됨
- 오버라이딩 된 메소드(하위)
	* override 어노테이션 요구됨
```kotlin
open class Base {
	open fun v() {}
	fun nv() {}
}

class Derived() : Base() {
	override fun v() {}
}
```

**Property Overriding(프로퍼티 오버라이딩)**
- 메소드 오버라이딩과 유사
```kotlin
open class Foo{
	open val x: Int get{}
}

class Bar1: Foo() {
	override val x: Int = ...
}
```
**오버라이딩 규칙**
- 같은 멤버에 대한 중복된 구현을 상속받은 경우, 상속받은 클래스는 해당 멤버를 오버라이딩하고 자체 구현을 제공해야 함
- "super + 클래스명"을 통해 상위 클래스 호출 가능
```kotlin
open class A{
	open fun f() { print("A"} }
	fun a() { print("a") }
}
```
```kotlin
interface B{
	fun f() { print("B") }
	fun b() { print("b")}
}
```
```kotlin
class C() : A(), B{
	override fun f() {
		super<A>.f() // call to A.f()
		super<B>.f() // call to B.f()
	}
}
```
**Abstract Class(추상 클래스)**
- abstract 멤버는 구현이 없음
- abstract 클래스나 멤버는 open이 필요 없음(당연히 open이 기본적으로 적용된 클래스이기 때문)
```kotlin
abstract class AbClass{
	abstract fun f()
}

class MyClass(): AbClass(){
	override fun f() {//구현}
}
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTQ3ODM0MzYxNiwtMTgzMzA3OTUwOV19
-->