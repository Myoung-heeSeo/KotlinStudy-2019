fun foo(){
    var ints = listOf(0, 1, 2, 3)
    ints.forEach(
        fun(value: Int){
            if (value == 1) return  //함수 중첩에서는 해당 함수가 종료
            print(value)    //023
        }
    )
    println("End")
}

fun foo2() {
    var ints = listOf(0, 1, 2, 3)
    ints.forEach(
        {
            if (it == 1) return //lambda는 함수가 아니므로 return하면 가장 가까운 함수가 종료
            print(it)   //0
        }
    )
    println("End")
}


fun foo3() {
    var ints = listOf(0, 1, 2, 3)
    ints.forEach label@{
        if (it == 1) return@label
        print(it)   //023
    }
    println("End")

}

fun foo4() {
    var ints = listOf(0, 1, 2, 3)
    ints.forEach(
        {
            if (it == 1) return@forEach //암시적 레이블 : lambda가 사용된 함수의 이름을 label로 써준다
            print(it)   //
        }
    )
    println("End")
}


fun main(){
    foo()
    foo2()
    foo3()
    foo4()
}
