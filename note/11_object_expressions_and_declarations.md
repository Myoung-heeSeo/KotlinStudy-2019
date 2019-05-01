


> Written with [StackEdit](https://stackedit.io/).

# Kotlin Lecture - 11. Object Expressions and Declarations

**object 용도**
- class에서 약간 변경된 객체를 생성할 때 (상속 x)
- 새로운 subclass의 명시적인 선언 없이 객체 생성
1. Object Expressions
	- java 익명 객체
2. Object Declarations
	- 싱글턴
3. Companion Object(kotlin은 static이 없음)
	- 싱글턴 + class method (static)

**object expressions**
- 객체 표현식 상속
	- 슈퍼타입의 생성자가 있는 경우, 반드시 값을 전달 해 주어야함
	- 슈퍼타입이 여러개인 경우 ':'콜론 뒤에, ',' 콤마로 구분해서 명시해주면 됨
	- 
<!--stackedit_data:
eyJoaXN0b3J5IjpbNTE4OTA5MjksMTk4NDQ0ODA1Ml19
-->