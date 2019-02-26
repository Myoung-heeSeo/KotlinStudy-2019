


> Written with [StackEdit](https://stackedit.io/).

# Kotlin Lecture - 5. Control Flow

**If else**
```kotlin
if() {}
else {}
```
- if문이 식으로 사용되는 경우가 있음 
	-> 값을 반환해야 하며, 반드시 else를 동반해야 함
```kotlin
val max = if(a>b) a else b
```
- if식의 braches들이 블록을 가질 수 있음
- 블록 마지막 구문이 return 값이 됨
```kotlin
val max = if(a>b) {
	print("Choose a")
	a

```

<!--stackedit_data:
eyJoaXN0b3J5IjpbLTk2ODE3NTcxMCwtMTU4MDcxNzE3XX0=
-->