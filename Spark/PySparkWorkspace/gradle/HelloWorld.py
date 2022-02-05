from pyspark.sql import SparkSession

print('Hello World')

spark = SparkSession.builder.appName("IntelliJ").master("local").getOrCreate()

spark.read.format("csv").load("b.csv").show(10, False)