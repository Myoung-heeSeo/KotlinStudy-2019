open class AA(x: Int)

class BB(x: Int) : AA(x)    //BB에 파라미터x를 받고 AA에 파라미터 전달

fun main(){
    BB(3)
}
   