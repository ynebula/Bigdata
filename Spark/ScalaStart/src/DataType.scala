

object DataType extends App {
  // �Ͻ����� ����
  var x = 10
  var y = "abc"

  // ������� ����
  var b: Byte = 10
  var s: Short = 10
  var i: Int = 10
  var l: Long = 10

  // ���� �� �߰��Ͽ� ����� ����
  var f = 10.0f
  var d = 20.0d

  // �Ͻ����� ����, �����Ϸ��� �ڵ����� Ÿ���� ����
  var ii = 10
  //ii: Int = 10

  var ff = 1.0
  //ff: Double = 1.0
  
  //����
  var t = true
  if (t)
    println("��")
  else
    println("����")
    
  //������
  var c1:Char = 'a'  //c1: Char = a
  var c2 = 'b'  //c2: Char = b
  
  //���ڿ�
  //���ڿ��� ǥ���� �ֵ���ǥ(")�� �̿�
  //��Ƽ���� ���ڿ��� ������ �ֵ���ǥ(""")�� �̿�
  val str1 = "aaa"  //str1: String = aaa  
  
  //���ξ �̿��� ���ڿ� ó��
  //���ξ� s: ���ξ�s�� ${������}�� �̿��Ͽ� ���ڿ����� ������ ������ ġȯ
  // ���ڿ� ġȯ 
  val name = "David"
  println(s"Hello! ${name}")
  
  //���ξ� f: ���ξ�f�� ���ڿ� �������� ó��
  val height:Double = 182.3 
  val name2 = "James"
  println(f"$name2%s is $height%2.2f meters tall")
  
  //���ξ� raw: ���ξ�raw�� Ư�� ���ڸ� ó������ �ʰ� ���� ���ڷ� �ν��մϴ�. Ư�����ڸ� �״�� �Է��ؾ� �� �� ���
  println(s"��\n��")
  println(raw"��\n��")
}