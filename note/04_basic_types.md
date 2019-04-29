



> Written with [StackEdit](https://stackedit.io/).
# Kotlin Lecture - 4. Basic Types

**기본 타입**
- 코틀린에서 모든 것은 객체(멤버 함수나 property를 호출 가능하기 때문)

**Numbers Type(숫자형)**
- java와 거의 비슷(하지만 java는 primitive type에 직접접근 x)
- 코틀린에서 number는 클래스(=> 맨 앞 알파벳-대문자)
- 코틀린에서 char는 숫자형이 아님(java에서는 숫자형)

**Literal**
- 10진수: 123(Int/Short)
- Long: 123L
- Double: 123.5, 123.5e10
- Float: 123.5f
- 2진수: 0b00001011
- 8진수: 지원안함
- 16진수: 0x0f

**Underscores in numeric literals(v_1.1~)
```kotlin
val oneMillion = 1_000_000
val creditCardNumber = 1234_5678_9012_3456L
val socialSecurityNumber = 999_99_9999L
val hexBytes = 0xFF_EC_DE_5E
val bytes = 0b11010010_01101001_10010100_10010010
```

**Representation**
- java 플랫폼에서 숫자형은 JVM primitive type(기본형)으로 저장
-  nullable이나 제네릭의 경우에는 박싱됨
- 박싱된 경우 identity를 유지하지 않음
```kotlin
// JVM primitive
val a: Int = 100
print(a === a) //Print 'true'

//Boxed
val boxedA: Int? = a
val anotherBoxedA: Int? = a
println("==: ${boxedA == anotherBoxedA}") //Print 'true'
println("===: ${boxedA === anotherBoxedA}") //Print 'true'
//=이 3개일 경우 identity가 같은지 비교
```

**Explicit Conversions**
- 작은 타입은 큰 타입의 하위 타입이 아님 -> 대입 x
```kotlin
val a: Int = 1 //A boxed Int
// val b: Long = a // 오류
val b: Long = a.toLong()
// println(a == b) //오류
```
- 따라서, 명시적으로 변환 필요
```kotlin
val i: Int = b.toInt() //OK
```

**Characters(문자)**
- char은 숫자로 취급 x
```kotlin
fun check(c: Char) {
	if (c == 1) { } //ERROR
}
fun check(c: Char) {
	if (c=='a'){} //OK
}
print('0'.toInt()) //print 48
```

**Array(배열)**
- 배열은 array클래스로 표현됨(java와 많이 다르다)
- get, set ([] 연산자 오버로딩 됨)
- size 등 유용한 멤버함수 포함
```kotlin
var arr: Array<String> = arrayOf("코틀린", "강좌")
println(arr.get(0))
println(arr[0])
println(arr.size)
```
**Array 생성**
- array의 팩토리함수 이용
- arrayOf() 등의 라이브러리 함수 이용
```kotlin
val b= Array(5, {i -> i.toString()})	//0~4까지 원소 i에 대입하여 string 변환 
val a = arrayOf("0", "1", "2", "3", "4")
```
**특별한 Array 클래스**
- Primitive type의 박싱 오버헤드를 없애기 위한 배열
- IntArray, ShortArray
- Array를 상속한 클래스들은 아니지만, method와 property가 Array와 같다.
- size 등 유용한 멤버 함수 포함
```kotlin
val x: IntArray = intArrayOf(1, 2, 3)
x[0] = 7
println(x.get(0))
println(x[0])
println(x.size)
```
**String(문자열)**
- string 클래스로 표현
- characters로 구성
- s[i]와 같은 방식으로 접근 가능(immutable이므로 변경 불가)
```kotlin
var x: String = "Kotlin"
println(x.get(0))
println(x[0])
println(x.length)

for (c in x) {
	println(c)
}
```

**String Literal**
1.  escaped string("Kotlin")
	* 전통적인 방식, java string과 거의 비슷
	* 백슬래쉬로 escaping 처리
2. raw string("""Kotlin""")
	* escaping 처리 필요 x
	* 개행이나 어떠한 문자도 포함 가능
```kotlin
val s = "Hello, World!\n"
val s = """
""이것은 코틀린의 
raw String
입니다.""
"""

<!--stackedit_data:
eyJoaXN0b3J5IjpbNzE4NzU5ODIzXX0=
-->