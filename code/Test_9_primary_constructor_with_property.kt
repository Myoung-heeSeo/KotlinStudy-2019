fun main(){
//    val obj = Customer2()
//    obj.fullname = "Kotlin"
    val obj = Customer2("Kotlin")
    obj.fullname = "test"
    println(obj.fullname)
}

class Customer2(var fullname: String) {
//    var fullname: String = ""
//    get() { return field }
//    set(value) { field = value }
}