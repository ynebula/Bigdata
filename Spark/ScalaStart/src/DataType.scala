

object DataType extends App {
  // 암시적인 선언
  var x = 10
  var y = "abc"

  // 명시적인 선언
  var b: Byte = 10
  var s: Short = 10
  var i: Int = 10
  var l: Long = 10

  // 값에 약어를 추가하여 명시적 선언
  var f = 10.0f
  var d = 20.0d

  // 암시적인 선언, 컴파일러가 자동으로 타입을 선택
  var ii = 10
  //ii: Int = 10

  var ff = 1.0
  //ff: Double = 1.0
  
  //논리형
  var t = true
  if (t)
    println("참")
  else
    println("거짓")
    
  //문자형
  var c1:Char = 'a'  //c1: Char = a
  var c2 = 'b'  //c2: Char = b
  
  //문자열
  //문자열의 표현은 쌍따옴표(")를 이용
  //멀티라인 문자열은 세개의 쌍따옴표(""")를 이용
  val str1 = "aaa"  //str1: String = aaa  
  
  //접두어를 이용한 문자열 처리
  //접두어 s: 접두어s는 ${변수명}을 이용하여 문자열안의 변수를 값으로 치환
  // 문자열 치환 
  val name = "David"
  println(s"Hello! ${name}")
  
  //접두어 f: 접두어f는 문자열 포맷팅을 처리
  val height:Double = 182.3 
  val name2 = "James"
  println(f"$name2%s is $height%2.2f meters tall")
  
  //접두어 raw: 접두어raw은 특수 문자를 처리하지 않고 원본 문자로 인식합니다. 특수문자를 그대로 입력해야 할 때 사용
  println(s"가\n나")
  println(raw"가\n나")
}