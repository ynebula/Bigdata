from pyspark.sql import SparkSession

spark = SparkSession.builder.appName('IntelliJ').master('local').getOrCreate()
spark.read.format('text').load('/data/inputData.txt').show(10, False)



# list = []
# tmp_list = data.collect()
# for tmp in tmp_list:
#     list.append(str(tmp['value']).split(','))
#
# print(list)




# print('Hello World!!')

# spark.read.format('csv').csv('/data/inputData.txt').show(10, False)
# spark.read.load('/data/inputData.txt').show(10, False)
