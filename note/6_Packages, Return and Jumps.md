


> Written with [StackEdit](https://stackedit.io/).

# Kotlin Lecture - 6. Packages, Return, and Jumps

**Package(패키지)**
- 소스 파일은 패키지 선언으로 시작
- 모든 콘텐츠(클래스, 함수, ...)는 패키지에 포함
- 패키지를 명시하지 않으면 이름 없는 default 패키지에 포함(import 안해도 함수 접근 가능)
```kotlin
package foo.bar

fun baz(){}

class Goo(){}

fun main(args: Array<String>) {
	foo.bar.baz()
	foo.bar.Goo()
}
```
<!--stackedit_data:
eyJoaXN0b3J5IjpbLTE0Nzk5MzYwNywtMTkyNTk4NjYwMF19
-->