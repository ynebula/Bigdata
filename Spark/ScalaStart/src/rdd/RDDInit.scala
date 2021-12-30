package rdd

import org.apache.spark.SparkContext
import org.apache.spark.SparkConf

object RDDInit extends App {
  // SparkContext 객체 초기화 
  // 클러스터 매니저의 타입 지정
  val conf = new SparkConf().setAppName("sample").setMaster("yarn")
  val sc = new SparkContext(conf)
  
  val data = Array(1, 2, 3, 4, 5)
  val distData = sc.parallelize(data)
  //val distData = sc.parallelize(data, 5)  // 파티션 개수 지정 
  // 로컬파일을 지정하면 워커노드도 동일한 위치에 파일이 있어야 함 
  //val distFile = sc.textFile("data.txt")
  // s3의 파일도 지정가능 
  //val distFile = sc.textFile("s3://your-bucket/data.txt")
  // hdfs의 파일도 지정가능 
  //val distFile = sc.textFile("hdfs:///user/data.txt")
  
  // 리듀스 처리 - 모든 수 더하기 
  distData.reduce((a, b) => a + b)
  
  // 필터를 이용하여 4이상일때만 더하기 
  distData.filter(_ >= 4).reduce(_ + _)
}