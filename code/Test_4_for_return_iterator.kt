fun testForReturnIterator() {
    var collection = listOf(1, 2, 3, 4, 5)
    collection.iterator() //iterator 반환 가능한 메서드
    for (item in collection)
        print(item)
    println()

    val array = arrayOf(1, 2, 3, 4, 5)
    array.iterator()  //iterator 반환 가능한 메서드
    for (i in array) {
        println("$i: $array[i]")
    }
}

fun main(){
    testForReturnIterator()
}