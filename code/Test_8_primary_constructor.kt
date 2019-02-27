fun main(){
    val obj = Customer("Myounghee") //name 지정해주지 않으면 에러
    println(obj)
}

class Customer(name: String){
    init{
        println("이름: ${name}")
    }
}
