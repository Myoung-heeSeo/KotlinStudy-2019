fun testForMyIterator() {
    val myData = MyData()
    myData.iterator()
    for (item in myData){
        print(item)
    }
}

class MyIterator{
    val data = listOf(1, 2, 3, 4, 5)
    var idx = 0
    operator fun hasNext(): Boolean {
        return data.size > idx
    }

    operator fun next (): Int {
        return data[idx++]
    }
}

class MyData{
    operator fun iterator(): MyIterator {
        return MyIterator()
    }
}

fun main(){
    testForMyIterator()
}