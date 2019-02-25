fun testTypeConversion(){
    val a: Int = 1 //A boxed Int
//    val b: Long = a // 오류
//    println(a == b) // 오류
    val b: Long = a.toLong()
    val i : Int = b.toInt()
    println(a == i)
}
fun main() {
    testTypeConversion()
}
