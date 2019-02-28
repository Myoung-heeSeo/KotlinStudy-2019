


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
	* 각각의 보조생성자에서 사위타입을 super키워드를 이용하여 초기화하거나
	* 다른 생성자에게 상위타입을 초기화할 수 있게 위임해주어야함
```kotlin
class MyView : View {
	constructor() : super(1)
	constructor(ctx: Int) : this()
	constructor(ctx: Int, attrs: Int) : super(ctx, attrs)
}
``` 
- open 어노테이션은 java의 final과 반대임
- open class는 다른 클래스가 상속할 수 있음
- 기본적으로 코틀린의 모든 class는 final
<!--stackedit_data:
eyJoaXN0b3J5IjpbODQ4MDAzOTEwLC0zNTg1MzM5NDYsOTg5Mz
I1MDIwLDIwNTEzOTAzMzMsLTE2NTc1MTg1MjFdfQ==
-->