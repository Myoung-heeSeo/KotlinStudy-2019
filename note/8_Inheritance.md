


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
- 명시적으로 상위타입을 선언하려면, 클래스헤더의 콜론(:) 뒤에 상이ㅜ타입 선언
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTEyNDk0NTc4NSwtMTY1NzUxODUyMV19
-->