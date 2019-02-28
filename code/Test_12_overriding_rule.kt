open class A2() {
    open fun f() {
        println("AAAAA")
    }
}

interface B2 {
    fun f() {
        println("BBBBB")
    }
}

class C2 : A2(), B2 {
    override fun f() {  //A2의 f함수 override
        println("1")
        super<A2>.f()
        println("2")
        super<B2>.f()
        println("3")
    }
}

fun main(){
    val obj = C2()
    obj.f()
}
