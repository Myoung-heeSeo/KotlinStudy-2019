


> Written with [StackEdit](https://stackedit.io/).

# Kotlin Lecture - 6. Packages, Return, and Jumps

**Package(패키지)**
- 소스 파일은 패키지 선언으로 시작
- 모든 콘텐츠(클래스, 함수, ...)는 패키지에 포함
- 패키지를 명시하지 않으면 이름 없는 기본 패키지에 포함(import 안해도 함수 접근 가능)
```kotlin
package foo.bar

fun baz(){}

class Goo(){}

fun main(args: Array<String>) {
	foo.bar.baz()
	foo.bar.Goo()
}
```

**기본 패키지**
- 기본으로 import되는 패키지가 있음(플랫폼 별로 다름)
```kotlin
kotlin.*
kotlin.annotation.*
kotlin.collections.*
kotlin.comparison.*
kotlin.io.*
kotlin.ranges.*
kotlin.sequences.*
kotlin.text.*
```
- 충돌되는 패키지 내 함수를 import 경우, 'as'로 로컬 리네임 가능
```kotlin
//foo.Bar
//bar.Bar
import bar.Bar as bBar
```


<!--stackedit_data:
eyJoaXN0b3J5IjpbLTEzNDQzMjc5NTAsLTEyNTE3NzIwMjMsLT
E0Nzk5MzYwNywtMTkyNTk4NjYwMF19
-->