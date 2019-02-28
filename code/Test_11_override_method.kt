open class A1(x: Int){  //super
    open fun test(){ }
}

class B1(x: Int): A1(x) {
    override fun test(){ }
}

fun main(){

}