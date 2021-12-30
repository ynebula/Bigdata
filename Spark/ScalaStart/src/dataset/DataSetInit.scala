package dataset

import org.apache.spark.sql.SparkSession

object DataSetInit extends App {
  //System.setProperty("hadoop.home.dir", "C:\\Users\\ynebu\\workspace\\myWork\\spark-3.0.1-bin-hadoop2.7\\bin");
  System.setProperty("hadoop.home.dir", "C:\\Users\\ynebu\\workspace\\myWork\\hadoop-2.8.5\\bin");
  
  val spark = SparkSession
    .builder()
    .appName("Spark SQL basic example")
    .config("spark.some.config.option", "some-value")
    .getOrCreate()
}