from pyspark.sql.session import SparkSession
import pyspark.sql.functions as F
import pandas as pd

def readData(date, hour):
    return spark.read.format('csv').load('to_path/'+date+'/'+hour+'/')

def writeHDFS(data, date, hour):
    data.coalesce(1).write.mode('overwrite') \
        .option('sep', '\t') \
        .option('nullValue','') \
        .option('emptyValue','').csv('hdfs://from_path'+date+'/'+hour+'/')

spark = SparkSession.builder.appName('collector_recollect').getOrCreate()

date_list = ['01', '02']
hour_list = ['00', '01']

for date in date_list:
    for hour in hour_list:
        org_data = readData(date, hour)

        list = []

        tmp_list = org_data.collect()
        for tmp in tmp_list:
            list.append(str(tmp['_c0']).split('\t'))

        pdf = pd.DataFrame(list)
        spf = spark.createDataFrame(pdf)
        data = spf.filter((spf['3'] != '33') & (spf['3'] != '34'))
        writeHDFS(data, date, hour)

spark.stop()