package airline;

import java.io.IOException;

import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import airline.AirlinePerformanceParser;
 
public class DelayCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{
 
    // �� ��� ��
    private final static IntWritable outputValue = new IntWritable(1);
     
    // �� ��� Ű
    private Text outputKey = new Text();
     
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        AirlinePerformanceParser parser = new AirlinePerformanceParser(value);
         
        // ���Ű ����
        outputKey.set(parser.getYear() + "," + parser.getMonth());
         
        if (parser.getDepartureDelayTime() > 0) {
            // ��� ������ ����
            context.write(outputKey, outputValue);
        }
    }
}