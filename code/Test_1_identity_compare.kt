fun testIdentityCompare() {
    // java플랫폼에서 숫자형은 JVM primitive type으로 저장됨
    // Nullable이나 제네릭의 경우엔 박싱됨
    // 박싱된 경우 identity를 유지하지 않음
    var a: Int = 10000
    var b: Int? = 10000
    println("a === b: ${a === b}")
    println("a == b: ${a == b}")
}

fun main(){
    testIdentityCompare()
}
