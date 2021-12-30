package rdd

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object RDDInit extends App {
  // SparkContext ��ü �ʱ�ȭ 
  // Ŭ������ �Ŵ����� Ÿ�� ����
  val conf = new SparkConf().setAppName("sample").setMaster("yarn")
  val sc = new SparkContext(conf)
  
  val data = Array(1, 2, 3, 4, 5)
  val distData = sc.parallelize(data)
  //val distData = sc.parallelize(data, 5)  // ��Ƽ�� ���� ���� 
  // ���������� �����ϸ� ��Ŀ��嵵 ������ ��ġ�� ������ �־�� �� 
  //val distFile = sc.textFile("data.txt")
  // s3�� ���ϵ� �������� 
  //val distFile = sc.textFile("s3://your-bucket/data.txt")
  // hdfs�� ���ϵ� �������� 
  //val distFile = sc.textFile("hdfs:///user/data.txt")
  
  // ���ེ ó�� - ��� �� ���ϱ� 
  distData.reduce((a, b) => a + b)
  
  // ���͸� �̿��Ͽ� 4�̻��϶��� ���ϱ� 
  distData.filter(_ >= 4).reduce(_ + _)
}