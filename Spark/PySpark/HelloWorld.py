import pyspark
from pyspark.sql import SparkSession

print('Hello World')

spark = SparkSession.builder.appName("HelloWorld").master("local").getOrCreate()

spark.read.format("csv").load("a.csv").show(10, False)

