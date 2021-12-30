
/**
 * 진입점으로 main() 함수를 구현
 * 1. 싱글톤 객체(object)가 main 함수를 구현하는 방법
 * 2. 싱글톤 객체(object)가 App 트레잇을 상속하는 방법
 */

object S01_HelloWorldObject {
  def main(args: Array[String]): Unit = {
    println("Hello World main")
  }
}
/*
object S01_HelloWorld extends App {
  println("Hello World")
}
*/

